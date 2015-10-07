package com.olol.spring.web.controllers;

import com.olol.spring.web.dao.Offer;
import com.olol.spring.web.service.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author fatu
 */
@Controller
public class OffersController {

    private OffersService offersService;

    @Autowired
    public void setOffersService(final OffersService offersService) {
        this.offersService = offersService;
    }

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String showTest(Model model, @RequestParam("id") String id) {

        System.out.println("Id is: " + id);

        return "home";
    }

    @RequestMapping("/offers")
    public String showOffers(Model model) {

        List<Offer> offers = offersService.getCurrent();

        model.addAttribute("offers", offers);

        return "offers";
    }

    @RequestMapping("/createoffer")
    public String createOffer(Model model) {

        return "createoffer";
    }

}
