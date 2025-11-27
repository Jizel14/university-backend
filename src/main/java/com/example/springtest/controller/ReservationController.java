package com.example.springtest.controller;

import com.example.springtest.entity.Reservation;
import com.example.springtest.services.IReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final IReservationService reservationService;

    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/add")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable String id) {
        reservationService.deleteReservation(id);
    }

    @GetMapping("/find/{id}")
    public Reservation findReservationById(@PathVariable String id) {
        return reservationService.findById(id);
    }

    @GetMapping("/all")
    public List<Reservation> findAllReservations() {
        return reservationService.findAll();
    }
    @PostMapping("/ajouterEtAssigner/{numChambre}/{cin}")
    public Reservation ajouterReservationEtAssignerAChambreEtAEtudiant(
            @RequestBody Reservation reservation,
            @PathVariable Long numChambre,
            @PathVariable Long cin) {
        return reservationService.ajouterReservationEtAssignerAChambreEtAEtudiant(
                reservation, numChambre, cin);
    }

    // New endpoint: POST /reservations/ajouter/{idBloc}/{cin}
    @PostMapping("/ajouter/{idBloc}/{cin}")
    public Reservation ajouterReservation(
            @PathVariable("idBloc") long idBloc,
            @PathVariable("cin") long cin) {
        return reservationService.ajouterReservation(idBloc, cin);
    }
}
