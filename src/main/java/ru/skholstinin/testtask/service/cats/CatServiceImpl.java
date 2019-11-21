package ru.skholstinin.testtask.service.cats;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skholstinin.testtask.dao.CatDao;
import ru.skholstinin.testtask.dao.LikedCatDao;
import ru.skholstinin.testtask.pojo.Cat;
import ru.skholstinin.testtask.service.user.UserServiceImpl;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class CatServiceImpl implements CatService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private final CatDao catDao;
    private final LikedCatDao likedCatDao;

    @Autowired
    public CatServiceImpl(CatDao catDao, LikedCatDao likedCatDao) {
        this.catDao = catDao;
        this.likedCatDao = likedCatDao;
    }

    @Transactional
    @Override
    public Cat getCatByName(String name) {
        return null;
    }

    @Transactional
    @Override
    public Cat getCatById(int id) {
        return catDao.getCatById(id);
    }

    @Transactional
    @Override
    public ArrayList<Cat> getRandomPairCats() {
        ArrayList<Cat> listCat = catDao.getRandomPairCats();
        return listCat;
    }

    @Transactional
    @Override
    public boolean updateCat(Cat cat) {
        return catDao.updateCat(cat);
    }

    @Transactional
    @Override
    public ArrayList<Cat> getMostLikedCats() {
        return catDao.getMostLikedCats();
    }
}
