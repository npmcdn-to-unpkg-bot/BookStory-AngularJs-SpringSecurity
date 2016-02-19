//package com.SpringSecurity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//import javax.sql.DataSource;
//
///**
// * Created by dexter on 2/18/16.
// */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class test extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder au) throws Exception {
//        au.jdbcAuthentication().dataSource(dataSource).
//                usersByUsernameQuery("select name, password, enabled from users where name=?")
//                .authoritiesByUsernameQuery("select name, role from role_users where name=?");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/user**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')").and().formLogin();
//    }


//    @Autowired
//    @Qualifier("userDetailsService")
//    UserDetailsService userDetailsService;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
//        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/admin**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/user**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')").and().formLogin();
//    }
//}