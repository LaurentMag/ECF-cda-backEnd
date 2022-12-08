package fr.formation.ecf.backend.ecf3cdabackend.locations;

import fr.formation.ecf.backend.ecf3cdabackend.vehicules.Vehicule;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LocationRepository extends MongoRepository<Location, String> {

}
