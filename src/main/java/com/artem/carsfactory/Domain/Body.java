package com.artem.carsfactory.Domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.List;
import java.util.Set;

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
    @OneToMany(mappedBy = "bodyId", cascade = CascadeType.ALL)
    private List<Car> cars;

    public Body(String bodyType) {
        this.bodyType = bodyType;
    }

}
