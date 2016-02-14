package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dexter on 2/14/16.
 */
@Controller
@RequestMapping(value = "/genres")
public class GenreController {

    @RequestMapping(value = "/allList")
    public String allList() {

    }
}
