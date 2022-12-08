package fr.formation.ecf.backend.ecf3cdabackend.vehicules;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("vehicules")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    /**
     * Récupère la liste des vehicules de la database sur la route /vehicules
     * @return liste des vehicule
     */
    @GetMapping("")
    public List<Vehicule> findAll() {
        return vehiculeService.findAll();
    }

    /**
     * Récupère un vehicule par son ID sur la route /vehicules/id
     * @param id du vehicule en PathVariable
     * @return le vehicule trouvé ( ou erreur envoyé par le service )
     */
    @GetMapping("{id}")
    public Vehicule findById(@PathVariable String id) {
        return vehiculeService.findById(id);
    }

    /**
     * Ajout d'un vehicule sur la base de donnée, utilisant la request de chemin /vehicules
     * @param vehicule L'object vehicule envoyé dans le body de la request
     * @return le vehicule sauvegardé
     */
    @PostMapping
    public Vehicule save(@RequestBody Vehicule vehicule) {
        return vehiculeService.save(vehicule);
    }

    /**
     * Suppression d'un vehicule de la base de donnée sur le chemin /vehicules/id
     * @param id valeur de l'id envoyé en PathVariable
     */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        vehiculeService.deleteById(id);
    }
}
