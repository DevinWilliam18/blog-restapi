package com.example.demo.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Builder;
import lombok.Data;

/**
 * Friendship
 */
@Entity
@Builder
@Data
public class Friendship {
    

    @Id
    @Column(name = "friendship_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )    
    private String id;


    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private User from;

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private User to;

    @Column(name = "created_at")
    private Timestamp createdAt;


    @Column(name = "updated_at")
    private Timestamp updatedAt;

}