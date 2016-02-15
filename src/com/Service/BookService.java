package com.Service;

import com.Model.Author;
import com.Model.Book;
import com.Model.Genre;

import java.util.List;
import java.util.Set;

/**
 * Created by dexter on 2/6/16.
 */
public interface BookService extends BaseService<Book> {
    List<Book> allList();

    Book getElementById(Long id);

    void remove(Long id);

    void save(Book book, Genre genre, Author author);

    void update(Book book);

    Boolean ifExists(String name);

    Long order(Long id);

}
