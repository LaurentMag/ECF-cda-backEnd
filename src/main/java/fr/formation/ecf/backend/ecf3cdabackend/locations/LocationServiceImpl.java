package fr.formation.ecf.backend.ecf3cdabackend.locations;

import fr.formation.ecf.backend.ecf3cdabackend.vehicules.Vehicule;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.VehiculeRepository;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.VehiculeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
        location.setPrixTotal(this.calculeDuPrixDeLocation(location));
        return locationRepository.save(location);
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
     * En passant en argument la location qui sera sauvé en base de donnée
     *
     * @param location
     */
    private Double calculeDuPrixDeLocation(Location location) {


        Vehicule vehicule = vehiculeService.findById(location.getVehicule().getId());

        Integer prixJournee = vehicule.getPrixJournee();
        Long differenceJour = ChronoUnit.DAYS.between(location.getDateDebut(), location.getDateFin());

        return Double.valueOf(prixJournee * differenceJour);




    }
}
