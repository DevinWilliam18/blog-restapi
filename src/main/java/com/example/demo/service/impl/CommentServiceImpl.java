package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Comment;
import com.example.demo.repo.CommentRepo;
import com.example.demo.service.CommentService;

public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepo commentRepo;

    private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Override
    public Comment save(Comment comment) {
        
        Optional<Comment> storedComment = commentRepo.findById(comment.getId());

        if (storedComment.isPresent()) {
            throw new 
        }
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Comment> getCommentsByUserId(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommentsByUserId'");
    }

    @Override
    public List<Comment> getCommentsByArticleId(String articleId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCommentsByArticleId'");
    }
    
}
