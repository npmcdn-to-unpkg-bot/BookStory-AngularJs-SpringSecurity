package com.DAOImpl;

import com.DAO.BookDAO;
import com.Model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dexter on 2/7/16.
 */
@Repository("EmployeeDAO")
public class BookDAOImpl implements BookDAO {

    Session session;
    Transaction transaction;

    @SuppressWarnings("unchecked")
    public List<Book> allList() {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();

        List books = session.createSQLQuery("select b.id, author_id, genre_id, name, language, created_date from Book  AS b" +
                "inner join Author ON Author.id = b.id " +
                " inner  join Genre ON Genre.id = b .id").list();
        transaction.commit();
        session.close();
        return books;
    }

    @SuppressWarnings("unchecked")
    public List<Book> searchList(String text) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session.createQuery("from Book where upper(name) like '%" + text.toUpperCase() + "%'" +
                "or upper(name) like '%" + text.toUpperCase() + "%'"
                + "or upper(language) like '%" + text.toUpperCase() + "%'"
                + "or upper(created_date) like '%" + text.toUpperCase() + "%'"
        ).list();
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

    public void update(Book book) {
    }

    @Override
    public Boolean ifExists(Book book) {
        return null;
    }
}