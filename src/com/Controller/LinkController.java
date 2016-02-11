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
}
