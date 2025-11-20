package com.example.springtest.repository;

import com.example.springtest.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepo extends JpaRepository<Etudiant,Long> {
}
