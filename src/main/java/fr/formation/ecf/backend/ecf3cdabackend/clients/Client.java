package fr.formation.ecf.backend.ecf3cdabackend.clients;

import com.fasterxml.jackson.annotation.JsonFormat;
import fr.formation.ecf.backend.ecf3cdabackend.tools.EntityInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Client extends EntityInfo {

    private String nom;
    private String prenom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDeNaissance;
    private String email;
    private String telephone;

}
