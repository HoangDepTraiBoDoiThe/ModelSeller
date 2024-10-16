package com.example.serverspring.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@Entity
@NoArgsConstructor
public class UploadedLibrary {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "uploadedLibrary")
    private User owner;

    @ManyToMany
    @JoinTable(name = "uploader-mesh",
            joinColumns = @JoinColumn(name = "uploadedLibrary_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "mesh_id", referencedColumnName = "id"))
    private HashSet<Mesh> meshes = new HashSet<>();
}
