package com.dev.RealEstateMng.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "properties")
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id",nullable = false)
    private User user;

    private String description;
    private String title;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String adresse;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "properties", cascade = CascadeType.ALL)
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "properties", cascade = CascadeType.ALL)
    private List<ServiceRequest> request;

    public enum Type{
        Apartment
        ,House
        ,Commercial
        ,Land
    }

    public enum Status{
        Available,
        Rented,
        Sold
    }

}
