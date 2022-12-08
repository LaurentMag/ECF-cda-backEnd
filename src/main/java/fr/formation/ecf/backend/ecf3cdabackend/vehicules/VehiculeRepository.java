package fr.formation.ecf.backend.ecf3cdabackend.vehicules;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VehiculeRepository extends MongoRepository<Vehicule, String> {


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



}
