package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;

@Builder
@Entity
public class Comment {
    
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(name = "comment_body")
    private String commentBody;

    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")    
    private Article article;

    private Timestamp created_at;

    private Timestamp updated_at;
    
}
