package modelo;

import javax.persistence.*;

@Entity
public class Veiculo implements EntidadedeBase{
    @Id
    private Integer IdVeiculo;
    @Column(unique = true)
    private String numeroPlaca;
    @ManyToOne
    @JoinColumn(name="tipoVeiculo_id", nullable = false)
    private TipoVeiculo tipo;
    @ManyToOne
    @JoinColumn(name="filial_id", nullable = false)
    private Filial filial;

    public Veiculo() {
    }

    public Integer getId() {
        return IdVeiculo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }
}
