package com.example.serverspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@Entity
@NoArgsConstructor
public class PurchasedLibrary {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "purchasedLibrary")
    private User owner;

    @ManyToMany
    @JoinTable(name = "purchaser-mesh",
            joinColumns = @JoinColumn(name = "purchasedLibrary_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "mesh_id", referencedColumnName = "id"))
    private HashSet<Mesh> meshes = new HashSet<>();
}
