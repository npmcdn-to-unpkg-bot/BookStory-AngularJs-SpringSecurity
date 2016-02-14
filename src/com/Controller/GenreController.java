package com.Controller;

import com.Model.Genre;
import com.Service.GenreService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dexter on 2/14/16.
 */
@RestController
@RequestMapping(value = "/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @RequestMapping(value = "/allList")
    public String allList() {
        List<Genre> genres = genreService.allList();
        Gson gson = new Gson();
        return gson.toJson(genres);
    }
}
