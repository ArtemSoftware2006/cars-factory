package com.artem.carsfactory.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    @OneToMany
    @JoinColumn(name = "wheel_id")
    private Wheel wheelId;
    @OneToMany
    @JoinColumn(name = "wheel_id")
    private Body bodyId;
    private String name;
}
