package com.skamix.Cardos.service;

import com.skamix.Cardos.entity.UserEntity;
import com.skamix.Cardos.entity.WordEntity;
import com.skamix.Cardos.exceptoption.UserNotFoundException;
import com.skamix.Cardos.exceptoption.WordNotFoundException;
import com.skamix.Cardos.model.Word;
import com.skamix.Cardos.repository.UserRepo;
import com.skamix.Cardos.repository.WordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {
    @Autowired
    private WordRepo wordRepo;

    @Autowired
    private UserRepo userRepo;

    public Word createWord(WordEntity word, Long userId) throws UserNotFoundException{
        UserEntity user = userRepo.findById(userId).get();
        if(user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        word.setUser(user);
        return Word.toModel(wordRepo.save(word));
    }

    public Word updateWord(WordEntity neword, Long id) throws WordNotFoundException{
        WordEntity word = wordRepo.findById(id).get();
        if(word == null){
            throw new WordNotFoundException("Фраза не найдена");
        }
        word.setPhrase(neword.getPhrase());
        word.setTranslate(neword.getTranslate());
        return Word.toModel(wordRepo.save(word));
    }

    public Long delete(Long id){
        wordRepo.deleteById(id);
        return id;
    }

}
