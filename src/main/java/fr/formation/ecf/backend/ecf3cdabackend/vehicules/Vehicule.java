package fr.formation.ecf.backend.ecf3cdabackend.vehicules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Vehicule {
    @Id
    private String id;
    private String marque;
    private String modele;
    private String immatriculation;
    private String etat;
    private Double prixJournee;
    private Boolean disponible;
    private String type;


}
