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
    private int countWheels;

    public Car() {
        
    }

    public Car(Wheel wheelId, Body bodyId, String name, int countWheels) {
        this.wheelId = wheelId;
        this.bodyId = bodyId;
        this.name = name;
        this.countWheels = countWheels;
    }
    public int getCountWheels() {
        return countWheels;
    }
    public void setCountWheels(int countWheels) {
        this.countWheels = countWheels;
    }
    public Long getCarId() {
        return carId;
    }
    public void setCarId(Long carId) {
        this.carId = carId;
    }
    public Wheel getWheelId() {
        return wheelId;
    }
    public void setWheelId(Wheel wheelId) {
        this.wheelId = wheelId;
    }
    public Body getBodyId() {
        return bodyId;
    }
    public void setBodyId(Body bodyId) {
        this.bodyId = bodyId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
