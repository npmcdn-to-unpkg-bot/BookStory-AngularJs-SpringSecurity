package com.Controller;

import com.Model.Book;
import com.Service.BookService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by dexter on 2/6/16.
 */
@RestController
@RequestMapping(value = "/books/")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add")
    public Book addBook(HttpServletRequest request) {
        String name = request.getParameter("name");
        Long author_id = Long.parseLong(request.getParameter("author_id"));
        Long genre_id = Long.parseLong(request.getParameter("genre_id"));
        String language = request.getParameter("language");
        String created_date = request.getParameter("created_date");
        Book book;
        book = new Book(name, language, created_date);
        bookService.save(book);
        return book;
    }

    @RequestMapping(value = "/allList")
    public String allListEmployee() {
        List employees = bookService.allList();
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

    @RequestMapping(value = "/getSearchEmployees")
    public String getSearchEmployee(HttpServletRequest request) {
        String text = request.getParameter("text");
        List<Book> bookList = bookService.searchList(text);
        if (bookList != null) {
            Gson gson = new Gson();
            return gson.toJson(bookList, bookList.getClass());
        } else {
            return "not found employee";
        }
    }
}
