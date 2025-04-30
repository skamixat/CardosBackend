package com.skamix.Cardos.repository;

import com.skamix.Cardos.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByLogin(String login);
}
