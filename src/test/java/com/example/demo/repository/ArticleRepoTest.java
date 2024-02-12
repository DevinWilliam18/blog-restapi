package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Article;
import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.repo.ArticleRepo;
import com.example.demo.repo.UserRepository;

@DataJpaTest
public class ArticleRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepo articleRepo;


    private Article article;

    private User user;

    private static final Logger logger = LoggerFactory.getLogger(ArticleRepoTest.class);

    @BeforeEach
    private void initData(){

        user = User.builder()
                    .fullname("VIns")
                    .email("devin@gmail.com")
                    .password("xx090")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();

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
        userRepository.save(user);

        articleRepo.save(article);
        
        List<Article> result = articleRepo.findByUserId(user.getId());

        logger.info("User ID: {}", user.getId());
        
        assertEquals(1, result.size());

    }
}
