package com.skamix.Cardos.repository;

import com.skamix.Cardos.entity.WordEntity;
import org.springframework.data.repository.CrudRepository;

public interface WordRepo extends CrudRepository<WordEntity, Long> {

}
