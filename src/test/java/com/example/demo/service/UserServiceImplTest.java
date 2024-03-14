package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.impl.UserServiceImpl;


@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

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
                    .id("id--Edokis Desak")
                    .fullname("Edokis Desak")
                    .email("edo9011@gmail.com")
                    .password("xxc90i17")
                    .username("edoks_24")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();        

        user3 = User.builder()
                    .id("id--Dodo Al Hilal")
                    .fullname("Dodo Al Hilal")
                    .email("dodo@gmail.com")
                    .password("drf243")
                    .username("dodo_07")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();
    }

    @Test
    void testFindByUsernameContaining() {
        when(userRepository.findByUsernameContaining("%do%")).thenReturn(Arrays.asList(user2, user3));

        List<User> users = userServiceImpl.findByUsernameContaining("%do%");

        assertEquals(users.size(), 2);

    }

    @Test
    void testSave() {
        when(userRepository.saveAndFlush(user3)).thenReturn(user3);

        User storedUser = userServiceImpl.save(user3);

        assertEquals(storedUser.getId(), user3.getId());
    }
}
