package com.example.springtest.services;

import com.example.springtest.entity.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);
    Etudiant updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);
    Etudiant  findById(Long id);
    // find all
    List<Etudiant> findAll();

}
