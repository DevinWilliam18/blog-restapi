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
import com.example.demo.model.Friendship;
import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.repo.ArticleRepo;
import com.example.demo.repo.FriendshipRepo;
import com.example.demo.repo.UserRepository;

@DataJpaTest
public class ArticleRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private FriendshipRepo friendshipRepo;


    private Article article;

    private User user, user_2;

    private User userStored, userStored_2;

    private Friendship friendship;


    private static final Logger logger = LoggerFactory.getLogger(ArticleRepoTest.class);

    @BeforeEach
    private void initData(){

        user = User.builder()
                    .fullname("VIns")
                    .email("devin@gmail.com")
                    .password("xx090")
                    .username("vindes_99")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();
        
        user_2 = User.builder()
                    .fullname("Edokis Desak")
                    .email("edo9011@gmail.com")
                    .password("xxc90i17")
                    .username("edoks_24")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();

        userStored =  userRepository.save(user);

        //save another user
        userStored_2 = userRepository.save(user_2);


        friendship = Friendship.builder()
                                .from(userStored)
                                .to(userStored_2)
                                .createdAt(new Timestamp(System.currentTimeMillis()))
                                .updatedAt(new Timestamp(System.currentTimeMillis()))
                                .build();
                                
        friendshipRepo.save(friendship);
        
        article = Article
                        .builder()
                        .title("Java Framework")
                        .description("adasdadadjakdjajd")
                        .state(State.PUBLISHED)
                        .user(userStored)
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .updated_at(new Timestamp(System.currentTimeMillis()))
                        .build();

    }

    @Test
    void testFindByUser() {

        //store the article
        articleRepo.save(article);
        
        List<Article> result = articleRepo.findByUserId(userStored.getId());
        
        logger.info("User ID: {}", user.getId());
        logger.info("UserStored ID: {}", userStored.getId());
        logger.info("List (User): {}", result);

        assertEquals(1, result.size());

    }
}
