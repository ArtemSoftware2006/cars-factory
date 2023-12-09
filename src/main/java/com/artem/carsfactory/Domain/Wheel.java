package com.artem.carsfactory.Domain;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Collate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    @OneToMany(mappedBy = "wheelId", cascade = CascadeType.ALL)
    private List<Car> cars;

    public Wheel() {
        
    }
    public Wheel(String whellSize) {
        this.whellSize = whellSize;
    }

    public Long getWheelId() {
        return wheelId;
    }

    public void setWheelId(Long wheelId) {
        this.wheelId = wheelId;
    }

    public String getWhellSize() {
        return whellSize;
    }

    public void setWhellSize(String whellSize) {
        this.whellSize = whellSize;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
