package ru.skholstinin.testtask.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.skholstinin.testtask.pojo.Cat;
import ru.skholstinin.testtask.pojo.User;
import ru.skholstinin.testtask.security.Actions;
import ru.skholstinin.testtask.security.SecurityUtils;
import ru.skholstinin.testtask.service.CatService;
import ru.skholstinin.testtask.service.LikedCatService;
import ru.skholstinin.testtask.service.UserService;

import java.util.ArrayList;

@Controller
public class VotePageController {
    private static final Logger logger = Logger.getLogger(VotePageController.class);
    private final CatService catService;
    private final LikedCatService likedCatService;
    private final UserService userService;

    @Autowired
    public VotePageController(CatService catService, LikedCatService likedCatService, UserService userService) {
        this.catService = catService;
        this.likedCatService = likedCatService;
        this.userService = userService;
    }


    @Secured({Actions.USER_DASHBOARD_VIEW, Actions.USER_ANIMALS_VIEW, Actions.USER_DASHBOARD_EDIT})
    @RequestMapping(value = "/votepage", method = RequestMethod.GET)
    public String getVotePage(Model model) {
        User user = userService.getUserByLogin(SecurityUtils.getAuthenticatedUsername());
        model.addAttribute("cats", catService.getRandomPairCats());
        model.addAttribute("user", user);
        logger.debug(model.toString());
        return "votepage";
    }

    @Secured({Actions.USER_DASHBOARD_VIEW, Actions.USER_ANIMALS_VIEW, Actions.USER_DASHBOARD_EDIT})
    @RequestMapping(value = "/voteresult", method = RequestMethod.GET)
    public String voteResult(Model model) {
        User user = userService.getUserByLogin(SecurityUtils.getAuthenticatedUsername());
        model.addAttribute("cats", catService.getRandomPairCats());
        model.addAttribute("user", user);
        logger.debug(model.toString());
        return "voteresult";
    }

    @Secured({Actions.USER_DASHBOARD_VIEW, Actions.USER_ANIMALS_VIEW, Actions.USER_DASHBOARD_EDIT})
    @RequestMapping(value = "/voteaction/{user_id}/{cat_id}", method = RequestMethod.GET)
    public String voteAction(@PathVariable("cat_id") int cat_id, @PathVariable("user_id") int user_id, Model model) {
        Cat cat = catService.getCatById(cat_id);
        User user = userService.getUserById(user_id);
        cat.setCnt_likes(cat.getCnt_likes() + 1);
        catService.updateCat(cat);
        likedCatService.addNewLikeCat(cat, user);
        ArrayList<Cat> llistCat = catService.getRandomPairCats();
        if (likedCatService.getCntRecords() < 12) {
            model.addAttribute("cats", llistCat);
            model.addAttribute("user", user);
            return "redirect:/votepage";
        }
        return "voteresult";
    }
}
