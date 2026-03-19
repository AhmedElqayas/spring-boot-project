package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Byte id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "category")
    @Builder.Default
    private Set<Product> products = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
}
