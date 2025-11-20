package com.example.springtest.services;

import com.example.springtest.entity.Foyer;
import com.example.springtest.entity.University;
import com.example.springtest.repository.FoyerRepo;
import com.example.springtest.repository.UniversityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUniversityServiceImp implements IUniversityService {

    private final UniversityRepo universityRepo;
    private final FoyerRepo foyerRepo;  // Add this


    public IUniversityServiceImp(UniversityRepo universityRepo, FoyerRepo foyerRepo) {
        this.universityRepo = universityRepo;
        this.foyerRepo = foyerRepo;  // Add this

    }

    @Override
    public University addUniversity(University university) {
        return universityRepo.save(university);
    }

    @Override
    public University updateUniversity(University university) {
        return universityRepo.save(university);
    }

    @Override
    public void deleteUniversity(Long id) {
        universityRepo.deleteById(id);
    }

    @Override
    public University findById(Long id) {
        return universityRepo.findById(id).orElse(null);
    }

    @Override
    public List<University> findAll() {
        return universityRepo.findAll();
    }

    @Override
    public University affecterFoyerAUniversite(Long idFoyer, String nomUniversity) {
        // Find university by name using the repository method
        University university = universityRepo.findByNomUniversity(nomUniversity);

        // Find foyer by id
        Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);

        // If both exist, assign foyer to university
        if (university != null && foyer != null) {
            university.setFoyer2(foyer);  // Note: your entity uses 'foyer2'
            return universityRepo.save(university);
        }

        return null;
    }
}
