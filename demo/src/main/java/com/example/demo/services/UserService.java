package com.example.demo.services;

import com.example.demo.entities.Address;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private EntityManager entityManager;
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Transactional
    public void showEntityState() {
        User user = User.builder()
                .name("Ahmed")
                .email("a@b.com")
                .password("123456")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    @Transactional
    public void showRelatedEntities() {
        Address address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getZip());
    }

    public void persistRelated() {
        User user = User.builder()
                .name("Mohamed")
                .email("m@b.com")
                .password("951236")
                .build();

        Address address = Address.builder()
                .street("street")
                .state("state")
                .zip("35122")
                .city("city")
                .build();

        user.addAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        User user = userRepository.findById(5L).orElseThrow();
        Address address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    public void addProduct() {
        Category category = new Category("Electrical Devices");

        Product product = Product.builder()
                .name("TV")
                .price(BigDecimal.valueOf(1200.50))
                .category(category)
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void addProductToExistedCategory() {
        Category category = categoryRepository.findById((byte) 2).orElseThrow();

        Product product = Product.builder()
                .name("AC")
                .price(BigDecimal.valueOf(1200.50))
                .category(category)
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void addProductsToUser() {
        User user = userRepository.findById(3L).orElseThrow();
        productRepository.findAll().forEach(user::addProduct);
        userRepository.save(user);
    }

    public void deleteProduct() {
        productRepository.deleteById(3L);
    }

}
