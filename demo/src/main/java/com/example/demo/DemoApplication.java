package com.example.demo;

import com.example.demo.entities.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

//        User user = User.builder()
//                .name("ahmed")
//                .email("a@b.com")
//                .password("123456")
//                .build();

//		Address address = Address.builder()
//				.city("city")
//				.street("street")
//				.zip("zip")
//				.state("state")
//				.build();
//
//		user.addAddress(address);

//		Tag tag = new Tag("tag1");
//		user.getTags().add(tag);

//        Profile profile = Profile.builder()
//                .bio("bio")
//                .build();
//
//		user.setProfile(profile);
//		profile.setUser(user);
//
//        System.out.println(user);

        Category category = Category.builder()
                .name("Drinks")
                .build();

        Product product = Product.builder()
                .name("spiro")
                .price(BigDecimal.valueOf(6.5))
                .build();

        category.addProduct(product);

        System.out.println(category);
    }

}
