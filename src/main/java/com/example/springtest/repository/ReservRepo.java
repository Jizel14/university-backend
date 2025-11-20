package com.example.springtest.repository;

import com.example.springtest.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservRepo extends JpaRepository<Reservation,String> {
}
