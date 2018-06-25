package com.mocaste.dmv;

import java.util.stream.Stream;

import com.mocaste.dmv.dao.Car;
import com.mocaste.dmv.dao.Owner;
import com.mocaste.dmv.dao.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;
import com.mocaste.dmv.repository.RegistrationRepository;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class DMVRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(DMVRepositoryApplication.class, args);
	}

	@Component
	class SampleDataCLR implements CommandLineRunner {

		private final RegistrationRepository registrationRepository;

		@Autowired
		public SampleDataCLR(RegistrationRepository registrationRepository) {
			this.registrationRepository = registrationRepository;
		}

		@Override
		public void run(String... strings) throws Exception {
			Registration reg=new Registration("b24agc", new Car("opel", "2017","xpr"), new Owner("Andrei",25,"address 1"));
			Registration reg1=new Registration("ag44agc", new Car("toyota", "2018","ttrt"), new Owner("ION",22,"address ion"));

			Stream.of(reg, reg1)
					.forEach(n -> registrationRepository.save(n));
			registrationRepository.findAll().forEach(System.out::println);
		}
	}

}
