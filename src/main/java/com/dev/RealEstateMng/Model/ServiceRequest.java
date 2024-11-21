package com.dev.RealEstateMng.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name= "serviceRequest")
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long request_id;

    @ManyToOne
    @JoinColumn(name = "properties_id" , nullable = false)
    private Properties properties;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime resolvedAt;

    public enum Status{
        Pending,
        InProgress,
        Resolved
    }

}
