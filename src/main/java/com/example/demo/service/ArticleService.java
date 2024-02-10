package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Article;
import com.example.demo.model.User;

public interface ArticleService {

    Article save(Article article);

    List<Article> getArticlesByUserId(String userId);

}
