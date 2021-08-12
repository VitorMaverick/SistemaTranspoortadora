package modelo;

import javax.persistence.*;

@Entity
public class CategoriaFrete implements EntidadedeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoriaFrete;
    @Column
    private double desconto;
    @Column
    private double percentual;

    public CategoriaFrete() {
    }

    public Integer getId() {
        return idCategoriaFrete;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getPercentual() {
        return percentual;
    }

    public void setPercentual(double percentual) {
        this.percentual = percentual;
    }
}
