package com.example.demo.model.data;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    int id;

    @Column(unique = true, nullable = false)
    String name;

    @ManyToMany(mappedBy = "genres")
    private List<Author> authors;
}
