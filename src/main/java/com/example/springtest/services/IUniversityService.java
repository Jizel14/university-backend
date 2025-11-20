package com.example.springtest.services;

import com.example.springtest.entity.Bloc;
import com.example.springtest.entity.University;
import java.util.List;

public interface IUniversityService {
    University addUniversity(University university);
    University updateUniversity(University university);
    void deleteUniversity(Long id);
    University findById(Long id);
    List<University> findAll();

    University affecterFoyerAUniversite(Long idFoyer, String nomUniversite);


}
