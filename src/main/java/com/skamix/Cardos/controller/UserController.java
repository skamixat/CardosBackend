package com.skamix.Cardos.controller;

import com.skamix.Cardos.entity.UserEntity;
import com.skamix.Cardos.exceptoption.UserAlreadyExistException;
import com.skamix.Cardos.exceptoption.UserNotFoundException;
import com.skamix.Cardos.model.AuthRequest;
import com.skamix.Cardos.model.AuthResponse;
import com.skamix.Cardos.repository.UserRepo;
import com.skamix.Cardos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            //userService.registration(user);
            return ResponseEntity.ok(userService.registration(user));
        }catch (UserAlreadyExistException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Произошла ошиба");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.delete(id));
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Произошла ошиба");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request){
        Long error = 404L;
        try {
            AuthResponse response = userService.login(request);
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(401).body(new AuthResponse(error, false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthResponse(error, false, "Ошибка входа"));
        }
    }


}
