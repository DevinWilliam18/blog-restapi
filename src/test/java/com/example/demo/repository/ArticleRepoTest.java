package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import java.util.Arrays;
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


    private Article article, article2, article3;

    private User user, user_2;

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

        userRepository.save(user);

        //save another user
        userRepository.save(user_2);


        friendship = Friendship.builder()
                                .from(user)
                                .to(user_2)
                                .createdAt(new Timestamp(System.currentTimeMillis()))
                                .updatedAt(new Timestamp(System.currentTimeMillis()))
                                .build();
                                
        friendshipRepo.save(friendship);
        
        article = Article
                        .builder()
                        .title("Java Framework")
                        .description("adasdadadjakdjajd")
                        .state(State.PUBLISHED)
                        .user(user)
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .updated_at(new Timestamp(System.currentTimeMillis()))
                        .build();

        article2 = Article
                        .builder()
                        .title("Javascript Framework")
                        .description("asdasd")
                        .state(State.PUBLISHED)
                        .user(user)
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .updated_at(new Timestamp(System.currentTimeMillis()))
                        .build();

        article3 = Article
                        .builder()
                        .title("Golang ORM")
                        .description("sadfsfafasdasdasdasskfdjui98kyd-a]=]kxau")
                        .state(State.PUBLISHED)
                        .user(user_2)
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .updated_at(new Timestamp(System.currentTimeMillis()))
                        .build();



        
        articleRepo.saveAll(Arrays.asList(article, article2, article3));

    }

    @Test
    void testFindByUser() {

	    List<Article> result = articleRepo.findByUserId(user_2.getId());
	    
	    assertEquals(1, result.size());
			
    }

    @Test
    void testFindByTitleLikeAndState(){

        try {

            List<Article> articles = articleRepo.findByTitleContainingAndState("%Java%", State.PUBLISHED);
            for (Article articleTest : articles) {
                logger.info("masuk: {}. id: {}", articleTest.getTitle(), articleTest.getId());   
            }
            assertEquals(2, articles.size());
            
        } catch (Exception e) {
            logger.error("Error - {}", e.getMessage());
        }

    }    

}
