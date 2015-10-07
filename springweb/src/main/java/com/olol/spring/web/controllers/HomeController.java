package com.olol.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author boaztu
 */
@Controller
public class HomeController {

    @RequestMapping
    public String showHome() {

        return "home";
    }
}
