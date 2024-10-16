package com.example.serverspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@Entity
@NoArgsConstructor
public class Mesh {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double price;

    public Mesh(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @ManyToMany(mappedBy = "meshes")
    private HashSet<PurchasedLibrary> purchasers = new HashSet<>();

    @ManyToMany(mappedBy = "meshes")
    private HashSet<UploadedLibrary> uploaders = new HashSet<>();

    @ManyToMany(mappedBy = "meshes")
    private HashSet<Cart> carts = new HashSet<>();
}
