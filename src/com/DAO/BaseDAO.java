package com.DAO;

import com.Model.Book;

import java.util.List;
import java.util.Set;

/**
 * Created by dexter on 2/12/16.
 */
public interface BaseDAO<T> {

    List<Book> allList();

    T getElementById(Long id);

    void remove(Long id);

    void save(T object);

    void update(T object);

    Boolean ifExists(T object);
}
