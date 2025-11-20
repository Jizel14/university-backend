package com.example.springtest.repository;

import com.example.springtest.entity.Foyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoyerRepo extends JpaRepository<Foyer,Long> {
}
