package ru.skholstinin.testtask.dao;

import ru.skholstinin.testtask.pojo.Cat;
import ru.skholstinin.testtask.pojo.User;

import java.util.ArrayList;

public interface LikedCatDao {
    void addNewLikeCat(Cat cat, User user);

    ArrayList<Integer> getCatsIdByUserId(int id);

    boolean checkExistencePair(Cat cat, User user);

    int getCntRecords();
}
