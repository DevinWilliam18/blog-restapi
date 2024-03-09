package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Comment;
import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepo extends JpaRepository<Comment, String>{
    
    Optional<Comment> findById(String id);
    List<Comment> findByUserId(String userId);
    List<Comment> findByArticleId(String articleId);
    
}
