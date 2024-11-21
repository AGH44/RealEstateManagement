package com.dev.RealEstateMng.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String adresse;
    private String email;
    private String name;
    private String password;
    private String phone;

    @OneToMany(mappedBy = "Users" , cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "Users", cascade = CascadeType.ALL)
    private List<Rentals> rentals;

    @OneToMany(mappedBy = "Users",cascade =CascadeType.ALL)
    private List<Properties> properties;

    @OneToMany(mappedBy = "Users", cascade = CascadeType.ALL)
    private List<Reviews> reviews;

    @OneToMany(mappedBy = "Users", cascade = CascadeType.ALL)
    private List<ServiceRequest> request;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        Admin,
        PropertyOwner,
        Tenant,
        ServiceProvider
    }

}
