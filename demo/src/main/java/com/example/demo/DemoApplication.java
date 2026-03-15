package com.example.demo;

import com.example.demo.entities.Address;
import com.example.demo.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

		User user = User.builder()
				.name("ahmed")
				.email("a@b.com")
				.password("123456")
				.build();

		Address address = Address.builder()
				.city("city")
				.street("street")
				.zip("zip")
				.state("state")
				.build();

		user.addAddress(address);

		System.out.println(user);

	}

}
