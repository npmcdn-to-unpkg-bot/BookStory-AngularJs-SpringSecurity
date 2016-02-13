package com.DAOImpl;

import com.DAO.UserDAO;
import com.Model.Book;
import com.Model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by dexter on 2/12/16.
 */
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

    @Override
    public List<Book> allList() {
        return null;
    }

    @Override
    public List<User> searchList(String text) {
        return null;
    }

    @Override
    public User getElementById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public Boolean ifExists(User user) {
        return null;
    }
}
