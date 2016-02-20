package com.DAOImpl;

import com.Model.CustomUser;
import com.Model.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dexter on 2/19/16.
 */
@Repository
public class CustomUserDetailsDAO {
    public CustomUser loadUserByUsername(final String name) {
        Configuration configuration = new AnnotationConfiguration();
        Session session = configuration.configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CustomUser user = new CustomUser();
        user.setFirstName("kb");
        user.setLastName("gc");
        user.setUsername("user1");
        user.setPassword("10");
        Role r = new Role();
        r.setName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        roles.add(r);

        user.setAuthorities(roles);
        return user;
    }
}
