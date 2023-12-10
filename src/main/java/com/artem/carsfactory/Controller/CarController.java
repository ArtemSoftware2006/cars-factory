package com.artem.carsfactory.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.artem.carsfactory.Domain.Body;
import com.artem.carsfactory.Domain.Car;
import com.artem.carsfactory.Domain.Wheel;
import com.artem.carsfactory.Dto.CarCreateDto;
import com.artem.carsfactory.Repository.BodyRepository;
import com.artem.carsfactory.Repository.CarRepository;
import com.artem.carsfactory.Repository.WheelRepository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController()
public class CarController {

    private final BodyRepository bodyRepository;
    private final WheelRepository wheelRepository;
    private final CarRepository carRepository;

    public CarController(BodyRepository bodyRepository,
        WheelRepository wheelRepository,
        CarRepository carRepository) 
    {
        this.bodyRepository = bodyRepository;
        this.wheelRepository = wheelRepository;
        this.carRepository = carRepository;
    }   

    @GetMapping("/bodies")
    @Cacheable(cacheNames = "bodiesCache")
    public ResponseEntity<List<Body>> getBodies() {
        return ResponseEntity.ok(bodyRepository.findAll());
    }

    @GetMapping("/wheels")
    @Cacheable(cacheNames = "wheelsCache")
    public ResponseEntity<List<Wheel>> getWheels() {
        return ResponseEntity.ok(wheelRepository.findAll());
    }

    @GetMapping("/car/{id}")
    @Cacheable(cacheNames = "carsCache", key = "#id")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);

        if(car.isPresent()) {
            return ResponseEntity.ok(car.get());
        }

        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/car")
    public ResponseEntity<Car> createCar(@RequestBody CarCreateDto model) {
       Optional<Wheel> wheel = wheelRepository.findById(model.getWheelId());
       Optional<Body> body = bodyRepository.findById((model.getBodyId()));

       if(wheel.isPresent() && body.isPresent()) {
           Car car = new Car(wheel.get(), body.get(), model.getName(), model.getCountWheels());
           Car saveCar = carRepository.save(car);
           return ResponseEntity.ok(saveCar);
       }
        return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/cars")
    @Cacheable(cacheNames = "carsCache")
    public ResponseEntity<List<Car>> getCars(@RequestParam int page, 
            @RequestParam int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        HttpHeaders responseHeaders = new HttpHeaders();
        long totalCount = carRepository.count(); 
        responseHeaders.set("X-Total-Count",  String.valueOf(totalCount));

        List<Car> cars = carRepository.findAll(pageable).toList();

        return ResponseEntity.ok()
            .headers(responseHeaders)
            .body(cars);
    }   
}
