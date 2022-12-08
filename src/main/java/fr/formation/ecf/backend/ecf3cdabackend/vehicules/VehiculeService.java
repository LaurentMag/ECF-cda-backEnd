package fr.formation.ecf.backend.ecf3cdabackend.vehicules;

import java.util.List;

public interface VehiculeService {
    /**
     * Récupère la liste de tout les vehicules présent sur la base de donnée
     * @return Liste de vehicules
     */
    List<Vehicule> findAll();

    /**
     * Rechercher un vehicule par son ID
     * @param id du vehicule recherché
     * @return vehicule recherché par son ID ( si trouvé, sinon retourne un message d'erreur )
     */
    Vehicule findById(String id);

    /**
     * Ajoute un vehicule à la base de donnée
     * @param vehicule passé dans le body de la request
     * @return vehicule sauvegardé
     */
    Vehicule save(Vehicule vehicule);

    /**
     * Supprime un vehicule séléctionné par son ID de la base de donnée
     * @param id du vehicule à supprimer.
     */
    void deleteById(String id);
}
