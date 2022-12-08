package fr.formation.ecf.backend.ecf3cdabackend.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {



    @Bean
    public ClientService setClientService(ClientRepository clientRepository) {


        return new ClientServiceImpl(clientRepository);
    }

}

