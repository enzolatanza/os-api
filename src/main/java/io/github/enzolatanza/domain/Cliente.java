package io.github.enzolatanza.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity //informa ao jpa que pessoa é uma entidade e deve ser criado uma tabela no banco de dados
public class Cliente extends Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "cliente") //relação um para muitos
    private List<OS> list = new ArrayList<>(); //ja deve ser inicializada para evitar nullPointerException
    public Cliente(){
        super();
    }
    public Cliente(Integer id, String nome, String cpf, String telefone){
        super(id, nome, cpf, telefone);
    }
    public List<OS> getList() {
        return list;
    }
    public void setList(List<OS> list) {
        this.list = list;
    }
}

