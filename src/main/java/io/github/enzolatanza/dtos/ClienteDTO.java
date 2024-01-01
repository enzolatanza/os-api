package io.github.enzolatanza.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CPF;

import io.github.enzolatanza.domain.Cliente;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

public class ClienteDTO implements Serializable{
    private static final long serialVersionUID = 1L;
	/*
	 * Usando DTOs permite a omissão de dados que não desejamos que sejam tragos na busca
	 * exemplo se possuisse usuario e senha não seria legal que viesse junto com a busca
	 * 
	 * exemplo basta retirar o cpf desta classe que ao executar o get será oculto o cpf do cliente
	 * */
    private Integer id;
    @NotEmpty(message="O campo NOME é requerido")
    private String nome;
    @CPF //faz a validação do campo CPF
    @NotEmpty(message="O campo CPF é requerido")
    private String cpf;
    @NotEmpty(message="O campo TELEFONE é requerido")
    private String telefone;
    public ClienteDTO() {
    	super();
    }
	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.telefone = obj.getTelefone();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
    
}
