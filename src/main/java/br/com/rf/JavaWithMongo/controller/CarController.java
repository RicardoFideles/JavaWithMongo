package br.com.rf.JavaWithMongo.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rf.JavaWithMongo.model.Car;
import br.com.rf.JavaWithMongo.repository.CarRepository;

@RestController
public class CarController {

	private CarRepository carRepository;

	public CarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	private List<Car> findAll() {
		return carRepository.findAll();
	}

	@PostMapping(value = "/brand", consumes = MediaType.APPLICATION_JSON_VALUE)
	private List<Car> findByBrand(@RequestBody Car car) {
		return carRepository.findByBrand(car.getBrand());
	}

	@PostMapping(value = "/model", consumes = MediaType.APPLICATION_JSON_VALUE)
	private List<Car> findByModel(@RequestBody Car car) {
		return carRepository.findByModel(car.getModel());
	}
}
