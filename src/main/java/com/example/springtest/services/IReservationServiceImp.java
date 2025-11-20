package com.example.springtest.services;

import com.example.springtest.entity.Chambre;
import com.example.springtest.entity.Etudiant;
import com.example.springtest.entity.Reservation;
import com.example.springtest.repository.ChambreRepo;
import com.example.springtest.repository.EtudiantRepo;
import com.example.springtest.repository.ReservRepo;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class IReservationServiceImp implements IReservationService {

    private final ReservRepo reservationRepo;
    private final ChambreRepo chambreRepo;      // Add this
    private final EtudiantRepo etudiantRepo;    // Add this

    public IReservationServiceImp(ReservRepo reservationRepo, ChambreRepo chambreRepo, EtudiantRepo etudiantRepo) {
        this.reservationRepo = reservationRepo;
        this.chambreRepo = chambreRepo;
        this.etudiantRepo = etudiantRepo;
    }

    @Override
    public Reservation addReservation(Reservation reservation){
        return reservationRepo.save(reservation);
    }

    @Override
    public Reservation updateReservation(Reservation reservation){
        return reservationRepo.save(reservation);
    }

    @Override
    public void deleteReservation(String id){
        reservationRepo.deleteById(id);
    }

    @Override
    public Reservation findById(String id){
        return reservationRepo.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> findAll(){
        return reservationRepo.findAll();
    }
    @Override
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(Reservation res, Long numChambre, Long cin) {
        // Find Chambre by its numero
        Chambre chambre = chambreRepo.findByNumeroChambre(numChambre);

        // Find Etudiant by CIN
        Etudiant etudiant = etudiantRepo.findByCin(cin);

        // If both chambre and etudiant exist
        if (chambre != null && etudiant != null) {
            // 1. Save the reservation first
            res = reservationRepo.save(res);

            // 2. Assign reservation to chambre
            if (chambre.getReservations() == null) {
                chambre.setReservations(new HashSet<>());
            }
            chambre.getReservations().add(res);
            chambreRepo.save(chambre);

            // 3. Assign reservation to etudiant
            if (etudiant.getReservations2() == null) {
                etudiant.setReservations2(new HashSet<>());
            }
            etudiant.getReservations2().add(res);
            etudiantRepo.save(etudiant);

            return res;
        }

        return null;
    }
}
