package fr.formation.ecf.backend.ecf3cdabackend.locations;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * Récupère la liste des locations de la database sur la route /locations
     * @return liste des locations
     */
    @GetMapping("")
    public List<Location> findAll() {
        return locationService.findAll();
    }

    /**
     * Récupère un location par son ID sur la route /locations/id
     * @param id de la location en PathVariable
     * @return la location trouvée ( ou erreur envoyé par le service )
     */
    @GetMapping("{id}")
    public Location findById(@PathVariable String id) {
        return locationService.findById(id);
    }

    /**
     * Ajout d'une location sur la base de donnée, utilisant la requête de chemin /locations
     * @param location L'object location envoyé dans le body de la requête
     * @return la location sauvegardée
     */
    @PostMapping("")
    public Location save(@RequestBody Location location) {
        return locationService.save(location);
    }

    /**
     * Suppression d'une location de la base de donnée sur le chemin /locations/id
     * @param id valeur de l'id envoyé en PathVariable
     */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        locationService.deleteById(id);
    }
}
