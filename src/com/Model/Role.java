package com.Model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by dexter on 2/17/16.
 */
@Entity
@Table(name = "role_users")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "role", nullable = false)
    private String role;
    @Column(name = "role_email")
    private String role_email;

    public String getName() {
        return role_email;
    }

    public void setName(String name) {
        this.role_email = name;
    }


    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }
}