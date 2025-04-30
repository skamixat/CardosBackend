package com.skamix.Cardos.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class WordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_word;
    private String phrase;
    private String translate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public WordEntity() {
    }

    public Long getId_word() {
        return id_word;
    }

    public void setId_word(Long id_word) {
        this.id_word = id_word;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
