package com.Controller;

import com.Model.CustomUser;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUser customUser = null;
        if (principal instanceof CustomUser) {
            customUser = (CustomUser) principal;
        }
        String name = customUser.getUsername();
        ModelMap modelMap = new ModelMap();
        modelMap.put("username", name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(modelMap);
        modelAndView.setViewName("WEB-INF/pages/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/register")
    public ModelAndView register() {
        return new ModelAndView("WEB-INF/pages/register");
    }

    @RequestMapping(value = "/users")
    public ModelAndView user() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUser customUser = null;
        if (principal instanceof CustomUser) {
            customUser = (CustomUser) principal;
        }
        assert customUser != null;
        String name = customUser.getUsername();
        ModelMap modelMap = new ModelMap();
        modelMap.put("username", name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(modelMap);
        modelAndView.setViewName("WEB-INF/pages/user");
        return modelAndView;
    }

    @RequestMapping(value = "users/orderlist")
    public ModelAndView orders() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUser customUser = null;
        if (principal instanceof CustomUser) {
            customUser = (CustomUser) principal;
        }
        assert customUser != null;
        String name = customUser.getUsername();
        System.out.println(name);
        ModelMap modelMap = new ModelMap();
        modelMap.put("username", name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(modelMap);
        modelAndView.setViewName("WEB-INF/pages/orders");
        return modelAndView;
    }

    @RequestMapping(value = "/accessDenied")
    public ModelAndView accessDenied() {
        return new ModelAndView("WEB-INF/pages/403");
    }

    @RequestMapping(value = "/error")
    public ModelAndView error() {
        return new ModelAndView("WEB-INF/pages/error");
    }

    @RequestMapping(value = "/canvas")
    public ModelAndView canvas() {
        return new ModelAndView("WEB-INF/pages/canvas");
    }
}
