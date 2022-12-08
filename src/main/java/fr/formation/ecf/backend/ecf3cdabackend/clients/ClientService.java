package fr.formation.ecf.backend.ecf3cdabackend.clients;

import java.util.List;

public interface ClientService {
    /**
     * Récupère la liste de tout les clients présent sur la base de donnée
     *
     * @return Liste de clients
     */
    List<Client> findAll();

    /**
     * Rechercher un client par son ID
     *
     * @param id du client recherché
     * @return client recherché par son ID ( si trouvé, sinon retourne un message d'erreur )
     */
    Client findById(String id);

    /**
     * Ajoute un client à la base de donnée
     *
     * @param client passé dans le body de la request
     * @return client sauvegardé
     */
    Client save(Client client);


    /**
     * met un jour un client selectionné par son ID
     * et par les informations envoyé dans le body de la request
     */
    Client update(String id, Client client);

    /**
     * Supprime un client séléctionné par son ID de la base de donnée
     *
     * @param id du client à supprimer.
     */
    void deleteById(String id);


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
