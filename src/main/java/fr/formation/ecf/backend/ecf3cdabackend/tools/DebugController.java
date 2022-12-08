package fr.formation.ecf.backend.ecf3cdabackend.tools;

import fr.formation.ecf.backend.ecf3cdabackend.clients.ClientRepository;
import fr.formation.ecf.backend.ecf3cdabackend.locations.LocationRepository;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.VehiculeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("debug")
// là ça permet d'avoir ce controller que si le profil est celui du dev
@Profile("dev")
public class DebugController {

    private final ClientRepository clientRepository;
    private final VehiculeRepository vehiculeRepository;
    private final LocationRepository locationRepository;

    public DebugController(ClientRepository clientRepository, VehiculeRepository vehiculeRepository, LocationRepository locationRepository) {
        this.clientRepository = clientRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.locationRepository = locationRepository;
    }

    @PostMapping("init")
    public void initDatabase() {
        this.clearAll();


    }

    @DeleteMapping("clear")
    public void clearAll() {
        this.clientRepository.deleteAll();
        this.vehiculeRepository.deleteAll();
        this.locationRepository.deleteAll();
    }
}
