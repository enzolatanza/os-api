package io.github.enzolatanza.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //informa ao jpa que pessoa é uma entidade e deve ser criado uma tabela no banco de dados
public class Tecnico extends Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    @JsonIgnore //evita serialização devido possuir relação com outros 
    @OneToMany(mappedBy = "tecnico") //relação um para muitos
    private List<OS> list = new ArrayList<>(); //ja deve ser inicializada para evitar nullPointerException
    public Tecnico(){
        super();
    }
    public Tecnico(Integer id, String nome, String cpf, String telefone){
        super(id, nome, cpf, telefone);
    }
    public List<OS> getList() {
        return list;
    }
    public void setList(List<OS> list) {
        this.list = list;
    }
    
}
