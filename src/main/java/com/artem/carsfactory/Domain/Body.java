package com.artem.carsfactory.Domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bodies")
public class Body {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "body_id")
    private Long bodyId;
    private String bodyType;
    
    @JsonIgnore
    @OneToMany(mappedBy = "bodyId", cascade = CascadeType.ALL )
    private List<Car> cars;

    public Body() {
        
    }

    public Body(String bodyType) {
        this.bodyType = bodyType;
    }

    public Body(Long bodyId, String bodyType, List<Car> cars) {
        this.bodyId = bodyId;
        this.bodyType = bodyType;
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

     public Long getBodyId() {
        return bodyId;
    }

    public void setBodyId(Long bodyId) {
        this.bodyId = bodyId;
    }
}
