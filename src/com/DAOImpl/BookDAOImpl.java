package com.DAOImpl;

import com.DAO.BookDAO;
import com.Model.*;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

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
                " inner  join genres g ON g.id = b.genre_id ORDER BY b.id ASC ");

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

    @Override
    public void removeOneBook(Long bookId, String username) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        User user = (User) session.createQuery("from User where email='" + username + "'").list().get(0);
        Long user_id = user.getId();
        Query query = session.createQuery("from Order o where o.book_id=:b_id and o.user_id =:u_id")
                .setParameter("b_id", bookId)
                .setParameter("u_id", user_id);
        if (query.list().size() > 0) {
            Order order = (Order) query.list().get(0);
            session.delete(order);
            transaction.commit();
            session.close();
        } else {
            transaction.commit();
            session.close();
        }
    }

    @Override
    public void save(Book book, Genre genre, Author author) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        book.setGenre(genre);
        book.setAuthor(author);
        session.save(book);
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

    @SuppressWarnings("unchecked")
    public Boolean ifExists(String name) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery("SELECT *FROM books AS b WHERE b.name = '" + name + "'");
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        sqlQuery.addEntity(Book.class);
        List<Book> books = sqlQuery.list();
        return books.size() > 0;
    }

    @SuppressWarnings("unchecked")
    public void order(Long bookId, String username) {
        Configuration configuration = new Configuration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        User user = (User) session.createQuery("from User where email='" + username + "'").list().get(0);
        Long user_id = user.getId();
        Query query = session.createQuery("from Order o where o.book_id=:b_id and o.user_id =:u_id")
                .setParameter("b_id", bookId)
                .setParameter("u_id", user_id);

        Configuration configuration1 = new AnnotationConfiguration();
        Session session1 = configuration1.configure().buildSessionFactory().openSession();
        Transaction transaction1 = session1.beginTransaction();
        Book book = getElementById(bookId);
        book.setOrder_count(book.getOrder_count() + 1);
        session1.update(book);
        transaction1.commit();
        session1.close();

        if (query.list().size() == 0) {
            Order order = new Order(user_id, bookId);
            session.save(order);
            transaction.commit();
            session.close();
        } else {
            transaction.commit();
            session.close();
        }

    }

    @SuppressWarnings("unchecked")
    public List<Book> listBooksOfOneUser(String name) {
        Configuration configuration = new Configuration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        User user = (User) session.createQuery("from User where email='" + name + "'").list().get(0);
        List<Long> orders = session.createQuery("select o.book_id from Order o WHERE o.user_id = " + user.getId()).list();
        List<Book> books = session.createQuery("select b from Book b where b.id in (:s) order by b.id asc").setParameterList("s", orders).list();
        transaction.commit();
        session.close();
        return books;
    }
}