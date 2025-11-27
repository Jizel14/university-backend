package com.example.springtest.services;


import com.example.springtest.entity.Bloc;
import com.example.springtest.entity.Etudiant;
import com.example.springtest.entity.Foyer;
import com.example.springtest.entity.University;
import com.example.springtest.repository.BlocRepo;
import com.example.springtest.repository.FoyerRepo;
import com.example.springtest.repository.UniversityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFoyerServiceImp implements IFoyerService {

    private final FoyerRepo foyerRepo;
    private final BlocRepo blocRepo;  // Add this
    private final UniversityRepo universityRepo;


    public IFoyerServiceImp(FoyerRepo foyerRepo, BlocRepo blocRepo, UniversityRepo universityRepo) {
        this.foyerRepo = foyerRepo;
        this.blocRepo = blocRepo;
        this.universityRepo = universityRepo;
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

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        // 1) Récupère l'université
        University university = universityRepo.findById(idUniversite).orElse(null);
        if (university == null) {
            return null; // ou lancer une exception / ResponseStatusException(404)
        }

        // 2) Si le foyer contient des blocs fournis, lier chaque bloc au foyer
        //    (Important : s'assurer que chaque bloc a bien bloc.setFoyer(foyer))
        if (foyer.getBloc() != null) {
            for (Bloc b : foyer.getBloc()) {
                b.setFoyer(foyer);
            }
        }

        // 3) Sauvegarder le foyer (cascade = ALL devrait persister les blocs)
        Foyer savedFoyer = foyerRepo.save(foyer);

        // 4) Affecter le foyer à l'université (University est le owning side)
        university.setFoyer2(savedFoyer);
        University savedUniversity = universityRepo.save(university);

        // 5) Mettre à jour la référence back si tu veux cohérence en mémoire
        savedFoyer.setUniversity(savedUniversity);
        savedFoyer = foyerRepo.save(savedFoyer);

        return savedFoyer;
    }

}
