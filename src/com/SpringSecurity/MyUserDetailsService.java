//package com.SpringSecurity;
//
//import com.DAO.UserDAO;
//import com.Model.Role;
//import com.Model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by dexter on 2/19/16.
// */
//@Repository("userDetailsService")
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserDAO userDAO;
//
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//        User user = userDAO.getElementName(name);
//        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
//        return buildUserForAuthentication(user, authorities);
//    }
//
//    @SuppressWarnings("unchecked")
//    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
//                user.getEnabled(), true, true, true, authorities);
//    }
//
//    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {
//
//        Set<GrantedAuthority> setAuths = new HashSet<>();
//
//        // Build user's authorities
//        for (Role userRole : userRoles) {
//            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//        }
//        return new ArrayList<>(setAuths);
//    }

//}