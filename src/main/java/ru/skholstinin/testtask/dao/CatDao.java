package ru.skholstinin.testtask.dao;

import ru.skholstinin.testtask.pojo.Cat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface CatDao {
    ArrayList<Cat> getRandomPairCats();

    Cat getRandomCat();
    Cat getCatByName(String name);

    Cat getCatById(int id);

    boolean updateCat(Cat cat);
}
