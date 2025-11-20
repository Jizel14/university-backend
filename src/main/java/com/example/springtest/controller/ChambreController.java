package com.example.springtest.controller;

import com.example.springtest.entity.Chambre;
import com.example.springtest.services.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/chambres")
@CrossOrigin(origins = "*")
@AllArgsConstructor
@Tag(name = "Chambre API", description = "Gestion des chambres (CRUD + recherches)")
public class ChambreController {

    private final IChambreService chambreService;

    @Operation(summary = "Ajouter une chambre",
            description = "Ajoute une nouvelle chambre dans la base de données.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Chambre ajoutée avec succès"),
            @ApiResponse(responseCode = "400", description = "Données invalides")
    })
    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }


    @Operation(summary = "Mettre à jour une chambre",
            description = "Modifie les informations d’une chambre existante.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Chambre mise à jour"),
            @ApiResponse(responseCode = "404", description = "Chambre non trouvée")
    })
    @PutMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }


    @Operation(summary = "Supprimer une chambre",
            description = "Supprime une chambre à partir de son identifiant.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Chambre supprimée"),
            @ApiResponse(responseCode = "404", description = "Chambre non trouvée")
    })
    @DeleteMapping("/delete/{id}")
    public void deleteChambre(
            @Parameter(description = "ID de la chambre à supprimer")
            @PathVariable Long id) {
        chambreService.deleteByID(id);
    }


    @Operation(summary = "Trouver une chambre par ID",
            description = "Retourne une chambre selon son identifiant.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Chambre trouvée"),
            @ApiResponse(responseCode = "404", description = "Chambre non trouvée")
    })
    @GetMapping("/find/{id}")
    public Chambre findChambreById(
            @Parameter(description = "ID de la chambre recherchée")
            @PathVariable Long id) {
        return chambreService.findByID(id);
    }


    @Operation(summary = "Afficher toutes les chambres",
            description = "Retourne la liste des chambres disponibles.")
    @ApiResponse(responseCode = "200", description = "Liste des chambres")
    @GetMapping("/all")
    public List<Chambre> findAllChambres() {
        return chambreService.findAll();
    }


    @Operation(summary = "Recherche par nom du bloc (keywords)",
            description = "Trouve toutes les chambres appartenant à un bloc via query methods.")
    @ApiResponse(responseCode = "200", description = "Chambres trouvées")
    @GetMapping("/getchambrebyblocname/{nomBloc}")
    public List<Chambre> getAllChambreByNomBloc(
            @Parameter(description = "Nom du bloc")
            @PathVariable String nomBloc) {
        return chambreService.findChambrebynomBloc(nomBloc);
    }


    @Operation(summary = "Recherche par nom du bloc (JPQL)",
            description = "Trouve les chambres via une requête JPQL.")
    @ApiResponse(responseCode = "200", description = "Chambres trouvées (JPQL)")
    @GetMapping("/getchambrebyblocnamejpql/{nomBloc}")
    public List<Chambre> getAllChambreByNomBlocJPQL(
            @Parameter(description = "Nom du bloc")
            @PathVariable String nomBloc) {
        return chambreService.findByBlocChambreJPQL(nomBloc);
    }


    @Operation(summary = "Recherche par nom du bloc (Native SQL)",
            description = "Trouve les chambres via une requête Native SQL.")
    @ApiResponse(responseCode = "200", description = "Chambres trouvées (Native)")
    @GetMapping("/getchambrebyblocnameNative/{nomBloc}")
    public List<Chambre> findByBlocNameChambreNative(
            @Parameter(description = "Nom du bloc")
            @PathVariable String nomBloc) {
        return chambreService.findByBlocChambreNative(nomBloc);
    }
}
