package com.example.springtest.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEtudiant;

    String nomEtudiant;
    String prenomEtudiant;
    Long cin;
    String ecole;
    Date dateNaissance;

    @ManyToMany(cascade = CascadeType.ALL)
     Set<Reservation> reservations2;
}
