package io.github.enzolatanza.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.enzolatanza.domain.enums.Status;
import io.github.enzolatanza.domain.enums.Prioridade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity //informa ao jpa que pessoa é uma entidade e deve ser criado uma tabela no banco de dados
public class OS implements Serializable {
    //serializable indica que deve ser criado uma sequencia de bytes da instancia da classe para trafegar em rede
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAbertura;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFechamento;
    private Integer prioridade; //Integer para armezenar o codigo e não o objeto
    private String observacoes;
    private Integer status;//Integer para armezenar o codigo e não o objeto
    //Relação muitos para um
    @ManyToOne
    @JoinColumn(name="tecnico_id")//informa para criar uma coluna no banco
    private Tecnico tecnico;
    //Relação muitos para um
    @ManyToOne
    @JoinColumn(name="cliente_id")//informa para criar uma coluna no banco
    private Cliente cliente;
    
    public OS(){
        super();
        //evita uma data de abertura nula
        this.setDataAbertura(LocalDateTime.now()); //seta a data de abertura no momento automatico
        this.setPrioridade(Prioridade.BAIXA);
        this.setStatus(Status.ABERTO);
    }

    public OS(Integer id, Prioridade prioridade,
            String observacoes, Status status, Tecnico tecnico, 
            Cliente cliente) {
        super();
        this.id = id;
        this.setDataAbertura(LocalDateTime.now()); //seta a data de abertura no momento automatico
        this.prioridade = (prioridade == null) ? 0 : prioridade.getCod();
        this.observacoes = observacoes;
        this.status = (status == null) ? 0 : status.getCod();
        this.tecnico = tecnico;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Prioridade getPrioridade() {
        return Prioridade.toEnum(this.prioridade);
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade.getCod();
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Status getStatus() {
        return Status.toEnum(this.status);
    }

    public void setStatus(Status status) {
        this.status = status.getCod();
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //para esse objeto será usado comparação apenas pelo id

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OS other = (OS) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    

    
}
