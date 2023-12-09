package com.artem.carsfactory.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @ManyToOne
    @JoinColumn(name = "wheel_id", referencedColumnName = "wheel_id")
    private Wheel wheelId;

    @ManyToOne
    @JoinColumn(name = "body_id", referencedColumnName = "body_id")
    private Body bodyId;
    private String name;
}
