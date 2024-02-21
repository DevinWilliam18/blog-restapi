package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Friendship;
import com.example.demo.model.User;
import com.example.demo.repo.FriendshipRepo;
import com.example.demo.repo.UserRepository;

@DataJpaTest
public class FriendshipRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendshipRepo friendshipRepo;

    private User user, user_2;

    private Friendship friendship;
    
    
    private static final Logger logger = LoggerFactory.getLogger(FriendshipRepoTest.class);    

    @BeforeEach
    private void setUpInit(){
					user = User.builder()
									.fullname("Devin William")
									.email("vins@gmail.com")
									.password("1234")
									.username("devin9023@gmail.com")
									.createdAt(new Timestamp(System.currentTimeMillis()))
									.updatedAt(new Timestamp(System.currentTimeMillis()))
									.build();

					user_2 = User.builder()
									.fullname("Emre Khan")
									.email("khan@gmail.com")
									.password("khan_1234")
									.username("emre24@gmail.com")
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
    }

    @Test
    void testFindByTo() {
        logger.info("save: {} ", friendshipRepo.save(friendship));

        logger.info("test--");

        List<Friendship> testGetAll = friendshipRepo.findAll();
        logger.info("size: {}", testGetAll.size());
        for (Friendship friendship : testGetAll) {
            logger.info("GetAll: {}", friendship);
        }

        List<Friendship> friendshipList = friendshipRepo.findByTo(user_2);

        assertEquals(1, friendshipList.size());

    }
}
