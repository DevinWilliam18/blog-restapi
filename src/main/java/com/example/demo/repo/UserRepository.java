package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
    
    // User findUserByFollowers_to_user_id(String id);
}
