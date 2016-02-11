package com.DAO;

import com.Model.Book;

import java.util.List;

/**
 * Created by dexter on 2/12/16.
 */
public interface BaseDAO<T> {

    List<T> allList();

    T getElementById(Long id);

    void remove(Long id);

    void save(T object);

    void update(T object);
}
