package com.Model;

import javax.persistence.*;

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
    @Column(name = "name")
    private String name;
    @Column(name = "genre_id")
    private Long genre_id;
    @Column(name = "author_id")
    private Long author_id;
    @Column(name = "language")
    private String language;
    @Column(name = "created_date")
    private String created_date;

    public Book() {
    }

    public Book(String name, Long genre_id, Long author_id, String language, String created_date) {
        this.name = name;
        this.genre_id = genre_id;
        this.author_id = author_id;
        this.language = language;
        this.created_date = created_date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
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

    public Long getGenre_id() {
        return genre_id;
    }

    public Long getAuthor_id() {
        return author_id;
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
                ", genre_id='" + genre_id + '\'' +
                ", author_id='" + author_id + '\'' +
                ", language='" + language + '\'' +
                ", created_date='" + created_date + '\'' +
                '}';
    }
}
