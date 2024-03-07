package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    private Article article;

    private User user;

    @BeforeEach
    private void initData(){

        // user = User
        //         .builder()
        //         .fullname("VIns")
        //         .email("devin@gmail.com")
        //         .password("xx090")
        //         .username("vindes_99")
        //         .createdAt(new Timestamp(System.currentTimeMillis()))
        //         .updatedAt(new Timestamp(System.currentTimeMillis()))
        //         .build();
        
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
    void testDeleteById() {
        doThrow(ArticleNotFoundException.class).doNothing().when(articleRepo).deleteById(article.getId());
        
        when(articleRepo.findById(article.getId())).thenReturn(Optional.of(article));


        articleServiceImpl.deleteById(article.getId());

        verify(articleRepo, times(1)).deleteById(article.getId());
    }

    @Test
    void testDeleteByUserId() {

    }

    @Test
    void testGetArticleById() {
        when(articleRepo.findById(article.getId())).thenReturn(Optional.of(article));

        assertEquals(article.getTitle(), articleServiceImpl.getArticleById(article.getId()).get().getTitle());
    }

    @Test
    void testGetArticleByTitleContainingAndState() {

    }

    @Test
    void testGetArticlesByUserId() {

    }

    @Test
    void testSave() {

    }
}
