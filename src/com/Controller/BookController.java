package com.Controller;

import com.HashCode.MD5;
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
@RequestMapping(value = "/employee")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add")
    public Book addOrUpdateEmployee(HttpServletRequest request) {
        String hideId = request.getParameter("hideId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        password = MD5.getMD5(password);
        String state = request.getParameter("state");
        Book book;
        if (!(hideId.equals(""))) {
            Long id = Long.parseLong(hideId);
            book = new Book(id, firstName, lastName, mobile, email, password, state);
            bookService.updateEmployee(book);
        } else {
            book = new Book(firstName, lastName, mobile, email, password, state);
            bookService.saveEmployee(book);
        }
        return book;
    }

    @RequestMapping(value = "/allList")
    public String allListEmployee() {
        List employees = bookService.allEmployeeList();
        Gson gson = new Gson();
        return gson.toJson(employees, employees.getClass());
    }

    @RequestMapping(value = "/delete")
    public void deleteEmployee(HttpServletRequest request) {
        String i = request.getParameter("id");
        Long id = Long.parseLong(i);
        bookService.removeEmployee(id);
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
        List<Book> bookList = bookService.searchEmployeeList(text);
        if (bookList != null) {
            Gson gson = new Gson();
            return gson.toJson(bookList, bookList.getClass());
        } else {
            return "not found employee";
        }
    }
}
