package com.DAOImpl;

import com.DAO.UserDAO;
import com.Model.Book;
import com.Model.User;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by dexter on 2/12/16.
 */
@Repository("UserDAO")
public class UserDAOImpl implements UserDAO {

    Session session;
    Transaction transaction;

    @Override
    public List<User> allList() {
        return null;
    }

    @Override
    public User getElementById(Long id) {
        return null;
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public void save(User user) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        System.out.println(user.getId());
        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(User user) {

    }

    @Override
    public Boolean ifExists(String email) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        String sql = ("select * from users WHERE users.email = '" + email + "'");
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        sqlQuery.addEntity(User.class);
        List<User> users = sqlQuery.list();
        transaction.commit();
        session.close();
        return users.size() > 0;
    }

    @SuppressWarnings("unchecked")
    public Boolean ifExists(String email, String password) {
        Configuration configuration = new AnnotationConfiguration();
        session = configuration.configure().buildSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<User> users = session.createSQLQuery("SELECT *FROM Users u WHERE u.email = '" + email +
                "' AND u.password = '" + password + "'").addEntity(User.class).list();
        transaction.commit();
        session.close();
        return users.size() > 0;
    }
}
