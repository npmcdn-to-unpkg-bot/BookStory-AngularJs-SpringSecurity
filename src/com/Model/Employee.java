package com.Model;

import javax.persistence.*;

/**
 * Created by dexter on 2/6/16.
 */
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "state")
    private String state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String gender) {
        this.password = gender;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Employee(String firstName, String lastName, String mobile, String email, String password, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.state = state;
    }

    public Employee(Long id, String firstName, String lastName, String mobile, String email, String password, String state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.state = state;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "EmployeeController{" +
                "state='" + state + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }
}
