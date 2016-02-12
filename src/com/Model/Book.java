package com.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dexter on 2/6/16.
 */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "language", nullable = false)
    private String language;
    @Column(name = "created_date", nullable = false)
    private String created_date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    private Set<User> users = new HashSet<>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Book() {
    }

    public Book(String name, String language, String created_date) {
        this.name = name;
        this.language = language;
        this.created_date = created_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getCreated_date() {
        return created_date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", language='" + language + '\'' +
                ", created_date='" + created_date + '\'' +
                '}';
    }
}
