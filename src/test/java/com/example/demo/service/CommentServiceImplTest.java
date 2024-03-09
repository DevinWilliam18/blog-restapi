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

import com.example.demo.model.Article;
import com.example.demo.model.Comment;
import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.repo.CommentRepo;
import com.example.demo.service.impl.CommentServiceImpl;


@ExtendWith(MockitoExtension.class)
public class CommentServiceImplTest {

    @Mock
    private CommentRepo commentRepo;

    @InjectMocks
    private CommentServiceImpl commentServiceImpl;

    private Comment comment;

    private Article article;

    private User user;

    @BeforeEach
    private void initData(){
        user = User
                .builder()
                .id("---TEST-USER---")
                .fullname("VIns")
                .email("devin@gmail.com")
                .password("xx090")
                .username("vindes_99")
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .updatedAt(new Timestamp(System.currentTimeMillis()))
                .build();
        
        article = Article
                    .builder()
                    .id("--TEST-Article--")
                    .title("Java Framework")
                    .description("adasdadadjakdjajd")
                    .state(State.PUBLISHED)
                    .user(user)
                    .created_at(new Timestamp(System.currentTimeMillis()))
                    .updated_at(new Timestamp(System.currentTimeMillis()))
                    .build();

        comment = Comment
                    .builder()
                    .id("--TEST-Comment--")
                    .commentBody("bad topics")
                    .article(article)
                    .user(user)
                    .created_at(new Timestamp(System.currentTimeMillis()))
                    .updated_at(new Timestamp(System.currentTimeMillis()))
                    .build();
        
    }

    @Test
    void testGetCommentsByArticleId() {
        when(commentRepo.findByArticleId(article.getId())).thenReturn(Arrays.asList(comment));
        
        List<Comment> storedComments = commentServiceImpl.getCommentsByArticleId(article.getId());

        assertEquals(storedComments.size(), 1);
    
    }


    @Test
    void testGetCommentsByUserId() {
        when(commentRepo.findByUserId(user.getId())).thenReturn(Arrays.asList(comment));
        
        List<Comment> storedComments = commentServiceImpl.getCommentsByUserId(user.getId());

        assertEquals(storedComments.size(), 1);
    }

    @Test
    void testSave() {
        when(commentRepo.saveAndFlush(comment)).thenReturn(comment);
    
        Comment storedComment =  commentServiceImpl.save(comment);

        verify(commentRepo, times(1)).saveAndFlush(comment);

        assertEquals(storedComment.getId(), comment.getId());
    }
}
