package fr.formation.ecf.backend.ecf3cdabackend.locations;

import fr.formation.ecf.backend.ecf3cdabackend.vehicules.Vehicule;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.VehiculeRepository;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.VehiculeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @Override
    public Location save(Location location) {
        Vehicule vehicule = this.vehiculeService.findById(location.getVehicule().getId());
        this.changeDisponibiliteDuVehicule(location, vehicule);
        // check date and let create or not.
        if (this.verifieDateDeLocation(location, vehicule)) {
            return locationRepository.save(location);
        } else {
            logger.warn("La location n'est pas créer, conflits avec les dates");
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        logger.warn("La location d'id " + id + " à été supprimé");
        locationRepository.deleteById(id);
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
    private Boolean verifieDateDeLocation(Location location, Vehicule vehicule) {
        Boolean canCreate = true;
        List<Location> locationList = this.locationRepository.findLocationByVehiculeId(vehicule.getId());

        for (Location locationItem : locationList) {
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
        return canCreate;
    }

    /**
     * Change la disponibilité du véhicule si la date du jour et dans l'intervalle de la location à créer
     * @param location
     */
    private void changeDisponibiliteDuVehicule(Location location, Vehicule vehicule) {
        if (LocalDate.now().isAfter(location.getDateDebut()) || LocalDate.now().isBefore(location.getDateFin())) {
            vehicule.setDisponible(false);
        }

    }

}
