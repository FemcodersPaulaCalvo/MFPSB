package com.MyFirstProjectSpringBoot.MFPSB.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Phrase> phrases;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, List<Phrase> phrases) {
        this.name = name;
        this.phrases = phrases;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }
}
