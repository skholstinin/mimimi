package ru.skholstinin.testtask.dao;

import ru.skholstinin.testtask.pojo.User;

public interface UserDao {
    User getUserByName(String name);

    User getUserBySurname(String surname);

    User getUserById(int id);

    User getUserByLogin(String login);
}
