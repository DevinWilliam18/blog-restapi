package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, String>{

    @Query("Select u FROM User u WHERE u.username like :username")    
    List<User> findByUsernameContaining(@Param("username") String username);
    
    // User findUserByFollowers_to_user_id(String id);
}
