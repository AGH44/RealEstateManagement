package com.dev.RealEstateMng.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "rentals")
public class Rentals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rentals_id;
    private Date startDate ;
    private Date endDate;
    private BigDecimal monthlyRent;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "properties_id" , nullable = false)
    private Properties property;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        Active,
        Terminated
    }


}
