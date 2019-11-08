package ru.skholstinin.testtask.dao;

import ru.skholstinin.testtask.pojo.Cat;

public interface CatDao {
    Cat getCatByName(String name);

    Cat getCatById(int id);
}
