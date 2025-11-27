package com.example.springtest.services;

import com.example.springtest.entity.Etudiant;
import com.example.springtest.entity.Foyer;

import java.util.List;

public interface IFoyerService {

    Foyer addFoyer(Foyer foyer);
    Foyer updateFoyer(Foyer foyer);
    void deleteFoyer(Long id);
    Foyer  findById(Long id);
    List<Foyer> findAll();
    Foyer affecterBlocAFoyer(Long idBloc, Long idFoyer);

    // Nouveau : ajouter un foyer (avec ses blocs) et l'affecter à une université
    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);

}
