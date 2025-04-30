package com.skamix.Cardos.model;

import com.skamix.Cardos.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id_user;
    private String login;
    private List<Word> words;

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId_user(entity.getId_user());
        model.setLogin(entity.getLogin());
        model.setWords(entity.getWords().stream().map(Word::toModel).collect(Collectors.toList()));
        return model;
    }

    public User() {
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
