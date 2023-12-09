package com.artem.carsfactory.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artem.carsfactory.Domain.Wheel;

@Repository
public interface WheelRepository extends JpaRepository<Wheel, Long> {

}
