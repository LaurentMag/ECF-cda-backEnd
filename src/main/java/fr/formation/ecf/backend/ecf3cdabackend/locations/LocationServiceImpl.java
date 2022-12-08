package fr.formation.ecf.backend.ecf3cdabackend.locations;

import fr.formation.ecf.backend.ecf3cdabackend.vehicules.Vehicule;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.VehiculeRepository;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.VehiculeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class LocationServiceImpl implements LocationService {
    private static Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
    private final LocationRepository locationRepository;
    private final VehiculeService vehiculeService;

    public LocationServiceImpl(LocationRepository locationRepository, VehiculeService vehiculeService) {
        this.locationRepository = locationRepository;
        this.vehiculeService = vehiculeService;
    }


    //========================================================================
    //GET
    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(String id) {
        return locationRepository.findById(id).orElseThrow(() -> {
            logger.warn("La rechercher de location d'id " + id + "est incorrect");
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    //========================================================================
    // POST
    @Override
    public Location save(Location location) {
        // set price
        location.setPrixTotal(this.calculeDuPrixDeLocation(location));
        this.changeDisponibiliteDuVehicule(location);
        // check date and let create or not.
        if (this.verifieDateDeLocation(location)) {
            return locationRepository.save(location);
        } else {
            logger.warn("La location n'est pas créer, conflits avec les dates");
        }
        return null;
    }

    //========================================================================
    //DELETE
    @Override
    public void deleteById(String id) {
        logger.warn("La location d'id " + id + " à été supprimé");
        locationRepository.deleteById(id);
    }

    //========================================================================
    //========================================================================

    /**
     * Calcule le prix de location totale pour la période de location selectionnée
     * En passant en argument la location qui sera sauvé en base de donnée.
     *
     * @param location
     */
    private Double calculeDuPrixDeLocation(Location location) {
        Vehicule vehiculeLoue = vehiculeService.findById(location.getVehicule().getId());
        Integer prixJournee = vehiculeLoue.getPrixJournee();
        Long differenceJour = ChronoUnit.DAYS.between(location.getDateDebut(), location.getDateFin());
        return Double.valueOf(prixJournee * differenceJour);
    }

    /**
     * A la création d'une location vérifie :
     * Si la date de début de la location à créer est avant la fin de la location du même vehicule
     * Si la cate de fin de la location à créer est après le début de la location du même véhicule
     * Si le vehicule que le client tente de louer est indisponible
     *
     * @param location nouvellement crée.
     * @return Boolean permettant de déterminer s'il y a un conflit de date ou non, et permettant la création.
     */
    private Boolean verifieDateDeLocation(Location location) {
        Boolean canCreate = true;

        String VehiculeID = location.getVehicule().getId();
        Vehicule vehicule = this.vehiculeService.findById(VehiculeID);

        List<Location> locationsList = this.findAll();

        for (Location locationItem : locationsList) {
            if (locationItem.getVehicule().getId().equals(VehiculeID)) {
                if (vehicule.getDisponible() == false ||
                        location.getDateDebut().isBefore(locationItem.getDateFin()) ||
                        location.getDateFin().isAfter(locationItem.getDateDebut())) {
                    canCreate = false;
                    throw new ResponseStatusException(
                            HttpStatus.NOT_ACCEPTABLE,
                            "Le véhicule est indisponible il n'est pas possible de le louer"
                    );
                }
            }
        }
        return canCreate;
    }

    /** Change la disponibilité du véhicule si la date du jour et dans l'intervalle de la location à créer
     * @param location
     */
    private void changeDisponibiliteDuVehicule(Location location) {
        Vehicule vehicule = this.vehiculeService.findById(location.getVehicule().getId());

        if (LocalDate.now().isAfter(location.getDateDebut()) || LocalDate.now().isBefore(location.getDateFin())) {
            vehicule.setDisponible(false);
        }

    }

}
