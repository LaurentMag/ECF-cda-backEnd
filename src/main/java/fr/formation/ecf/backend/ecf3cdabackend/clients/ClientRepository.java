package fr.formation.ecf.backend.ecf3cdabackend.clients;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, String> {

    List<Client> findClientByNom(String nom);
}
