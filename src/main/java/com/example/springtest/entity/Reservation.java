package com.example.springtest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Reservation {

    @Id
    String idReservation;

    Date anneeUniversitaire;
    Boolean estValide;


    @ManyToMany(mappedBy = "reservations2", cascade = CascadeType.ALL)
     Set<Etudiant> etudiants;
    @ManyToOne
    @JsonIgnore
    Chambre chambre;

}
