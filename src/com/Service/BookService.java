package com.Service;

import com.Model.Book;

import java.util.List;

/**
 * Created by dexter on 2/6/16.
 */
public interface BookService {
    List<Book> allEmployeeList();
    List<Book> searchEmployeeList(String text);
    Book getElementById(Long id);
    void removeEmployee(Long id);
    void saveEmployee(Book book);
    void updateEmployee(Book book);
}
