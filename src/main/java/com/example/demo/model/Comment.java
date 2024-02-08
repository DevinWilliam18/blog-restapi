package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Table(name = "comments")
@Data
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

    
    @ManyToOne
    @JoinColumn(name = "article_id")    
    private Article article;

    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private Timestamp created_at;

    private Timestamp updated_at;
    
}
