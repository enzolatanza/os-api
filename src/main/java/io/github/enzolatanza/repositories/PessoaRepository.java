package io.github.enzolatanza.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.enzolatanza.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	@Query("SELECT obj FROM Pessoa obj WHERE obj.cpf =:cpf")
	Pessoa findByCPF(@Param("cpf") String cpf);
}
