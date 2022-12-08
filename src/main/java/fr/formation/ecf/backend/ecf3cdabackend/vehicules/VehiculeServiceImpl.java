package fr.formation.ecf.backend.ecf3cdabackend.vehicules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class VehiculeServiceImpl implements VehiculeService {
    private static Logger logger = LoggerFactory.getLogger(VehiculeServiceImpl.class);

    private final VehiculeRepository vehiculeRepository;

    public VehiculeServiceImpl(VehiculeRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    //========================================================================
    //GET
    @Override
    public List<Vehicule> findAll() {
        return vehiculeRepository.findAll();
    }


    @Override
    public Vehicule findById(String id) {
        return vehiculeRepository.findById(id).orElseThrow(() -> {
            logger.warn("La rechercher de vehicule d'id " + id + " est incorrect");
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    //========================================================================
    // POST
    @Override
    public Vehicule save(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }


    @Override
    public Vehicule update(String id, Vehicule vehicule) {

        if (!this.vehiculeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le vehicule d'id " + id + " n'existe pas dans la base de donnée");
        }
        return this.save(vehicule);
    }


    //========================================================================
    //DELETE
    @Override
    public void deleteById(String id) {
        logger.warn("le vehicule d'id " + id + " a été supprimé");
        vehiculeRepository.deleteById(id);
    }
}
