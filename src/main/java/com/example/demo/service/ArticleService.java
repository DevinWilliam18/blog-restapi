package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Article;
import com.example.demo.model.State;

public interface ArticleService {

    Article save(Article article, String userId);

    List<Article> getArticlesByUserId(String userId);

    List<Article> getArticleByTitleContainingAndState(String title, State state);

    void deleteByUserId(String userId);

    void deleteById(String id);

}
