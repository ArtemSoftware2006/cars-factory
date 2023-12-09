package com.artem.carsfactory.Initialization;

import java.util.Arrays;

import org.hibernate.mapping.Array;
import org.hibernate.mapping.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.artem.carsfactory.Domain.Body;
import com.artem.carsfactory.Domain.Wheel;
import com.artem.carsfactory.Repository.BodyRepository;
import com.artem.carsfactory.Repository.WheelRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BodyRepository bodyRepository;
    private final WheelRepository wheelRepository;

    public DataInitializer(BodyRepository bodyRepository, 
        WheelRepository wheelRepository) {
        this.bodyRepository = bodyRepository;
        this.wheelRepository = wheelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Wheel r15 = new Wheel("R15");
        Wheel r16 = new Wheel("R16");
        Wheel r17 = new Wheel("R17");

        Body hatchback = new Body("hatchback");
        Body sedan = new Body("sedan");

        wheelRepository.saveAll(Arrays.asList(r15, r16, r17));
        bodyRepository.saveAll(Arrays.asList(sedan, hatchback));
    }
}