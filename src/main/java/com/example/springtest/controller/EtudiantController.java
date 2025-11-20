package com.example.springtest.controller;

import com.example.springtest.entity.Etudiant;
import com.example.springtest.services.IEtudiantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    private final IEtudiantService etudiantService;

    public EtudiantController(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/find/{id}")
    public Etudiant findEtudiantById(@PathVariable Long id) {
        return etudiantService.findById(id);
    }

    @GetMapping("/all")
    public List<Etudiant> findAllEtudiants() {
        return etudiantService.findAll();
    }
}
