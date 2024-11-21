package com.dev.RealEstateMng.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviews_id;

    @ManyToOne
    @JoinColumn(name = "properties_id",nullable = false)
    private Properties properties;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    private int rating;
    private String comment;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
