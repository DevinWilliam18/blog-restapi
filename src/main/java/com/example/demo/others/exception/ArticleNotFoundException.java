package com.example.demo.others.exception;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException (String desc){
        super("Article not found with" + desc);
    }
}
