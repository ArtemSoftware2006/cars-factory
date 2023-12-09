package com.artem.carsfactory.Domain;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Collate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Wheels")
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wheel_id")
    private Long wheelId;
    private String whellSize;
    @OneToMany(mappedBy = "wheelId", cascade = CascadeType.ALL)
    private List<Car> cars;

    public Wheel(String whellSize) {
        this.whellSize = whellSize;
    }
}
