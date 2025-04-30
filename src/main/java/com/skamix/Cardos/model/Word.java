package com.skamix.Cardos.model;

import com.skamix.Cardos.entity.WordEntity;

public class Word {
    private Long id_word;
    private String phrase;
    private String translate;

    public static Word toModel(WordEntity entity){
        Word model = new Word();
        model.setId_word(entity.getId_word());
        model.setPhrase(entity.getPhrase());
        model.setTranslate(entity.getTranslate());
        return model;
    }

    public Word() {
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public Long getId_word() {
        return id_word;
    }

    public void setId_word(Long id_word) {
        this.id_word = id_word;
    }
}
