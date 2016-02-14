package com.DAOImpl;

import com.DAO.GenreDAO;
import com.Model.Genre;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dexter on 2/14/16.
 */
@Repository(value = "GenreDAO")
public class GenreDAOImpl implements GenreDAO {
    Session session;
    Transaction transaction;

    @SuppressWarnings("unchecked")
    public List<Genre> allList() {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Genre> genres = session.createQuery("from Genre ").list();
        transaction.commit();
        session.close();
        return genres;
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
