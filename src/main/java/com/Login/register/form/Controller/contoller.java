package com.Login.register.form.Controller;

import com.Login.register.form.Entity.User;
import com.Login.register.form.Exceptions.PasswordNotFoundException;
import com.Login.register.form.Exceptions.UserNotFoundException;
import com.Login.register.form.Service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("welcome")
public class contoller {

    @Autowired ServiceImpl service;

    @GetMapping("/login")
        public ResponseEntity checkLogin (@RequestParam String userEmail, @RequestParam String password){
        boolean isAllowed;
        try{
            isAllowed =service.checkLogin(userEmail,password);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>("User not found Check your email or signIn!", HttpStatus.NOT_FOUND);
        }catch ( PasswordNotFoundException e){
             return new ResponseEntity<>("Invalid Password!", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Server Error from database!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(isAllowed, HttpStatus.FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestParam String userName, @RequestParam String userEmail, @RequestParam String userPassword){
        boolean isRegistered;
        try{
            isRegistered = service.registerUser(userName, userEmail, userPassword);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Some problem occurred in server try again", HttpStatusCode.valueOf(404));
        }
        return new ResponseEntity<>(isRegistered,HttpStatus.CREATED);

    }
}