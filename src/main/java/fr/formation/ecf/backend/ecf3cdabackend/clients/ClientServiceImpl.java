package fr.formation.ecf.backend.ecf3cdabackend.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private static Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //========================================================================
    //GET
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public List<Client> findAllByNom(String nom) {
        return clientRepository.findAllByNom(nom);
    }

    public List<Client> findAllByPrenom(String prenom) {
        return clientRepository.findAllByPrenom(prenom);
    }

    @Override
    public Client findById(String id) {
        return clientRepository.findById(id).orElseThrow(() -> {
            logger.warn("La recherche avec l'id " + id + " est incorrect, le client n'existe pas");
            return new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
    }

    //========================================================================
    // POST
    @Override
    public Client save(Client client) {
        client.setDateDeModification(LocalDateTime.now());
        return clientRepository.save(client);
    }

    @Override
    public Client update(String id, Client client) {

        if (!this.clientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le client d'id " + id + " n'existe pas dans la base de donnée");
        }
        return this.save(client);
    }

    //========================================================================
    //DELETE
    @Override
    public void deleteById(String id) {
        logger.warn("Le client d'id " + id + " a été supprimé");
        clientRepository.deleteById(id);
    }


}
