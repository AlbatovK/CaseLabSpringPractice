package com.example.demo.model.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    int id;

    @Column(nullable = false, length = 20)
    String name;

    @Lob
    @Column(nullable = true)
    String bio;

    @Column(name = "number_of_books", nullable = false)
    int numberOfBooks;

    public Author(int id, String name, String bio, int numberOfBooks) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.numberOfBooks = numberOfBooks;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public Author() {
    }

    @OneToMany
    @JoinColumn(name = "author_id")
    private List<Contacts> contacts;

    @ManyToMany
    private List<Genre> genres;
}
