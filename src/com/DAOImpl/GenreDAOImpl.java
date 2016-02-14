package com.DAOImpl;

import com.DAO.GenreDAO;
import com.Model.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dexter on 2/14/16.
 */
 @Repository(value = "GenreDAO")
public class GenreDAOImpl implements GenreDAO {
    @Override
    public List<Genre> allList() {
        return null;
    }

    @Override
    public Genre getElementById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void save(Genre genre) {

    }

    @Override
    public void update(Genre genre) {

    }

    @Override
    public Boolean ifExists(String name) {
        return null;
    }
}
