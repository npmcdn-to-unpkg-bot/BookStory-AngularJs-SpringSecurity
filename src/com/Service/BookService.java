package com.Service;

import com.Model.Book;

import java.util.List;

/**
 * Created by dexter on 2/6/16.
 */
public interface BookService {
    List<Book> allBookList();
    List<Book> searchBookList(String text);
    Book getElementById(Long id);
    void removeBook(Long id);
    void saveBook(Book book);
    void updateBook(Book book);
}
