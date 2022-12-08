package fr.formation.ecf.backend.ecf3cdabackend.locations;


import fr.formation.ecf.backend.ecf3cdabackend.clients.Client;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Location {
    @Id
    private String id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Double prixTotal;
    @DBRef
    Client client;
    @DBRef
    Vehicule vehicule;

}
