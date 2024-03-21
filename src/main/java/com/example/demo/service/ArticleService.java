package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Article;
import com.example.demo.model.State;

public interface ArticleService {

    Article save(Article article);

    List<Article> getArticlesByUserId(String userId);

    List<Article> getArticleByTitleContainingAndState(String title, State state);

    void deleteByUserId(String userId);

    void deleteById(String id);

}
