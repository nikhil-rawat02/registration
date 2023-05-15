package com.Login.register.form.Service;

import com.Login.register.form.Entity.User;
import com.Login.register.form.Exceptions.PasswordNotFoundException;
import com.Login.register.form.Exceptions.UserNotFoundException;
import com.Login.register.form.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

    @Autowired
    Repository repository;
    @Override
    public boolean checkLogin(String userEmail, String password) throws Exception {
        User user;
        try{
            user = repository.findByEmail(userEmail) ;
        }catch (Exception e){
            throw new Exception("Database Error");
        }
        if(user == null){
            throw new UserNotFoundException("User Not found!");
        }
        else if(user.getPassword().equals(password)){
            return true;
        }else {
            throw new PasswordNotFoundException ("password does not match");
        }
    }

    @Override
    public boolean registerUser(String userName, String userEmail, String userPassword) throws Exception {
        User newUser = new User();
        try{
            newUser.setUserName(userName);
            newUser.setEmailId(userEmail);
            newUser.setPassword(userPassword);
            repository.save(newUser);
            return true;
        }catch (Exception e) {
            throw new Exception("Error");
        }
    }
}
