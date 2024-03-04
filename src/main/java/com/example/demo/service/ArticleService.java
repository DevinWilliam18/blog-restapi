package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Article;
import com.example.demo.model.State;
import com.example.demo.model.User;

public interface ArticleService {

    Article save(Article article);

    List<Article> getArticlesByUserId(String userId);

    List<Article> getArticleByTitleContainingAndState(String title, State state);

    void deleteAll();

    void deleteByUserId(String userId);

    void deleteById(String id);

}
