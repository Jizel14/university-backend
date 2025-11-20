package com.example.springtest.services;

import com.example.springtest.entity.Bloc;
import com.example.springtest.entity.Chambre;
import com.example.springtest.repository.BlocRepo;
import com.example.springtest.repository.ChambreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBlocServiceImp implements IBlocService {

    private final BlocRepo blocRepo;
    private final ChambreRepo chambreRepo;  // Add this

    public IBlocServiceImp(BlocRepo blocRepo, ChambreRepo chambreRepo) {
        this.blocRepo = blocRepo;
        this.chambreRepo = chambreRepo;
    }


    @Override
    public Bloc addBloc(Bloc bloc){
        return blocRepo.save(bloc);
    };
    @Override
    public Bloc updateBloc(Bloc bloc){
        return blocRepo.save(bloc);
    };
    @Override
    public void deleteByID(Long id){
        blocRepo.deleteById(id);
    };
    @Override
    public Bloc findByID(Long id){
        return blocRepo.findById(id).get();
    };
    @Override
    public List<Bloc> findAll(){
        return blocRepo.findAll();
    };
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        // Find the Bloc by its name
        Bloc bloc = blocRepo.findByNomBloc(nomBloc);

        if (bloc != null) {
            // Loop through each chambre number
            for (Long numCh : numChambre) {
                // Find chambre by its numero
                Chambre chambre = chambreRepo.findByNumeroChambre(numCh);

                // If chambre exists, assign it to the bloc
                if (chambre != null) {
                    chambre.setBloc(bloc);
                    chambreRepo.save(chambre);
                }
            }
        }

        return bloc;
    }
}
