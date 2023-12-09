package com.artem.carsfactory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artem.carsfactory.Domain.Body;

public interface BodyRepository extends JpaRepository<Body, Long> {
    
}
