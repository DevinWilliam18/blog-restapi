package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Article;
import com.example.demo.model.State;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepo extends JpaRepository<Article, String>{
    List<Article> findByUserId(String userId);

    @Query("Select a FROM Article a WHERE a.title like :title AND a.state = :#{#state}")
    List<Article> findByTitleContainingAndState(@Param("title") String title, @Param("state") State state);

    
    void deleteByUserId(String userId);

    // add exist method

}
