package fr.formation.ecf.backend.ecf3cdabackend.locations;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}
