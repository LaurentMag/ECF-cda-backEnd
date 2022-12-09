package fr.formation.ecf.backend.ecf3cdabackend.locations;


import com.fasterxml.jackson.annotation.JsonFormat;
import fr.formation.ecf.backend.ecf3cdabackend.clients.Client;
import fr.formation.ecf.backend.ecf3cdabackend.tools.EntityInfo;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Location extends EntityInfo {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFin;
    //private Double prixTotal;

    @DBRef
    Client client;

    @DBRef
    Vehicule vehicule;

    public Double getPrixTotal() {
        Double prix = ChronoUnit.DAYS.between(this.getDateDebut(), this.getDateFin()) * getVehicule().getPrixJournee();
        System.out.println(this.getVehicule());
        return prix;
    }
}
