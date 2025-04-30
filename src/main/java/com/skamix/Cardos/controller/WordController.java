package com.skamix.Cardos.controller;

import com.skamix.Cardos.entity.WordEntity;
import com.skamix.Cardos.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/words")
public class WordController {
    @Autowired
    private WordService wordService;

    @PostMapping
    public ResponseEntity createWord(@RequestBody WordEntity word,
                                    @RequestParam Long userId){
        try {
            return ResponseEntity.ok(wordService.createWord(word, userId));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity updateWord(@RequestBody WordEntity word,
                                     @RequestParam Long id){
        try {
            return ResponseEntity.ok(wordService.updateWord(word, id));
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity delete(@PathVariable Long id){
        try {
            return ResponseEntity.ok(wordService.delete(id));
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Произошла ошиба");
        }
    }


}
