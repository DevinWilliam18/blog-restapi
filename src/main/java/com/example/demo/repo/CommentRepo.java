package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, String>{
    
}
