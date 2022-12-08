package fr.formation.ecf.backend.ecf3cdabackend.vehicules;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehiculeConfiguration {
    @Bean
    public VehiculeService setVehiculeService(VehiculeRepository vehiculeRepository) {
        return new VehiculeServiceImpl(vehiculeRepository);
    }
}
