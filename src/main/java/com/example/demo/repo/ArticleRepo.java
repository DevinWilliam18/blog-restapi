package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Article;


@Repository
public interface ArticleRepo extends JpaRepository<Article, String>{
    
}
