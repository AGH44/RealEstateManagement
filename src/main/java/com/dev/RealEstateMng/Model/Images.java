package com.dev.RealEstateMng.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Images")
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long image_id;
    @Column(name="image_url")
    private String image_url;


    @ManyToOne
    @JoinColumn(name = "properties_id", nullable = false)
    private Properties properties;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;




}
