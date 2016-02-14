package com.DAO;

import com.Model.Book;

import java.util.List;
import java.util.Set;

/**
 * Created by dexter on 2/6/16.
 */
public interface BookDAO extends BaseDAO<Book> {
    List<Book> allList();

    Book getElementById(Long id);

    void remove(Long id);

    void save(Book book);

    void update(Book book);

    Boolean ifExists(String name);
}
