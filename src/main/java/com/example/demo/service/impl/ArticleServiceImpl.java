package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Article;
import com.example.demo.model.State;
import com.example.demo.others.exception.ArticleNotFoundException;
import com.example.demo.repo.ArticleRepo;
import com.example.demo.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepo articleRepo;

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Override
    public Article save(Article article) {
        return articleRepo.saveAndFlush(article);
    }

    @Override
    public List<Article> getArticlesByUserId(String userId){
        List<Article> articles = articleRepo.findByUserId(userId);

        if (articles == null) {
            throw new ArticleNotFoundException(String.format("userId %s", userId));
        }

        return articles;
    }

    @Override
    public List<Article> getArticleByTitleContainingAndState(String title, State state) {


        List<Article> articles = articleRepo.findByTitleContainingAndState(title, state);

        if (articles == null) {
            throw new ArticleNotFoundException(String.format("title '%s' and state '%s'", title, state));
        }

        return articles;
    }

    @Override
    public void deleteByUserId(String userId) throws ArticleNotFoundException{
        //check whether article exists or not 
        getArticlesByUserId(userId);
        
        articleRepo.deleteByUserId(userId);
        
    }

    @Override
    public void deleteById(String id){
        
        Optional<Article> article = getArticleById(id); 

        if (article.isPresent()) {
            
            articleRepo.deleteById(id);

        }else{

            throw new ArticleNotFoundException(String.format("id %s", id));
        
        }


    }

    public Optional<Article> getArticleById(String id) throws ArticleNotFoundException{
        Optional<Article> article = articleRepo.findById(id);

        return article;

    }
   
}