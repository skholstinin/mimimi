package ru.skholstinin.testtask.service;

import org.springframework.security.access.annotation.Secured;
import ru.skholstinin.testtask.pojo.User;
import ru.skholstinin.testtask.security.Actions;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);

    User getUserById(int id);

}
