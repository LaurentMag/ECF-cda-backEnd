package fr.formation.ecf.backend.ecf3cdabackend.locations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class LocationServiceImpl implements LocationService {
    private static Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
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
        Long differenceJour;
        Integer prixLocation = 0;
        Period period = Period.between(location.getDateDebut(), location.getDateFin());

        differenceJour = ChronoUnit.DAYS.between(location.getDateDebut(), location.getDateFin());

        System.out.println(period);
        System.out.println(period.getMonths());
        System.out.println(differenceJour);



        return locationRepository.save(location);
    }


    //========================================================================
    //DELETE
    @Override
    public void deleteById(String id) {
        logger.warn("La location d'id " + id + " à été supprimé");
        locationRepository.deleteById(id);
    }
}
