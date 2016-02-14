package com.DAO;

import com.Model.Book;
import com.Model.Genre;

import java.util.List;

/**
 * Created by dexter on 2/14/16.
 */
public interface GenreDAO extends BaseDAO<Genre> {
    List<Genre> allList();

    Genre getElementById(Long id);

    void remove(Long id);

    void save(Genre genre);

    void update(Genre genre);

    Boolean ifExists(String name);
}
