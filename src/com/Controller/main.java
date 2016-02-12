package com.Controller;

import com.Model.Book;
import com.Model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by dexter on 2/12/16.
 */
public class main {
    public static void main(String[] args) {
        User user = new User("Bahodir", "Boydedayev", "+998943009394", "10");
        Book book = new Book("Java", "en", "10/10/2010");
        book.getUsers().add(user);

        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
