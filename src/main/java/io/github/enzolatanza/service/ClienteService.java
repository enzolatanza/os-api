package io.github.enzolatanza.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.enzolatanza.domain.Pessoa;
import io.github.enzolatanza.domain.Cliente;
import io.github.enzolatanza.dtos.ClienteDTO;
import io.github.enzolatanza.exceptions.DataIntegrityViolationException;
import io.github.enzolatanza.exceptions.ObjectNotFoundException;
import io.github.enzolatanza.repositories.PessoaRepository;
import io.github.enzolatanza.repositories.ClienteRepository;
import jakarta.validation.Valid;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	 
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id); //optional pois pode retornar ou nao um objeto
		//passando uma exceção personalizada	return obj.orElse(null); //pode ou não encontrar senao retorna nulo
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Cliente create(ClienteDTO objDTO) {
		if(findByCPF(objDTO) != null){
			throw new DataIntegrityViolationException("CPF já cadastrado na base de dados!");
		}
		Cliente newObj = new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone());
		return repository.save(newObj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente oldObj = this.findById(id); 
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegrityViolationException("CPF já cadastrado na base de dados!");
		}
		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setTelefone(objDTO.getTelefone());
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		 Cliente obj = findById(id);
		 if(obj.getList().size() > 0) {
				throw new DataIntegrityViolationException("Pessoa possui Ordens de Serviço e não pode ser deletado!");
		 }
		 repository.deleteById(id);
	}
	
	private Pessoa findByCPF(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}

}
