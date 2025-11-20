package com.example.springtest.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFoyer;
    String nomFoyer;
    Long capaciteFoyer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foyer")
     Set<Bloc> Bloc;

    @OneToOne(mappedBy = "foyer2")
     University university;

}


// @FieldDefaults(level = AccessLevel.PRIVATE)