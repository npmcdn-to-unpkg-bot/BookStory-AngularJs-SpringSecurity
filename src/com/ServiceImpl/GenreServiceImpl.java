package com.ServiceImpl;

import com.DAO.GenreDAO;
import com.Model.Genre;
import com.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by dexter on 2/14/16.
 */
@Service("GenreService")
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreDAO genreDAO;

    @Override
    public List<Genre> allList() {
        return genreDAO.allList();
    }

    @Override
    public Genre getElementById(Long id) {
        return genreDAO.getElementById(id);
    }

    @Override
    public void remove(Long id) {
        genreDAO.remove(id);
    }

    @Override
    public void save(Genre genre) {
        genreDAO.save(genre);
    }

    @Override
    public void update(Genre genre) {
        genreDAO.update(genre);
    }

    @Override
    public Boolean ifExists(String name) {
        return genreDAO.ifExists(name);
    }
}
