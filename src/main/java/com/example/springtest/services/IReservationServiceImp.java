package com.example.springtest.services;

import com.example.springtest.entity.Reservation;
import com.example.springtest.repository.ReservRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IReservationServiceImp implements IReservationService {

    private final ReservRepo reservationRepo;

    public IReservationServiceImp(ReservRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
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
}
