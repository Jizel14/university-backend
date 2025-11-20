package com.example.springtest.controller;

import com.example.springtest.entity.Bloc;
import com.example.springtest.services.IBlocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocs")
public class BlocController {

    private final IBlocService blocService;

    public BlocController(IBlocService blocService) {
        this.blocService = blocService;
    }

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.deleteByID(id);
    }

    @GetMapping("/find/{id}")
    public Bloc findBlocById(@PathVariable Long id) {
        return blocService.findByID(id);
    }

    @GetMapping("/all")
    public List<Bloc> findAllBlocs() {
        return blocService.findAll();
    }
    @PutMapping("/affecterChambres/{nomBloc}")
    public Bloc affecterChambresABloc(
            @RequestBody List<Long> numChambre,
            @PathVariable String nomBloc) {
        return blocService.affecterChambresABloc(numChambre, nomBloc);
    }
}
