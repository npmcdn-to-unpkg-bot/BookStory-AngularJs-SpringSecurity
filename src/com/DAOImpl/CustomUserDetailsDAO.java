package com.DAOImpl;

import com.Model.CustomUser;
import com.Model.Role;
import com.Model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dexter on 2/19/16.
 */
@Repository
public class CustomUserDetailsDAO {

    @SuppressWarnings("unchecked")
    public CustomUser loadUserByUsername(final String email) {
        Configuration configuration = new AnnotationConfiguration();
        Session session = configuration.configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        List<User> list = session.createQuery("from User where email = '" + email + "'").list();
        if (list.isEmpty()) {
            CustomUser customUser = new CustomUser(-1L, "-1", "-1", "-1", "-1", false);
            transaction.commit();
            session.close();
            return customUser;
        } else {
            User user = list.get(0);
            List<Role> roles = session.createQuery("from Role where role_email = '" + email + "'").list();
            CustomUser customUser = new CustomUser(user.getId(), user.getName(), user.getPassword(), user.getEmail(), user.getMobile(), true);
            customUser.setAuthorities(roles);
            transaction.commit();
            session.close();

            return customUser;
        }
    }
}
