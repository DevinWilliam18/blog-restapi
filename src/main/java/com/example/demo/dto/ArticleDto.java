package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Comment;
import com.example.demo.model.State;
import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private String title;

    private String description;

    private UserDto user;

    private State state;

    private List<CommentDto> comments;
    
}
