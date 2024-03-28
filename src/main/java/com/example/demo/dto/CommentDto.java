package com.example.demo.dto;

import lombok.Data;

@Data
public class CommentDto {

    private String id;
    private String commentBody;
    private UserDto user;
}
