package com.example.springtest.services;

import com.example.springtest.entity.Bloc;
import com.example.springtest.entity.Chambre;
import com.example.springtest.entity.Etudiant;
import com.example.springtest.entity.Reservation;
import com.example.springtest.repository.BlocRepo;
import com.example.springtest.repository.ChambreRepo;
import com.example.springtest.repository.EtudiantRepo;
import com.example.springtest.repository.ReservRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Set;


@Service
public class IReservationServiceImp implements IReservationService {

    private final ReservRepo reservationRepo;
    private final ChambreRepo chambreRepo;      // Add this
    private final EtudiantRepo etudiantRepo;    // Add this
    private final BlocRepo blocRepo;


    public IReservationServiceImp(ReservRepo reservationRepo, ChambreRepo chambreRepo, EtudiantRepo etudiantRepo, BlocRepo blocRepo) {
        this.reservationRepo = reservationRepo;
        this.chambreRepo = chambreRepo;
        this.etudiantRepo = etudiantRepo;
        this.blocRepo = blocRepo;
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

    @Override
    @Transactional
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        // 1) find bloc
        Bloc bloc = blocRepo.findById(idBloc)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bloc not found"));

        // 2) find student - adapt si your repo returns Optional or entity directly
        // If etudiantRepo.findByCin returns Etudiant (not Optional):
        Etudiant etudiant = etudiantRepo.findByCin(cinEtudiant);
        if (etudiant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }

        // 3) find an available chambre in the bloc
        Chambre available = null;
        for (Chambre chambre : bloc.getChambre()) {
            int capacity = capacityFor(chambre.getTypeC());
            long currentOccupancy = 0;
            if (chambre.getReservations() != null) {
                currentOccupancy = chambre.getReservations().stream()
                        .filter(r -> Boolean.TRUE.equals(r.getEstValide()))
                        .count();
            }
            if (currentOccupancy < capacity) {
                available = chambre;
                break;
            }
        }

        if (available == null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "No available chambre in this bloc");
        }

        // 4) build reservation
        String numReservation = available.getNumeroChambre() + "-" + bloc.getNomBloc() + "-" + buildAcademicYear(LocalDate.now());

        Reservation reservation = new Reservation();
        reservation.setIdReservation(numReservation);

        // If Reservation.anneeUniversitaire is a java.util.Date :
        reservation.setAnneeUniversitaire(new Date());

        reservation.setEstValide(true);

        // 5) assign chambre — ADAPTEZ ICI AU NOM DU SETTER DANS Reservation.java
        // If Reservation has setChambre(Chambre):
        reservation.setChambre(available);
        // Otherwise, use the actual setter name in Reservation.java

        // 6) assign student(s)
        Set<Etudiant> etus = new HashSet<>();
        etus.add(etudiant);
        reservation.setEtudiants(etus);

        // 7) persist
        Reservation saved = reservationRepo.save(reservation);

        // 8) optional: add saved to chambre reservations in memory
        if (available.getReservations() != null) {
            available.getReservations().add(saved);
        }

        return saved;
    }

    // helper: map TypeChambre to capacity
    private int capacityFor(com.example.springtest.entity.TypeChambre type) {
        if (type == null) return 1;
        switch (type) {
            case DOUBLE: return 2;
            case TRIPLE: return 3;
            default: // SIMPLE and any other
                return 1;
        }
    }

    // helper: build academic year string like "2025-2026"
    private String buildAcademicYear(LocalDate date) {
        int year = date.getYear();
        // if month before September, academic year is previousYear-currentYear? adjust rule to your locale
        if (date.getMonthValue() < 9) {
            return (year -1) + "-" + year;
        } else {
            return year + "-" + (year + 1);
        }
    }
}
