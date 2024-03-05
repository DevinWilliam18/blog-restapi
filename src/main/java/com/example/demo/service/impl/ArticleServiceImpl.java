package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Article;
import com.example.demo.model.State;
import com.example.demo.repo.ArticleRepo;
import com.example.demo.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepo articleRepo;

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Override
    public Article save(Article article) {
        return articleRepo.saveAndFlush(article);
    }

    @Override
    public List<Article> getArticlesByUserId(String userId) {
        
        return articleRepo.findByUserId(userId);
        
    }

    @Override
    public List<Article> getArticleByTitleContainingAndState(String title, State state) {
        List<Article> articles = articleRepo.findByTitleContainingAndState(title, state);

        return articles;
    }

    @Override
    public void deleteByUserId(String userId) {
        List<Article> articles = getArticlesByUserId(userId);
        if (articles != null) {
            articleRepo.deleteByUserId(userId);
        }
    }

    @Override
    public void deleteById(String id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    public Article getArticleById(String id){
        Optional<Article> article = articleRepo.findById(id);
        article.isPresent()

    }
    
}
