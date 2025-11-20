package com.example.springtest.services;

import com.example.springtest.entity.Etudiant;
import com.example.springtest.repository.EtudiantRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IEtudiantServiceImp implements IEtudiantService {

    private final EtudiantRepo etudiantRepo;

    public IEtudiantServiceImp(EtudiantRepo etudiantRepo) {
        this.etudiantRepo = etudiantRepo;
    }


    @Override
    public Etudiant addEtudiant(Etudiant etudiant){
        return etudiantRepo.save(etudiant);
    };
    public Etudiant updateEtudiant(Etudiant etudiant){
        return etudiantRepo.save(etudiant);
    };
    public void deleteEtudiant(Long id){
        etudiantRepo.deleteById(id);
    };
    public Etudiant  findById(Long id){
        return etudiantRepo.findById(id).orElse(null);
    };
    // find all
    public List<Etudiant> findAll(){
        return etudiantRepo.findAll();
    };
}
