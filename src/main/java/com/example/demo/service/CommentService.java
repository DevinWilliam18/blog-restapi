package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Comment;

public interface CommentService {

    Comment save(Comment comment);

    List<Comment> getCommentsByUserId(String userId);

    List<Comment> getCommentsByArticleId(String articleId);

}
