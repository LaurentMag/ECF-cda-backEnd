package fr.formation.ecf.backend.ecf3cdabackend.clients;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}