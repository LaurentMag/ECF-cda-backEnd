package fr.formation.ecf.backend.ecf3cdabackend.tools;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class EntityInfo {

    @Id
    private String id;
    private LocalDateTime dateDeCreation = LocalDateTime.now();
    private LocalDateTime dateDeModification = LocalDateTime.now();

}
