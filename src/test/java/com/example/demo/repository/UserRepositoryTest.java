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

import com.example.demo.model.Friendship;
import com.example.demo.model.User;
import com.example.demo.repo.FriendshipRepo;
import com.example.demo.repo.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User user, user2, user3;


    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryTest.class);    

    @BeforeEach
    private void setUpInit(){

        user = User.builder()
                    .fullname("Vins")
                    .email("devin@gmail.com")
                    .password("xx090")
                    .username("vindes_99")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();

        user2 = User.builder()
                    .fullname("Vinson")
                    .email("vin@gmail.com")
                    .password("xxs090")
                    .username("desvindes_a99")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();                    

        user3 = User.builder()
                    .fullname("WIlson")
                    .email("vinss@gmail.com")
                    .password("xxs091090")
                    .username("dedong")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build(); 

        userRepository.saveAll(Arrays.asList(user, user2, user3));

    }

    @Test
    void testFindByUsername() {
        List<User> users = userRepository.findByUsernameContaining("%vin%");

        assertEquals(users.size(), 2);
    }

}
