package com.example.springtest.services;

import com.example.springtest.entity.Chambre;

import java.util.List;

public interface IChambreService {

    Chambre addChambre(Chambre chambre);
    Chambre updateChambre(Chambre chambre);
    void deleteByID(Long id);
    Chambre findByID(Long id);
    List<Chambre> findAll();
    List<Chambre> findChambrebynomBloc(String nomBloc); //keywords
    List<Chambre> findByBlocChambreJPQL(String nomBloc); //JPQL



    List<Chambre> findByBlocChambreNative(String nomBloc);

}
