package com.Controller;

import com.Model.Author;
import com.Model.Book;
import com.Model.Genre;
import com.Service.AuthorService;
import com.Service.BookService;
import com.Service.GenreService;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by dexter on 2/6/16.
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/add")
    public void addBook(HttpServletRequest request) {
        String name = request.getParameter("name");
        Long author_id = Long.parseLong(request.getParameter("author_id"));
        Long genre_id = Long.parseLong(request.getParameter("genre_id"));
        String language = request.getParameter("language");
        String created_date = request.getParameter("publish_date");
        Book book = new Book(name, language, created_date);
        book.setOrder_count(0L);
        Genre genre = genreService.getElementById(genre_id);
        Author author = authorService.getElementById(author_id);
        Boolean exists = bookService.ifExists(name);
        if (!exists)
            bookService.save(book, genre, author);
        else {

        }
    }

    @RequestMapping(value = "/allList")
    public String allListEmployee() {
        List<Book> employees = bookService.allList();
        Gson gson = new Gson();
        return gson.toJson(employees, employees.getClass());
    }

    @RequestMapping(value = "/delete")
    public void deleteEmployee(HttpServletRequest request) {
        String i = request.getParameter("id");
        Long id = Long.parseLong(i);
        bookService.remove(id);
    }

    @RequestMapping(value = "/getElementById")
    public Book getElementById(HttpServletRequest request) {
        String i = request.getParameter("id");
        Long id = Long.parseLong(i);
        return bookService.getElementById(id);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Long order(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return bookService.order(id);
    }
}
