package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Article;
import com.example.demo.model.State;
import com.example.demo.model.User;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, String>{
    List<Article> findByUserId(String userId);

    List<Article> findByTitleContainingAndState(String title, State state);
}
