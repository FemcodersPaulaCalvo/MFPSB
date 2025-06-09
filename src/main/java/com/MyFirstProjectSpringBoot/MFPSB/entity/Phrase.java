package com.MyFirstProjectSpringBoot.MFPSB.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Phrases")
public class Phrase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Phrase() {
    }

    public Phrase(String text, Author author, Category category) {
        this.text = text;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}