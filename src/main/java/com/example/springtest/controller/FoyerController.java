package com.example.springtest.controller;

import com.example.springtest.entity.Foyer;
import com.example.springtest.services.IFoyerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foyers")
public class FoyerController {

    private final IFoyerService foyerService;

    public FoyerController(IFoyerService foyerService) {
        this.foyerService = foyerService;
    }

    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyer(id);
    }

    @GetMapping("/find/{id}")
    public Foyer findFoyerById(@PathVariable Long id) {
        return foyerService.findById(id);
    }

    @GetMapping("/all")
    public List<Foyer> findAllFoyers() {
        return foyerService.findAll();
    }
    @PutMapping("/affecterBloc/{idBloc}/{idFoyer}")
    public Foyer affecterBlocAFoyer(
            @PathVariable Long idBloc,
            @PathVariable Long idFoyer) {
        return foyerService.affecterBlocAFoyer(idBloc, idFoyer);
    }
}
