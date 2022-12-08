package fr.formation.ecf.backend.ecf3cdabackend.clients;

import org.springframework.web.bind.annotation.*;

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
     * @return liste des clients
     */

    @GetMapping("")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    /**
     * Récupère un client par son ID sur la route /clients/id
     * @param id du client en PathVariable
     * @return le client trouvé ( ou erreur envoyé par le service )
     */
    @GetMapping("{id}")
    public Client findById(@PathVariable String id) {
        return clientService.findById(id);
    }

    //========================================================================
    // POST
    /**
     * Ajout d'un client sur la base de donnée, utilisant la request de chemin /clients
     * @param client L'object client envoyé dans le body de la request
     * @return le client sauvegardé
     */
    @PostMapping("")
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }

    //========================================================================
    //DELETE
    /**
     * Suppression d'un client de la base de donnée sur le chemin /clients/id
     * @param id valeur de l'id envoyé en PathVariable
     */
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        clientService.deleteById(id);
    }
}
