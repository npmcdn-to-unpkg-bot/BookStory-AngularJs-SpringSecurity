package com.Service;

import com.Model.Author;

import java.util.List;

/**
 * Created by dexter on 2/14/16.
 */
public interface AuthorService extends BaseService<Author> {
    List<Author> allList();

    Author getElementById(Long id);

    void remove(Long id);

    void save(Author author);

    void update(Author author);

    Boolean ifExists(String name);
}
