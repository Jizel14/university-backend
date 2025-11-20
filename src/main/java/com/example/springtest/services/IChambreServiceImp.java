package com.example.springtest.services;

import com.example.springtest.entity.Chambre;
import com.example.springtest.repository.ChambreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IChambreServiceImp implements IChambreService {

    //@Autowired
   // private ChambreRepo chambreRepo;
    private final ChambreRepo chambreRepo;

    public IChambreServiceImp(ChambreRepo chambreRepo) {
        this.chambreRepo = chambreRepo;
    }

    @Override
    public Chambre addChambre(Chambre chambre){
        return chambreRepo.save(chambre);
    };
    @Override
    public Chambre updateChambre(Chambre chambre){
        return chambreRepo.save(chambre);
    };
    @Override
    public void deleteByID(Long id){
        chambreRepo.deleteById(id);
    };
    @Override
    public Chambre findByID(Long id){
        return chambreRepo.findById(id).orElse(null);
    };
    @Override
    public List<Chambre> findAll(){
        return chambreRepo.findAll();
    };

    @Override   //keywords
    public List<Chambre> findChambrebynomBloc(String nomBloc) {
        return chambreRepo.findByBlocChambre_NomBloc(nomBloc);
    }


    @Override
    public List<Chambre> findByBlocChambreJPQL(String nomBloc) {
        return chambreRepo.findByBlocChambreJPQL(nomBloc);
    }

    @Override
    public List<Chambre> findByBlocChambreNative(String nomBloc) {
        return chambreRepo.findByBlocNameChambreNative(nomBloc);
    }

}
