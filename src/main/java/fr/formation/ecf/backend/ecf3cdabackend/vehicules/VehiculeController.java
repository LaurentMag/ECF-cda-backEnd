package fr.formation.ecf.backend.ecf3cdabackend.vehicules;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("vehicules")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    //========================================================================
    //GET

    /**
     * Récupère la liste des vehicules de la database sur la route /vehicules
     *
     * @return liste des vehicule
     */
    @GetMapping("")
    public List<Vehicule> findAll() {
        return vehiculeService.findAll();
    }

    /**
     * Récupère un vehicule par son ID sur la route /vehicules/id
     *
     * @param id du vehicule en PathVariable
     * @return le vehicule trouvé ( ou erreur envoyé par le service )
     */
    @GetMapping("{id}")
    public Vehicule findById(@PathVariable String id) {
        return vehiculeService.findById(id);
    }


    /**
     * Route de recherche en utilisant des filtres de recherches
     * @param marque
     * @param modele
     * @param etat
     * @param disponible
     * @return retourne la liste des véhicules issue de la recherche
     */
    @GetMapping("recherches")
    public List<Vehicule> findBy(
            @RequestParam(required = false) String marque,
            @RequestParam(required = false) String modele,
            @RequestParam(required = false) String etat,
            @RequestParam(required = false) Boolean disponible
    ) {
        if (marque != null) {
            return this.vehiculeService.findAllByMarque(marque);
        } else if (modele != null) {
            return this.vehiculeService.findAllByModele(modele);
        } else if (etat != null) {
            return this.vehiculeService.findAllByEtat(etat);
        } else if (disponible != null) {
            return this.vehiculeService.findAllByDisponible(disponible);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //========================================================================
    // POST

    /**
     * Ajout d'un vehicule sur la base de donnée, utilisant la requête de chemin /vehicules
     *
     * @param vehicule L'object vehicule envoyé dans le body de la requête
     * @return le vehicule sauvegardé
     */
    @PostMapping
    public Vehicule save(@RequestBody Vehicule vehicule) {
        return vehiculeService.save(vehicule);
    }

    //========================================================================
    //DELETE

    /**
     * Suppression d'un vehicule de la base de donnée sur le chemin /vehicules/id
     *
     * @param id valeur de l'id envoyé en PathVariable
     */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        vehiculeService.deleteById(id);
    }
}
