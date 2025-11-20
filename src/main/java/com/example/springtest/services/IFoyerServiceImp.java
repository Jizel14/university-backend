package com.example.springtest.services;


import com.example.springtest.entity.Etudiant;
import com.example.springtest.entity.Foyer;
import com.example.springtest.repository.FoyerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFoyerServiceImp implements IFoyerService {

    private final FoyerRepo foyerRepo;
    public IFoyerServiceImp(FoyerRepo foyerRepo) {
        this.foyerRepo = foyerRepo;
    }
    @Override
    public Foyer addFoyer(Foyer foyer){
        return foyerRepo.save(foyer);
    };
    @Override
    public Foyer updateFoyer(Foyer foyer){
        return foyerRepo.save(foyer);
    };
    @Override
    public void deleteFoyer(Long id){
        foyerRepo.deleteById(id);
    };
    @Override
    public Foyer  findById(Long id){
        return foyerRepo.findById(id).orElse(null);
    };
    @Override
    public List<Foyer> findAll(){
        return foyerRepo.findAll();
    };

}
