package fr.formation.ecf.backend.ecf3cdabackend.clients;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //========================================================================
    //GET

    /**
     * Récupère la liste des clients de la database sur la route /clients
     *
     * @return liste des clients
     */

    @GetMapping("")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    /**
     * Récupère un client par son ID sur la route /clients/id
     *
     * @param id du client en PathVariable
     * @return le client trouvé ( ou erreur envoyé par le service )
     */
    @GetMapping("{id}")
    public Client findById(@PathVariable String id) {
        return clientService.findById(id);
    }


    /**
     * Route de recherche en utilisant des filtres de recherches
     * @param nom
     * @param prenom
     * @return Liste des Clients issue de la recherche
     */
    @GetMapping("recherches")
    public List<Client> findAllBy(
            @RequestParam(required = false) String nom,
            @RequestParam(required = false) String prenom
    ) {
        if (nom != null) {
            return this.clientService.findAllByNom(nom);
        } else if (prenom != null) {
            return this.clientService.findAllByPrenom(prenom);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //========================================================================
    // POST

    /**
     * Ajout d'un client sur la base de donnée, utilisant la requête de chemin /clients
     *
     * @param client L'object client envoyé dans le body de la requête
     * @return le client sauvegardé
     */
    @PostMapping("")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    /**
     * Recois l'id d'un client et les informations dans le body de la requête pour mettre à jour l'objet
     * dans la base de donnée
     *
     * @param id     du client
     * @param client informations du client
     * @return les informations du client mise à jour
     */
    @PatchMapping("{id}")
    public Client update(@PathVariable String id, @RequestBody Client client) {
        if (!id.equals(client.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ce client n'existe pas");
        }
        return clientService.update(id, client);
    }

    //========================================================================
    //DELETE

    /**
     * Suppression d'un client de la base de donnée sur le chemin /clients/id
     *
     * @param id valeur de l'id envoyé en PathVariable
     */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        clientService.deleteById(id);
    }
}
