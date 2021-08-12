package repositorio;

import modelo.Cidade;

import java.math.BigDecimal;

public class FreteFiltro {

    private Integer cliente_nome;
    private BigDecimal MinValor;
    private BigDecimal MaxValor;
    private Integer cidadeDeOrigem_id;
    private Integer cidadeDeDestino_id;

    public Integer getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_Nome(Integer cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public BigDecimal getMinValor() {
        return MinValor;
    }

    public void setMinValor(BigDecimal minValor) {
        MinValor = minValor;
    }

    public BigDecimal getMaxValor() {
        return MaxValor;
    }

    public void setMaxValor(BigDecimal maxValor) {
        MaxValor = maxValor;
    }

    public Integer getCidadeDeOrigem_id() {
        return cidadeDeOrigem_id;
    }

    public void setCidadeDeOrigem_id(Integer cidadeDeOrigem_id) {
        this.cidadeDeOrigem_id = cidadeDeOrigem_id;
    }

    public Integer getCidadeDeDestino_id() {
        return cidadeDeDestino_id;
    }

    public void setCidadeDeDestino_id(Integer cidadeDeDestino_id) {
        this.cidadeDeDestino_id = cidadeDeDestino_id;
    }
}
