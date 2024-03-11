package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Friendship;

public interface FriendshipService {
    List<Friendship> getByFrom_Id(String fromId);

    void deleteFriendshipByFromIdAndToId(String fromId, String toId);
    
}
