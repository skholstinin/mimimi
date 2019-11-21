package ru.skholstinin.testtask.service.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skholstinin.testtask.dao.UserDao;
import ru.skholstinin.testtask.pojo.User;


@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Transactional
    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public void addUser(String name, String surName, String login, String role, String password, boolean isEnabled) {

    }

}
