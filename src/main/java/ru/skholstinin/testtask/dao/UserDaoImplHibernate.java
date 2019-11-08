package ru.skholstinin.testtask.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.skholstinin.testtask.pojo.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class UserDaoImplHibernate implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImplHibernate.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public User getUserBVyName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "name", name);

    }

    @Override
    public User getUserBySurname(String surname) {
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "surname", surname);
    }

    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        return getUserByCriteria(session, "login", login);
    }

    private User getUserByCriteria(Session session, String criteria, String value) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get(criteria), value));
        Query<User> q = session.createQuery(query);
        List<User> resultList = q.getResultList();
        if (resultList.isEmpty()) {
            return null;
        }
        return resultList.get(0);
    }
}
