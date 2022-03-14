package com.codeup.kidsrewardscapstone.repositories;

import com.codeup.kidsrewardscapstone.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);


}