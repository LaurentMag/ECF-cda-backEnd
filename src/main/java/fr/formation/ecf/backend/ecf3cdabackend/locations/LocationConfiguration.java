package fr.formation.ecf.backend.ecf3cdabackend.locations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocationConfiguration {

    @Bean
    public LocationService setLocationService(LocationRepository locationRepository) {
        return new LocationServiceImpl(locationRepository);
    }
}
