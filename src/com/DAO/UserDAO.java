package com.DAO;

import com.Model.Book;
import com.Model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by dexter on 2/12/16.
 */
public interface UserDAO extends BaseDAO<User> {
    List<Book> allList();

    List<User> searchList(String text);

    User getElementById(Long id);

    void remove(Long id);

    void save(User user);

    void update(User user);

    Boolean ifExists(User user);
}
