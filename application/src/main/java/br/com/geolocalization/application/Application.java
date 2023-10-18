package br.com.geolocalization.application;

import br.com.geolocalization.application.domain.adapters.TokenFileServiceImp;
import br.com.geolocalization.application.domain.ports.TokenFileServicePort;
import br.com.geolocalization.application.infra.interfaces.TokenFileRepositoryPort;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	@Bean
	public TokenFileServicePort tokenFileServicePort(TokenFileRepositoryPort repository) {
		TokenFileServicePort service = new TokenFileServiceImp(repository);

		service.getToken();

		return service;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
