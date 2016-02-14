package com.ServiceImpl;

import com.DAO.UserDAO;
import com.Model.Book;
import com.Model.User;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dexter on 2/12/16.
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public List<User> allList() {
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
        userDAO.save(user);

    }

    @Override
    public void update(User user) {

    }

    @Override
    public Boolean ifExists(String email) {
        return userDAO.ifExists(email);
    }

    @Override
    public Boolean ifExists(String email, String password) {
        return userDAO.ifExists(email, password);
    }

}
