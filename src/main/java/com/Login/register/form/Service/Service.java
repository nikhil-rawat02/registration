package com.Login.register.form.Service;

import com.Login.register.form.Entity.User;
import com.Login.register.form.Exceptions.PasswordNotFoundException;
import com.Login.register.form.Exceptions.UserNotFoundException;


public interface Service {
    boolean checkLogin(String userName, String password) throws Exception;

    boolean registerUser(String userName, String userEmail, String userPassword) throws Exception;
}
