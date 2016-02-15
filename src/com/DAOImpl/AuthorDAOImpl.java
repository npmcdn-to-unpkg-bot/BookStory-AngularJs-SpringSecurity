package com.DAOImpl;

import com.DAO.AuthorDAO;
import com.Model.Author;
import com.sun.deploy.config.Config;
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
        Configuration configuration = new Configuration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(author);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public Boolean ifExists(String name) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public Boolean ifExists(String firstName, String lastName) {
        Configuration configuration = new Configuration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Author> authors = session.createSQLQuery("select * from authors WHERE authors.firstname ='" + firstName +
                "' AND authors.lastname = '" + lastName + "'").addEntity(Author.class).list();
        transaction.commit();
        session.close();
        return authors.size() > 0;
    }
}
