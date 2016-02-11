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
    public List<Book> allEmployeeList() {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        List employees = session.createQuery("from Employee ").list();
        transaction.commit();
        session.close();
        return employees;
    }

    @SuppressWarnings("unchecked")
    public List<Book> searchEmployeeList(String text) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session.createQuery("from Employee where upper(firstName) like '%" + text.toUpperCase() + "%'" +
                "or upper(lastName) like '%" + text.toUpperCase() + "%'"
                + "or upper(mobile) like '%" + text.toUpperCase() + "%'"
                + "or upper(email) like '%" + text.toUpperCase() + "%'"
                + "or upper(state) like '%" + text.toUpperCase() + "%'"
        ).list();
    }

    public Book getElementById(Long id) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        return (Book) session.get(Book.class, id);
    }

    public void removeEmployee(Long id) {
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

    public void saveEmployee(Book book) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    public void updateEmployee(Book book) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        Book updateBook = getElementById(book.getId());
        updateBook.setId(book.getId());
        updateBook.setFirstName(book.getFirstName());
        updateBook.setLastName(book.getLastName());
        updateBook.setEmail(book.getEmail());
        updateBook.setMobile(book.getMobile());
        updateBook.setPassword(book.getPassword());
        updateBook.setState(book.getState());
        session.update(updateBook);
        transaction.commit();
        session.close();
    }
}