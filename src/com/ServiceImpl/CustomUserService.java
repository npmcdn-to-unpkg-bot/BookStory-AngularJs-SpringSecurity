package com.ServiceImpl;

import com.DAOImpl.CustomUserDetailsDAO;
import com.Model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by dexter on 2/19/16.
 */
@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private CustomUserDetailsDAO detailsDAO;

    @Override
    public CustomUser loadUserByUsername(String name) throws UsernameNotFoundException {
        return detailsDAO.loadUserByUsername(name);
    }
}
