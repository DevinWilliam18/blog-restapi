package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ArticleDto;
import com.example.demo.dto.ArticleRegisterDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.model.State;
import com.example.demo.model.User;
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

    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    public ArticleController(ArticleService articleService, ModelMapper modelMapper){
        this.articleService = articleService;
        this.modelMapper = modelMapper;
    }


    @PostMapping("/articles")    
    public ResponseEntity<?> save (@RequestBody ArticleRegisterDto article){

        Article convertedArticle = modelMapper.map(article, Article.class);

        ArticleDto articleDto = modelMapper.map(articleService.save(convertedArticle, article.getUserId()), ArticleDto.class)
;
        return new ResponseEntity<>(articleDto, HttpStatus.OK);            
  
    }

    @GetMapping("/articles/users/{id}")
    public ResponseEntity<?> getArticlesByUserId(@PathVariable String id)    {
        
        try {
            List<Article> articles = articleService.getArticlesByUserId(id);

            List<ArticleDto> articlesDto = articles
                                                    .stream()
                                                    .map(article -> modelMapper.map(article, ArticleDto.class))
                                                    .collect(Collectors.toList());
            

            return new ResponseEntity<>(articlesDto, HttpStatus.OK);

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
