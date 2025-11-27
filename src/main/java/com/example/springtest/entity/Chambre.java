package com.example.springtest.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import com.example.springtest.entity.TypeChambre;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChambre;

    Long numeroChambre;
    TypeChambre typeC;

    @ManyToOne
    @JsonIgnore
    Bloc bloc;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chambre", orphanRemoval = false, fetch = FetchType.LAZY)
     Set<Reservation> reservations;

}
