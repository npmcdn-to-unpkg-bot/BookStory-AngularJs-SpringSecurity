package com.DAOImpl;

import com.DAO.BookDAO;
import com.Model.Book;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dexter on 2/7/16.
 */
@Repository("BookDAO")
public class BookDAOImpl implements BookDAO {

    Session session;
    Transaction transaction;

    @SuppressWarnings("unchecked")
    public List<Book> allList() {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        String sql = ("select b.id,  b.author_id,  b.order_count, a.firstname || ',' || a.lastname AS FIO, b.name, b.genre_id, g.name, b.language, b.created_date from books b" +
                " inner join authors a ON a.id = b.author_id " +
                " inner  join genres g ON g.id = b.genre_id");

        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        sqlQuery.addEntity(Book.class);
        List<Book> books = sqlQuery.list();
        transaction.commit();
        session.close();
        return books;
    }

    public Book getElementById(Long id) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        return (Book) session.get(Book.class, id);
    }

    public void remove(Long id) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Book book = getElementById(id);
        if (book != null) {
            session.delete(book);
        }
        transaction.commit();
        session.close();
    }

    public void save(Book book) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void update(Book book) {}

    @Override
    public Boolean ifExists(String email) {
        return null;
    }
}