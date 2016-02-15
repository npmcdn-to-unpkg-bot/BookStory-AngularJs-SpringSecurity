package com.DAOImpl;

import com.DAO.GenreDAO;
import com.Model.Genre;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        return (Genre) session.get(Genre.class, id);
    }

    @Override
    public void remove(Long id) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Genre genre = getElementById(id);
        if (genre != null) {
            session.delete(genre);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void save(Genre genre) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        System.out.println(genre.getName());
        session.save(genre);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(Genre genre) {
    }

    @SuppressWarnings("unchecked")
    public Boolean ifExists(String name) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        String sql = ("select * from genres WHERE genres.name = '" + name + "'");
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        sqlQuery.addEntity(Genre.class);
        List<Genre> genres = sqlQuery.list();
        transaction.commit();
        session.close();
        return genres.size() > 0;
    }
}
