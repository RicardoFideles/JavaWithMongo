package br.com.rf.JavaWithMongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.rf.JavaWithMongo.model.Car;

public interface CarRepository extends MongoRepository<Car, String> {

	@Query("{}")
	List<Car> all();

	List<Car> findByBrand(String brand);

	List<Car> findByModel(String model);
}
