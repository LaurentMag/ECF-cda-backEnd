package fr.formation.ecf.backend.ecf3cdabackend.vehicules;

import fr.formation.ecf.backend.ecf3cdabackend.clients.Client;

import java.util.List;

public interface VehiculeService {
    /**
     * Récupère la liste de tout les vehicules présent sur la base de donnée
     *
     * @return Liste de vehicules
     */
    List<Vehicule> findAll();

    /**
     * Rechercher un vehicule par son ID
     *
     * @param id du vehicule recherché
     * @return vehicule recherché par son ID ( si trouvé, sinon retourne un message d'erreur )
     */
    Vehicule findById(String id);

    /**
     * Recherche les véhiules en fonction de leur disponibilité
     * @param isDispo boolean
     * @return la liste des véhicules disponible ou non selon le choix
     */
    List<Vehicule> findAllByDisponible(Boolean isDispo);

    /**
     * Rechercher les véhicules en fonction de leur marque
     * @param marque selectionné
     * @return La liste des véhicules de la marque choisi
     */
    List<Vehicule> findAllByMarque(String marque);

    /**
     * recherche les véhicules en fonction de leur modele
     * @param modele
     * @return La liste des véhicules du modele choisi
     */
    List<Vehicule> findAllByModele(String modele);

    /**
     * recherche les véhicules en fonction de leur état
     * @param etat
     * @return La liste des véhicules dans l'état choisi
     */
    List<Vehicule> findAllByEtat(String etat);


    /**
     * Ajoute un vehicule à la base de donnée
     *
     * @param vehicule passé dans le body de la request
     * @return vehicule sauvegardé
     */
    Vehicule save(Vehicule vehicule);

    /**
     * met un jour un vehicule selectionné par son ID
     * et par les informations envoyé dans le body de la request
     */
    Vehicule update(String id, Vehicule vehicule);

    /**
     * Supprime un vehicule séléctionné par son ID de la base de donnée
     *
     * @param id du vehicule à supprimer.
     */
    void deleteById(String id);
}
