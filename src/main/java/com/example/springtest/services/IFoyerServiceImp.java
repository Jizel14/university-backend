package com.example.springtest.services;


import com.example.springtest.entity.Bloc;
import com.example.springtest.entity.Etudiant;
import com.example.springtest.entity.Foyer;
import com.example.springtest.repository.BlocRepo;
import com.example.springtest.repository.FoyerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFoyerServiceImp implements IFoyerService {

    private final FoyerRepo foyerRepo;
    private final BlocRepo blocRepo;  // Add this

    public IFoyerServiceImp(FoyerRepo foyerRepo, BlocRepo blocRepo) {
        this.foyerRepo = foyerRepo;
        this.blocRepo = blocRepo;
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
    @Override
    public Foyer affecterBlocAFoyer(Long idBloc, Long idFoyer) {
        // Find Foyer by id
        Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);

        // Find Bloc by id
        Bloc bloc = blocRepo.findById(idBloc).orElse(null);

        // If both exist, assign the bloc to the foyer
        if (foyer != null && bloc != null) {
            bloc.setFoyer(foyer);
            blocRepo.save(bloc);  // Save the bloc with the new foyer relationship
            return foyer;
        }

        return null;
    }

}
