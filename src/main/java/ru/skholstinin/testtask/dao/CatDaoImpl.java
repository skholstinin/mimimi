package ru.skholstinin.testtask.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.skholstinin.testtask.pojo.Cat;

import javax.transaction.Transactional;
import java.util.ArrayList;


@Repository
@Transactional
public class CatDaoImpl implements CatDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public ArrayList<Cat> getRandomPairCats() {
        ArrayList<Cat> catsPair = new ArrayList<>();
        int random1 = 0, random2 = 0;
        while (random1 == random2) {
            random1 = 1 + (int) (Math.random() * 13);
            random2 = 1 + (int) (Math.random() * 13);
        }
        catsPair.add(getCatById(random1));
        catsPair.add(getCatById(random2));
        return catsPair;
    }

    @Override
    public Cat getRandomCat() {
        int random = 1 + (int) (Math.random() * 13);
        return getCatById(random);
    }

    @Override
    public Cat getCatByName(String name) {
        return null;
    }

    @Override
    public Cat getCatById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Cat.class, id);
    }

    @Override
    public boolean updateCat(Cat cat) {
        Session session = sessionFactory.getCurrentSession();
        if (cat.getId() > 0) {
            session.update(cat);
        }
        return true;
    }

}
