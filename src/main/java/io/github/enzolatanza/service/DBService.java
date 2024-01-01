package io.github.enzolatanza.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.enzolatanza.domain.Cliente;
import io.github.enzolatanza.domain.OS;
import io.github.enzolatanza.domain.Tecnico;
import io.github.enzolatanza.domain.enums.Prioridade;
import io.github.enzolatanza.domain.enums.Status;
import io.github.enzolatanza.repositories.ClienteRepository;
import io.github.enzolatanza.repositories.OSRepository;
import io.github.enzolatanza.repositories.TecnicoRepository;

@Service
public class DBService {
	
	//Injetando um TecnicoRepository o springboot será responsavel por cirar/destruir/gerenciar
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		Tecnico t1 = new Tecnico(null, "Valdir Cesar", "144.785.300-84", "(34) 3235-9398");
		Cliente c1 = new Cliente(null, "Enzo Furlan", "016.362.126-89", "(34) 9 9997-3480" );
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, t1, c1);
		//adicionando a instancia da ordem de serviço no tecnico e cliente
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		//-------------
		Tecnico t2 = new Tecnico(null, "Julio", "262.584.930-41", "(34) 3235-9398");
		Cliente c2 = new Cliente(null, "Nicole Furlan", "248.380.080-74", "(34) 9 9997-3480" );
		OS os2 = new OS(null, Prioridade.BAIXA, "Teste create OS", Status.ANDAMENTO, t2, c2);
		//adicionando a instancia da ordem de serviço no tecnico e cliente
		t2.getList().add(os2);
		c2.getList().add(os2);
		
		tecnicoRepository.saveAll(Arrays.asList(t1,t2));//t1,t2,t3...
		clienteRepository.saveAll(Arrays.asList(c1,c2));//c1,c2,c3...
		osRepository.saveAll(Arrays.asList(os1,os2));//o1,o2,o3...
	}
}
