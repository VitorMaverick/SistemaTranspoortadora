package modelo;

import javax.persistence.*;

@Entity
public class ItemFrete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;
    @Column
    private String descricao;
    @Column
    private double peso;
    @ManyToOne
    @JoinColumn(name = "frete_id", nullable = false)
    private Frete frete;

    public ItemFrete() {
    }

    public int getIdItem() {
        return idItem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }
}
