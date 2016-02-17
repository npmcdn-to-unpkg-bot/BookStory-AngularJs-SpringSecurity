package com;

import org.apache.taglibs.standard.tag.common.sql.DataSourceWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by dexter on 2/17/16.
 */
@Configuration
public class configuration {
    @Bean
    public DataSource securityDataSource() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        DataSourceWrapper dataSourceWrapper = new DataSourceWrapper();
        dataSourceWrapper.setDriverClassName("org.postgresql.Driver");
        dataSourceWrapper.setJdbcURL("jdbc:postgresql://127.0.0.1:5432/bookstory");
        dataSourceWrapper.setPassword("1001");
        dataSourceWrapper.setUserName("postgres");
        return dataSourceWrapper;
    }
}