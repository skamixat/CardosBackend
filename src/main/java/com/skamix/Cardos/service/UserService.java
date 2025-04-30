package com.skamix.Cardos.service;

import com.skamix.Cardos.entity.UserEntity;
import com.skamix.Cardos.exceptoption.UserAlreadyExistException;
import com.skamix.Cardos.exceptoption.UserNotFoundException;
import com.skamix.Cardos.model.User;
import com.skamix.Cardos.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByLogin(user.getLogin()) != null){
            throw new UserAlreadyExistException("Пользоваетль с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id_user) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id_user).get();
        if(user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
