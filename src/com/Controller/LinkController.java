package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping(value = "/orderOfUser")
    public ModelAndView orderOfUser() {
        return new ModelAndView("WEB-INF/pages/orderOfUser");
    }

    @RequestMapping(value = "/error")
    public ModelAndView error() {
        return new ModelAndView("WEB-INF/pages/error");
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("username", "");
        response.sendRedirect("/");
    }
}
