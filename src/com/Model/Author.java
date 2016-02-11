package com.Model;

import javax.persistence.*;

/**
 * Created by dexter on 2/12/16.
 */
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String  lastName;
    @Column(name = "email")
    private String email;
}
