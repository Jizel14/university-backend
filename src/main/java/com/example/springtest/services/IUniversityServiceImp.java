package com.example.springtest.services;

import com.example.springtest.entity.University;
import com.example.springtest.repository.UniversityRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUniversityServiceImp implements IUniversityService {

    private final UniversityRepo universityRepo;

    public IUniversityServiceImp(UniversityRepo universityRepo) {
        this.universityRepo = universityRepo;
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
}
