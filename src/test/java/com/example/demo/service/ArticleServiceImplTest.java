package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.Article;
import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.others.exception.ArticleNotFoundException;
import com.example.demo.repo.ArticleRepo;
import com.example.demo.service.impl.ArticleServiceImpl;


@ExtendWith(MockitoExtension.class)
public class ArticleServiceImplTest {

    @Mock
    private ArticleRepo articleRepo;

    @InjectMocks
    private ArticleServiceImpl articleServiceImpl;

    private Article article, article2;

    private User user;

    private static final Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @BeforeEach
    private void initData(){

        user = User
                .builder()
                .id("---TEST-USER---")
                .fullname("VIns")
                .email("devin@gmail.com")
                .password("xx090")
                .username("vindes_99")
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();
        
        article = Article
                        .builder()
                        .id("--TEST--")
                        .title("Java Framework")
                        .description("adasdadadjakdjajd")
                        .state(State.PUBLISHED)
                        .user(user)
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .updated_at(new Timestamp(System.currentTimeMillis()))
                        .build();

        article2 = Article
                        .builder()
                        .id("--TEST-2--")
                        .title("Javascript")
                        .description("adasdadadjakdjajd")
                        .state(State.PUBLISHED)
                        .user(user)
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .updated_at(new Timestamp(System.currentTimeMillis()))
                        .build();

    }


    @Test
    void testDeleteById() {

        when(articleRepo.findById(article.getId())).thenReturn(Optional.of(article));

        doNothing().when(articleRepo).deleteById(article.getId());
        
        articleServiceImpl.deleteById(article.getId());

        verify(articleRepo, times(1)).deleteById(article.getId());
    }

    @Test
    void testDeleteByUserId() {

        when(articleRepo.findByUserId(user.getId())).thenReturn(Arrays.asList(article, article2));

        doNothing().when(articleRepo).deleteByUserId(user.getId());

        articleServiceImpl.deleteByUserId(user.getId());

        verify(articleRepo, times(1)).deleteByUserId(user.getId());

    }

    @Test
    void testGetArticleById() {
        when(articleRepo.findById(article.getId())).thenReturn(Optional.of(article));

        assertEquals(articleServiceImpl.getArticleById(article.getId()).get().getTitle(), article.getTitle());
    }

    @Test
    void testGetArticleByTitleContainingAndState() {
        when(articleRepo.findByTitleContainingAndState("%Java%", State.PUBLISHED)).thenReturn(Arrays.asList(article, article2));

        List<Article> articles = articleServiceImpl.getArticleByTitleContainingAndState("%Java%", State.PUBLISHED);

        assertEquals(2, articles.size());

    }

    @Test
    void testGetArticlesByUserId() {
        when(articleRepo.findByUserId(user.getId())).thenReturn(Arrays.asList(article, article2));

        List<Article> articles = articleServiceImpl.getArticlesByUserId(user.getId());

        assertEquals(2, articles.size());
    }

    @Test
    void testSave() {

        when(articleRepo.saveAndFlush(article)).thenReturn(article);

        Article storedArticle = articleServiceImpl.save(article);

        verify(articleRepo, times(1)).saveAndFlush(article);

        assertEquals(storedArticle.getTitle(), article.getTitle());
    }
}
