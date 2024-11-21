package com.dev.RealEstateMng.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table( name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payments_id;

    private BigDecimal amount;
    private Date paymentsDate ;
    private PaymentsMethods paymentsMethds;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "rentals_id" , nullable = false)
    private Rentals rental;

    public enum PaymentsMethods{
        Cash,
        BankTransfer,
        CreditCard
    }
    public enum Status{
        Pending,
        Completed,
        Failed
    }
}
