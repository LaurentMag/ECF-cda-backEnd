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
    @GetMapping("")
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("{id}")
    public Client findById(@PathVariable String id) {
        return clientService.findById(id);
    }

    //========================================================================
    // POST
    @PostMapping("")
    public Client save(@RequestBody Client client) {
        System.out.println(client);
        return clientService.save(client);
    }

    //========================================================================
    //DELETE
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable String id) {
        clientService.deleteById(id);
    }
}
