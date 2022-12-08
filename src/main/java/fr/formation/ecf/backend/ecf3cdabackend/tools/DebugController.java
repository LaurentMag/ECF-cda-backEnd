package fr.formation.ecf.backend.ecf3cdabackend.tools;

import fr.formation.ecf.backend.ecf3cdabackend.clients.Client;
import fr.formation.ecf.backend.ecf3cdabackend.clients.ClientRepository;
import fr.formation.ecf.backend.ecf3cdabackend.locations.LocationRepository;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.Vehicule;
import fr.formation.ecf.backend.ecf3cdabackend.vehicules.VehiculeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

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
        Client client1 = this.clientRepository.save(new Client("Robert", "Toutpres", LocalDate.of(1950, 9, 24), "robertToutpres@gmail.com", "0601010101"));
        Client client2 = this.clientRepository.save(new Client("Josephine", "Dorian", LocalDate.of(1990, 2, 24), "josephineDo@gmail.com", "0602020202"));
        Client client3 = this.clientRepository.save(new Client("Dylon", "Tehbot", LocalDate.of(1980, 10, 3), "dylonTeh@gmail.com", "0603030303"));
        Client client4 = this.clientRepository.save(new Client("Brittany", "Woodpile", LocalDate.of(1970, 2, 25), "brittWood@gmail.com", "0604040404"));
        Client client5 = this.clientRepository.save(new Client("Brenda", "TreeBurns", LocalDate.of(1950, 9, 24), "brendaTree@gmail.com", "0605050505"));

        Vehicule vehicule1 = this.vehiculeRepository.save(new Vehicule("Renault", "Sinic", "AA-001-AA", "A", 400, true, "voiture"));
        Vehicule vehicule2 = this.vehiculeRepository.save(new Vehicule("Peugeot", "666", "PE-101-GO", "B", 100, true, "voiture"));
        Vehicule vehicule3 = this.vehiculeRepository.save(new Vehicule("Aston Martin", "006", "OO-007-OO", "S", 8000, true, "voiture"));
        Vehicule vehicule4 = this.vehiculeRepository.save(new Vehicule("Fraudari", "Wallet-GT", "XX-041-ZZ", "F", 10150, true, "voiture"));
        Vehicule vehicule5 = this.vehiculeRepository.save(new Vehicule("Lada", "Ruined", "RU-901-UR", "E", 20, true, "voiture"));

    }

    @DeleteMapping("clear")
    public void clearAll() {
        this.clientRepository.deleteAll();
        this.vehiculeRepository.deleteAll();
        this.locationRepository.deleteAll();
    }
}
