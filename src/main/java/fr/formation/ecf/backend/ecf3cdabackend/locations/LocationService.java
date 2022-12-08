package fr.formation.ecf.backend.ecf3cdabackend.locations;

import java.util.List;

public interface LocationService {
    /**
     * Récupère la liste de toutes les locations présentes sur la base de donnée
     * @return Liste de locations
     */
    List<Location> findAll();

    /**
     * Rechercher une location par son ID
     * @param id de la location recherchée
     * @return location recherchée par son ID ( si trouvé, sinon retourne un message d'erreur )
     */
    Location findById(String id);

    /**
     * Ajoute un client à la base de donnée
     * @param location passé dans le body de la request
     * @return client sauvegardé
     */
    Location save(Location location);


    /**
     * Supprime une location séléctionnéz par son ID de la base de donnée
     * @param id de la location à supprimer.
     */
    void deleteById(String id);
}
