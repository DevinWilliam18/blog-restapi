package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
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

    private User user, user2, user3;

    private Friendship friendship, friendship2;

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
    

        user3 = User.builder()
                    .fullname("Dodo Al Hilal")
                    .email("dodo@gmail.com")
                    .password("drf243")
                    .username("dodo_07")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();

        userRepository.saveAll(Arrays.asList(user,user2,user3));

        friendship = Friendship.builder()
                                .from(user)
                                .to(user2)
                                .createdAt(new Timestamp(System.currentTimeMillis()))
                                .updatedAt(new Timestamp(System.currentTimeMillis()))
                                .build();
        
        friendship2 = Friendship.builder()
                                .from(user)
                                .to(user3)
                                .createdAt(new Timestamp(System.currentTimeMillis()))
                                .updatedAt(new Timestamp(System.currentTimeMillis()))
                                .build();
                                                                
        friendshipRepo.saveAll(Arrays.asList(friendship, friendship2));
    }
    
    @Test
    void testFindByTo_Id() {
        List<Friendship> friendships = friendshipRepo.findByFrom_Id(user.getId());

        assertEquals(friendships.size(), 2);

    }
}
