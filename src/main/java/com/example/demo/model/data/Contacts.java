package com.example.demo.model.data;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    int id;

    @Column(nullable = false, unique = true)
    String email;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contacts() {}

    public Contacts(int id, String email) {
        this.email = email;
        this.id = id;
    }
}
