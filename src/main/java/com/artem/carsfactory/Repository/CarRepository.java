package com.artem.carsfactory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artem.carsfactory.Domain.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
    
}
