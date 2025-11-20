package com.example.springtest.services;

import com.example.springtest.entity.Bloc;

import java.util.List;

public interface IBlocService {

    Bloc addBloc(Bloc bloc);
    Bloc updateBloc(Bloc bloc);
    void deleteByID(Long id);
    Bloc findByID(Long id);
    List<Bloc> findAll();

    Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
}
