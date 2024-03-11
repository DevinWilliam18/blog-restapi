package com.example.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Friendship;
import com.example.demo.repo.FriendshipRepo;
import com.example.demo.service.FriendshipService;

@Service
public class FriendshipServiceImpl implements FriendshipService{

    @Autowired
    private FriendshipRepo friendshipRepo;

    private static final Logger logger = LoggerFactory.getLogger(FriendshipServiceImpl.class);

    @Override
    public List<Friendship> getByFrom_Id(String fromId) {
        List<Friendship> storedFriendship = friendshipRepo.findByFrom_Id(fromId);
        return storedFriendship;
    }

    @Override
    public void deleteFriendshipByFromIdAndToId(String fromId, String toId) {
        friendshipRepo.deleteByFrom_IdAndTo_Id(fromId, toId);
    }

    @Override
    public Friendship save(Friendship friendship) {
        return friendshipRepo.saveAndFlush(friendship);
    }

}