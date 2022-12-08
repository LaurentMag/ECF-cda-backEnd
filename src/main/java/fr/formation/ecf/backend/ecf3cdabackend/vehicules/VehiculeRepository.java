package fr.formation.ecf.backend.ecf3cdabackend.vehicules;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehiculeRepository extends MongoRepository<Vehicule, String> {
}
