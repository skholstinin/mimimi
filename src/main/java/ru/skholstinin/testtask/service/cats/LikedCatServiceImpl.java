package ru.skholstinin.testtask.service.cats;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skholstinin.testtask.dao.LikedCatDao;
import ru.skholstinin.testtask.pojo.Cat;
import ru.skholstinin.testtask.pojo.User;
import ru.skholstinin.testtask.service.user.UserServiceImpl;

import java.util.ArrayList;

@Service
public class LikedCatServiceImpl implements LikedCatService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private final LikedCatDao likedCatDao;

    @Autowired
    public LikedCatServiceImpl(LikedCatDao likedCatDao) {
        this.likedCatDao = likedCatDao;
    }

    @Transactional
    @Override
    public void addNewLikeCat(Cat cat, User user) {
        likedCatDao.addNewLikeCat(cat, user);
    }

    @Transactional
    @Override
    public ArrayList<Integer> getCatsIdByUserId(int id) {
        return likedCatDao.getCatsIdByUserId(id);
    }

    @Transactional
    @Override
    public boolean checkExistencePair(Cat cat, User user) {
        return likedCatDao.checkExistencePair(cat, user);
    }

    @Transactional
    @Override
    public int getCntRecords() {
        return likedCatDao.getCntRecords();
    }
}

