package br.com.geolocalization.application.config;

import br.com.geolocalization.application.domain.adapters.DistanceMatrixServiceImp;
import br.com.geolocalization.application.domain.ports.DistanceMatrixServicePort;
import br.com.geolocalization.application.external.distancematrix.interfaces.DistanceMatrixRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    DistanceMatrixServicePort distanceMatrixService(DistanceMatrixRepositoryPort repository) {
        return new DistanceMatrixServiceImp(repository);
    }
}
