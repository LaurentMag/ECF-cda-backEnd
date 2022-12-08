package fr.formation.ecf.backend.ecf3cdabackend.clients;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, String> {

    /**
     * recherche tout les clients ayant le nom selectionné
     *
     * @param nom du client
     * @return la liste des clients ayant un nom choisi
     */
    List<Client> findAllByNom(String nom);

    /**
     * Recherche tout les clients ayant le prenom selectionné
     *
     * @param prenom du client
     * @return la liste des clients ayant un prenom choisi
     */
    List<Client> findAllByPrenom(String prenom);

}
