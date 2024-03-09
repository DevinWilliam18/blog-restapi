package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.repo.ArticleRepo;
import com.example.demo.repo.CommentRepo;
import com.example.demo.repo.UserRepository;

@DataJpaTest
public class CommentRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepo articleRepo;

    @Autowired
    private CommentRepo commentRepo;

    private User user;

    private Article article;

    private Comment comment;

    @BeforeEach
    private void initData(){

        user = User.builder()
                    .fullname("Vins")
                    .email("devin@gmail.com")
                    .password("xx090")
                    .username("vindes_99")
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .updatedAt(new Timestamp(System.currentTimeMillis()))
                    .build();

        userRepository.save(user);

        article = Article
                        .builder()
                        .title("Java Framework")
                        .description("adasdadadjakdjajd")
                        .state(State.PUBLISHED)
                        .user(user)
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .updated_at(new Timestamp(System.currentTimeMillis()))
                        .build();            
                        
        articleRepo.save(article);
        
        comment = Comment
                        .builder()
                        .commentBody("bad topics")
                        .article(article)
                        .user(user)
                        .created_at(new Timestamp(System.currentTimeMillis()))
                        .updated_at(new Timestamp(System.currentTimeMillis()))
                        .build();
        
        commentRepo.save(comment);

    }

    @Test
    void testFindByArticleId() {
        List<Comment> comments = commentRepo.findByArticleId(article.getId());

        assertEquals(comments.size(), 1);
    }

    @Test
    void testFindById() {
        Optional<Comment> storedComment  = commentRepo.findById(comment.getId());

        assertEquals(storedComment.get().getId(), comment.getId());
    }

    @Test
    void testFindByUserId() {
        List<Comment> comments = commentRepo.findByUserId(comment.getUser().getId());

        assertEquals(comments.size(), 1);
    }
}
