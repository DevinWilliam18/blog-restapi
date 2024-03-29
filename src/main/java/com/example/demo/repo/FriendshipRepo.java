package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Friendship;
import com.example.demo.model.User;

import java.util.List;


@Repository
public interface FriendshipRepo extends JpaRepository<Friendship, String>{

    List<Friendship> findByFrom_Id(String fromId);

    void deleteByFrom_IdAndTo_Id(String fromId, String toId);

}
