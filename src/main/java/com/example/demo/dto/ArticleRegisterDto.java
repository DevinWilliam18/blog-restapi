package com.example.demo.dto;


import com.example.demo.model.State;

import lombok.Data;

@Data
public class ArticleRegisterDto {

    private String title;

    private String description;

    private String userId;

    private State state;
    
}
