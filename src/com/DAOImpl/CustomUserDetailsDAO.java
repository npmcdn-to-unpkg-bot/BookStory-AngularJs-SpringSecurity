package com.DAOImpl;

import com.Model.CustomUser;
import com.Model.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dexter on 2/19/16.
 */
@Repository
public class CustomUserDetailsDAO {
    public CustomUser loadUserByUsername(final String name) {
        CustomUser user = new CustomUser();
        user.setFirstName("kb");
        user.setLastName("gc");
        user.setUsername("user1");
        user.setPassword("10");
        Role r = new Role();
        r.setName("ROLE_USER");

        CustomUser admin1 = new CustomUser();
        admin1.setFirstName("bahodir");
        admin1.setLastName("boydedayev");
        admin1.setUsername("admin1");
        admin1.setPassword("10");
        Role r1 = new Role();
        r1.setName("ROLE_ADMIN");

        CustomUser admin2 = new CustomUser();
        admin2.setFirstName("javohir");
        admin2.setLastName("boydedayev");
        admin2.setUsername("admin2");
        admin2.setPassword("10");
        Role r2 = new Role();
        r2.setName("ROLE_ADMIN");

        List<Role> roles = new ArrayList<>();
        roles.add(r);
        roles.add(r1);
        roles.add(r2);
        user.setAuthorities(roles);
        return user;
    }
}
