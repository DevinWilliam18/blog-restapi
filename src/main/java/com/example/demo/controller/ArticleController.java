package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Article;
import com.example.demo.model.State;
import com.example.demo.others.exception.ArticleNotFoundException;
import com.example.demo.service.ArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/v1")
public class ArticleController {
    
    private final  ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }


    @PostMapping("/articles")    
    public ResponseEntity<?> save (@RequestBody Article article){
        Article storedArticle = articleService.save(article);

        return new ResponseEntity<>(storedArticle, HttpStatus.OK);

    }

    @GetMapping("/articles/users/{id}")
    public ResponseEntity<?> getArticlesByUserId(@PathVariable String id)    {
        
        try {
            List<Article> articles = articleService.getArticlesByUserId(id);

            return new ResponseEntity<>(articles, HttpStatus.OK);

        } catch (ArticleNotFoundException a) {
            return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/articles")
    public ResponseEntity<?> getArticlesByTitleContainingAndState(@RequestParam String title, @RequestParam String state){
        try {
            List<Article> articles = articleService.getArticleByTitleContainingAndState(title, State.valueOf(state));

            return new ResponseEntity<>(articles, HttpStatus.OK);

        } catch (ArticleNotFoundException a) {
            return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        try {
            articleService.deleteById(id);;
            
            return new ResponseEntity<>("The article is successfully deleted", HttpStatus.OK);
            
        } catch (ArticleNotFoundException a) {
            return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/articles/users/{id}")
    public ResponseEntity<?> deleteByUserId(@PathVariable String id){
        try {
            articleService.deleteByUserId(id);
            
            return new ResponseEntity<>("All the articles are successfully deleted", HttpStatus.OK);
                    
        } catch (ArticleNotFoundException a) {
            return new ResponseEntity<>(a.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
