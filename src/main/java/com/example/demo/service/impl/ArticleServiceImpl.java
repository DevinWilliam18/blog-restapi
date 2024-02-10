package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Article;
import com.example.demo.model.User;
import com.example.demo.repo.ArticleRepo;
import com.example.demo.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepo articleRepo;

    @Override
    public Article save(Article article) {
        return articleRepo.saveAndFlush(article);
    }

    @Override
    public List<Article> getArticlesByUserId(String userId) {
        
        return articleRepo.findByUserId(userId);
        
    }
    
}
