package com.example.demo.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Table(name = "articles")
@Data
public class Article {

    @Id
    @Column(name = "article_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    

    @Enumerated(EnumType.STRING)
    private State state;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;

    private Timestamp created_at;

    private Timestamp updated_at;

    


}
