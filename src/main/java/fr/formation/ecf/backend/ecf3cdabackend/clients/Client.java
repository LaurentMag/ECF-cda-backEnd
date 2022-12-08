package fr.formation.ecf.backend.ecf3cdabackend.clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Client {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String email;
    private String telephone;

}
