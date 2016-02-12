package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by dexter on 2/7/16.
 */
@Controller
public class LinkController {

    @RequestMapping(value = "/")
    public ModelAndView mainPage() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("WEB-INF/pages/login");
    }

    @RequestMapping(value = "/admin")
    public ModelAndView admin() {
        return new ModelAndView("WEB-INF/pages/admin");
    }

    @RequestMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("WEB-INF/pages/register");
    }

    @RequestMapping(value = "/user")
    public ModelAndView user() {
        return new ModelAndView("WEB-INF/pages/user");
    }

    @RequestMapping(value = "orderOfUser")
    public ModelAndView orderOfUser(){
        return new ModelAndView("WEB-INF/pages/orderOfUser");
    }
}
