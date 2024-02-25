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

    private User user, user2;

    private Friendship friendship;

    private static final Logger logger = LoggerFactory.getLogger(FriendshipRepoTest.class);

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
        
        user2 = User.builder()
                    .fullname("Edokis Desak")
                    .email("edo9011@gmail.com")
                    .password("xxc90i17")
                    .username("edoks_24")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();        
    
        userRepository.save(user);

        userRepository.save(user2);

        friendship = Friendship.builder()
                                .from(user)
                                .to(user2)
                                .createdAt(new Timestamp(System.currentTimeMillis()))
                                .updatedAt(new Timestamp(System.currentTimeMillis()))
                                .build();
        
        friendshipRepo.save(friendship);
    }
    
    @Test
    void testFindByTo_Id() {
        Friendship friendships = friendshipRepo.findByFrom_Id(user.getId());

        logger.info("test by id: {}", friendships);


        assertEquals("devin@gmail.com", user.getEmail());

    }
}
