package com.MyFirstProjectSpringBoot.MFPSB.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name="Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Phrase> phrases;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<Phrase> phrases) {
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
