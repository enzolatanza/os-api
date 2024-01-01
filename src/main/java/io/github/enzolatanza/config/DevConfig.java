package io.github.enzolatanza.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import io.github.enzolatanza.service.DBService;
import jakarta.annotation.PostConstruct;

//Classe de configuração
@Configuration
@Profile("dev") //identificando o perfil de desenvolvimento
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;
	
    //@Bean -> nao deu certo por ser um metodo sem retorno
	@Bean
	public boolean instanciaDB() {
		if(ddl.equals("create")) {
			this.dbService.instanciaDB();
		}
		return false;
	}
}
