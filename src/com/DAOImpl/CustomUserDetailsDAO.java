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
        User user = list.get(0);
        CustomUser customUser = new CustomUser();
        customUser.setName(user.getName());
        customUser.setEmail(user.getEmail());
        customUser.setId(user.getId());
        customUser.setPassword(user.getPassword());
        customUser.setEnabled(true);
        customUser.setMobile(user.getEmail());

        List<Role> roles = session.createQuery("from Role where role_email = '" + email + "'").list();
        customUser.setAuthorities(roles);
        transaction.commit();
        session.close();

        return customUser;
    }
}
