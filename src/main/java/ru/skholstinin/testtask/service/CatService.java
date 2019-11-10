package ru.skholstinin.testtask.service;

import ru.skholstinin.testtask.pojo.Cat;

import java.util.ArrayList;

public interface CatService {
    Cat getCatByName(String name);

    Cat getCatById(int id);

    ArrayList<Cat> getRandomPairCats();

    boolean updateCat(Cat cat);
}