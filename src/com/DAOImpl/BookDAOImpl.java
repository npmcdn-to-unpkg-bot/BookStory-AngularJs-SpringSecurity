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
    public List<Book> allBookList() {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        List employees = session.createQuery("from Book ").list();
        transaction.commit();
        session.close();
        return employees;
    }

    @SuppressWarnings("unchecked")
    public List<Book> searchBookList(String text) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session.createQuery("from Book where upper(name) like '%" + text.toUpperCase() + "%'" +
                "or upper(genre_id) like '%" + text.toUpperCase() + "%'"
                + "or upper(language) like '%" + text.toUpperCase() + "%'"
                + "or upper(order_count) like '%" + text.toUpperCase() + "%'"
                + "or upper(created_date) like '%" + text.toUpperCase() + "%'"
        ).list();
    }

    public Book getElementById(Long id) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        return (Book) session.get(Book.class, id);
    }

    public void removeBook(Long id) {
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

    public void saveBook(Book book) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void updateBook(Book book) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Book updateBook = getElementById(book.getId());
        updateBook.setId(book.getId());
        updateBook.setName(book.getName());
        updateBook.setAuthor_id(book.getAuthor_id());
        updateBook.setCreated_date(book.getCreated_date());
        updateBook.setLanguage(book.getLanguage());
        session.update(updateBook);
        transaction.commit();
        session.close();
    }
}