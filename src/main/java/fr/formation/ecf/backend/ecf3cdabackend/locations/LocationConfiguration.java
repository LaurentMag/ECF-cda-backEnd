package fr.formation.ecf.backend.ecf3cdabackend.locations;

import fr.formation.ecf.backend.ecf3cdabackend.vehicules.VehiculeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationConfiguration {
    @Bean
    public LocationService setLocationService(LocationRepository locationRepository, VehiculeService vehiculeService) {
        return new LocationServiceImpl(locationRepository, vehiculeService);
    }
}
