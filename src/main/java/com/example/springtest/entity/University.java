package com.example.springtest.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUniversity;

    String nomUniversity;
    String adresse;


    @OneToOne
    Foyer foyer2;
}
