package br.com.rf.JavaWithMongo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import br.com.rf.JavaWithMongo.model.Car;
import br.com.rf.JavaWithMongo.repository.CarRepository;

@SpringBootApplication
public class JavaWithMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaWithMongoApplication.class, args);
	}

	@Component
	class SimpleDataCRL implements CommandLineRunner {
		private CarRepository carRepository;

		public SimpleDataCRL(CarRepository carRepository) {
			this.carRepository = carRepository;
		}

		@Override
		public void run(String... strings) throws Exception {
			carRepository.deleteAll();
			
			Stream.of("VW,Golf", "VW,Touareg", "VW,Fusca",
					"Audi,A3", "Audi,A4", "Audi,A8",
					"Mercedes,GT", "Mercedes,A45", "Mercedes,E63")
				.map( fn -> fn.split(",") )
				.forEach( car -> carRepository.save(new Car(car[0], car[1])));

			carRepository.all().forEach(System.out::println);
		}
	}
}
