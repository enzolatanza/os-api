package io.github.enzolatanza.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import io.github.enzolatanza.service.DBService;
import jakarta.annotation.PostConstruct;

//Classe de configuração
@Configuration
@Profile("test") //identificando o perfil de teste
public class TestConfig {

	@Autowired
	private DBService dbService;
	
    //@Bean -> nao deu certo por ser um metodo sem retorno
	@PostConstruct
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}
}
