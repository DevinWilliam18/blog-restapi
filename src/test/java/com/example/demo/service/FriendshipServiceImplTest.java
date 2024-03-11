package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.Friendship;
import com.example.demo.model.User;
import com.example.demo.repo.FriendshipRepo;
import com.example.demo.service.impl.FriendshipServiceImpl;



@ExtendWith(MockitoExtension.class)
public class FriendshipServiceImplTest {

    @Mock
    private FriendshipRepo friendshipRepo;

    @InjectMocks
    private FriendshipServiceImpl friendshipServiceImpl;

    private Friendship friendship, friendship2;

    private User user, user2, user3;

    @BeforeEach
    private void setupInitData(){
    
        user = User.builder()
                    .id("id--VIns")
                    .fullname("VIns")
                    .email("devin@gmail.com")
                    .password("xx090")
                    .username("vindes_99")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();
        
        user2 = User.builder()
                    .id("")
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

        friendship = Friendship
                                .builder()
                                .from(user)
                                .to(user2)
                                .createdAt(new Timestamp(System.currentTimeMillis()))
                                .updatedAt(new Timestamp(System.currentTimeMillis()))
                                .build();

        friendship2 = Friendship
                                .builder()
                                .from(user)
                                .to(user3)
                                .createdAt(new Timestamp(System.currentTimeMillis()))
                                .updatedAt(new Timestamp(System.currentTimeMillis()))
                                .build();                            

    }

    @Test
    void testDeleteFriendshipByFromIdAndToId() {
        doNothing().when(friendshipRepo).deleteByFrom_IdAndTo_Id(user.getId(), user2.getId());

        friendshipServiceImpl.deleteFriendshipByFromIdAndToId(user.getId(), user2.getId());

        verify(friendshipRepo, times(1)).deleteByFrom_IdAndTo_Id(user.getId(), user2.getId());

    }

    @Test
    void testGetByFrom_Id() {
    
        when(friendshipRepo.findByFrom_Id(user.getId())).thenReturn(Arrays.asList(friendship, friendship2));

        List<Friendship> friendships = friendshipServiceImpl.getByFrom_Id(user.getId());

        verify(friendshipRepo, times(1)).findByFrom_Id(user.getId());

        assertEquals(friendships.size(), 2);

    }
}
