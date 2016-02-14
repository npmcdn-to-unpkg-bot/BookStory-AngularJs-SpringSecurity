package com.DAOImpl;

import com.DAO.AuthorDAO;
import com.Model.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dexter on 2/14/16.
 */
@Repository("AuthorDAO")
public class AuthorDAOImpl implements AuthorDAO {
    Session session;
    Transaction transaction;

    @SuppressWarnings("unchecked")
    public List<Author> allList() {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Author> authors = session.createQuery("from Author ").list();
        transaction.commit();
        session.close();
        return authors;
    }

    @Override
    public Author getElementById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void save(Author author) {

    }

    @Override
    public void update(Author author) {

    }

    @Override
    public Boolean ifExists(String name) {
        return null;
    }
}
