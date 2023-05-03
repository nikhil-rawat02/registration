package com.Login.register.form.repository;

import com.Login.register.form.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where email_id=:userEmail",nativeQuery = true)
    User findByEmail(String userEmail);
}
