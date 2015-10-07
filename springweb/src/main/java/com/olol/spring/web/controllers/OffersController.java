package com.olol.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author fatu
 */
@Controller
public class OffersController {

    @RequestMapping
    public String showHome(Model model) {

        model.addAttribute("name", "<b>Jobs</b>");
        return "home";
    }


//    @RequestMapping("/")
//    public ModelAndView showHome() {
//
//        ModelAndView mv = new ModelAndView("home");
//
//        Map<String, Object> model = mv.getModel();
//
//        model.put("name", "River");
//
//        return mv;
//    }

}
