package com.example.springtest.controller;

import com.example.springtest.entity.University;
import com.example.springtest.services.IUniversityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final IUniversityService universityService;

    public UniversityController(IUniversityService universityService) {
        this.universityService = universityService;
    }

    @PostMapping("/add")
    public University addUniversity(@RequestBody University university) {
        return universityService.addUniversity(university);
    }

    @PutMapping("/update")
    public University updateUniversity(@RequestBody University university) {
        return universityService.updateUniversity(university);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
    }

    @GetMapping("/find/{id}")
    public University findUniversityById(@PathVariable Long id) {
        return universityService.findById(id);
    }

    @GetMapping("/all")
    public List<University> findAllUniversities() {
        return universityService.findAll();
    }
}
