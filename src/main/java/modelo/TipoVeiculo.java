package modelo;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class TipoVeiculo implements EntidadedeBase {
    @Id
    private Integer idTipoVeiculo;
    private String descricao;
    private double pesoMax;

    public TipoVeiculo() {
    }

    public Integer getId() {
        return idTipoVeiculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(double pesoMax) {
        this.pesoMax = pesoMax;
    }
}
