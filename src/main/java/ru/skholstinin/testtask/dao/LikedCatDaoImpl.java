package ru.skholstinin.testtask.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.skholstinin.testtask.pojo.Cat;
import ru.skholstinin.testtask.pojo.LikedCat;
import ru.skholstinin.testtask.pojo.User;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;


@Repository
@Transactional
public class LikedCatDaoImpl implements LikedCatDao {
    private static final Logger logger = Logger.getLogger(LikedCatDaoImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addNewLikeCat(Cat cat, User user) {
        Session session = sessionFactory.getCurrentSession();
        LikedCat likedCat = new LikedCat();
        likedCat.setCatsId(cat.getId());
        likedCat.setUserId(user.getId());
        session.save(likedCat);
    }

    @Override
    public ArrayList<Integer> getCatsIdByUserId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select * from liked_cats where user_id =: id");
        query.setParameter("id", id);
        ArrayList<Integer> list = (ArrayList<Integer>) query.getResultList();
        return list;
    }

    @Override
    public boolean checkExistencePair(Cat cat, User user) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select * from liked_cats where user_id =: user_id and cats_id =: cats_id ");
        query.setParameter("user_id", user.getId());
        query.setParameter("cats_id", cat.getId());
        ArrayList<Integer> list = (ArrayList<Integer>) query.getResultList();
        if (!list.isEmpty()) {
            return true;
        }
        return false;

    }

    @Override
    public int getCntRecords() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count (*) from LikedCat");
        logger.info("count records=" + (int) query.getFirstResult());
        return query.getFirstResult();
    }
}
