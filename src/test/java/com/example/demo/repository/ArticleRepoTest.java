package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Article;
import com.example.demo.model.State;
import com.example.demo.repo.ArticleRepo;

public class ArticleRepoTest {

    @Autowired
    private ArticleRepo articleRepo;


    private Article article;

    @BeforeEach
    private void initData(){

        article = Article
                        .builder()
                        .title("Java Framework")
                        .description("adasdadadjakdjajd")
                        .state(State.PUBLISHED)
                        // .user(user)
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .updated_at(new Timestamp(System.currentTimeMillis()))
                        .build();
    }

    @Test
    void testFindByUser() {
        articleRepo.save(article);

        Article result = articleRepo.findByUserId("y");

        assertEquals(articleRepo.findBY, article);

    }
}
