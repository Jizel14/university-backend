package com.example.springtest.services;

import com.example.springtest.entity.Reservation;

import java.util.List;

public interface IReservationService {

    Reservation addReservation(Reservation reservation);

    Reservation updateReservation(Reservation reservation);

    void deleteReservation(String id);

    Reservation findById(String id);

    List<Reservation> findAll();
    Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, Long cin);

    public Reservation ajouterReservation(long idBloc, long cinEtudiant);


}
