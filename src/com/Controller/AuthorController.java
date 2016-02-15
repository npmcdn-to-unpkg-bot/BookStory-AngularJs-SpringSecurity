package com.Controller;

import com.Model.Author;
import com.Service.AuthorService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by dexter on 2/14/16.
 */
@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = "/allList")
    public String allList() {
        List<Author> authors = authorService.allList();
        Gson gson = new Gson();
        return gson.toJson(authors, authors.getClass());
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void save(HttpServletRequest request) {
        String firstName = request.getParameter("first");
        String lastName = request.getParameter("lastName");
        Author author = new Author(firstName, lastName);
        authorService.save(author);
    }
}
