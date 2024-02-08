package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Friendship;

@Repository
public interface FriendshipRepo extends JpaRepository<Friendship, String>{
    
}
