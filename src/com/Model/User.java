package com.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dexter on 2/12/16.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "password")
    private String password;
    @Column(name = "role_id", insertable = false, updatable = false)
    Long role_id;
//    @Column(name = "enabled")
//    private boolean enabled;
//    private Set<Role> roles = new HashSet<>(0);
//
//    public Long getRole_id() {
//        return role_id;
//    }
//
//    public void setRole_id(Long role_id) {
//        this.role_id = role_id;
//    }

    public User(String name, String email, String mobile, String password) {
        this.email = email;
        this.name = name;
        this.mobile = mobile;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setname(String name) {
        this.name = name;
    }


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getname() {
        return name;
    }


    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    public Set<Role> getRoles() {
//        return roles;
//    }

//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }

//    public Boolean getEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(Boolean enabled) {
//        this.enabled = enabled;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role_id='" + role_id + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
