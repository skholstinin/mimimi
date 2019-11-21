package ru.skholstinin.testtask.service.user;

import org.springframework.security.access.annotation.Secured;
import ru.skholstinin.testtask.pojo.User;
import ru.skholstinin.testtask.security.Actions;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);

    User getUserById(int id);

    void addUser(String name,
                 String surName,
                 String login,
                 String role,
                 String password,
                 boolean isEnabled);

}
