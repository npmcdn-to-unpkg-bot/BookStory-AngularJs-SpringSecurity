package com.ServiceImpl;

import com.DAO.AuthorDAO;
import com.Model.Author;
import com.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dexter on 2/14/16.
 */
@Service("AuthorService")
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorDAO authorDAO;

    @Override
    public List<Author> allList() {
        return authorDAO.allList();
    }

    @Override
    public Author getElementById(Long id) {
        return authorDAO.getElementById(id);
    }

    @Override
    public void remove(Long id) {
        authorDAO.remove(id);
    }

    @Override
    public void save(Author author) {
        authorDAO.save(author);
    }

    @Override
    public void update(Author author) {
        authorDAO.update(author);
    }

    @Override
    public Boolean ifExists(String firstName, String lastName) {
        return null;
    }

    @Override
    public Boolean ifExists(String name) {
        return authorDAO.ifExists(name);
    }
}
