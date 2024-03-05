package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

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
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user, userStored;


    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);    

    @BeforeEach
    private void setUpInit(){

        user = User.builder()
                    .fullname("VIns")
                    .email("devin@gmail.com")
                    .password("xx090")
                    .username("vindes_99")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();

        userRepository.save(user);

    }

    @Test
    void testFindByUsername() {
        userStored = userRepository.findByUsername("vindes_99");

        assertEquals("vindes_99", userStored.getUsername());
    }

}