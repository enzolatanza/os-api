package io.github.enzolatanza.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.enzolatanza.domain.Pessoa;
import io.github.enzolatanza.domain.Tecnico;
import io.github.enzolatanza.dtos.TecnicoDTO;
import io.github.enzolatanza.exceptions.DataIntegrityViolationException;
import io.github.enzolatanza.exceptions.ObjectNotFoundException;
import io.github.enzolatanza.repositories.PessoaRepository;
import io.github.enzolatanza.repositories.TecnicoRepository;
import jakarta.validation.Valid;

@Service
public class TecnicoService {
	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	 
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id); //optional pois pode retornar ou nao um objeto
		//passando uma exceção personalizada	return obj.orElse(null); //pode ou não encontrar senao retorna nulo
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: "+id+", Tipo: "+Tecnico.class.getName()));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		if(findByCPF(objDTO) != null){
			throw new DataIntegrityViolationException("CPF já cadastrado na base de dados!");
		}
		Tecnico newObj = new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone());
		return repository.save(newObj);
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldObj = this.findById(id); 
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegrityViolationException("CPF já cadastrado na base de dados!");
		}
		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setTelefone(objDTO.getTelefone());
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		 Tecnico obj = findById(id);
		 if(obj.getList().size() > 0) {
				throw new DataIntegrityViolationException("Técnico possui Ordens de Serviço e não pode ser deletado!");
		 }
		 repository.deleteById(id);
	}
	
	private Pessoa findByCPF(TecnicoDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}

}
