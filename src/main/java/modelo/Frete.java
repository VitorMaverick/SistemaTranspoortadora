package modelo;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Frete implements Parametro, EntidadedeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column
    private double valor;
    @Column(unique = true)
    private int numeroNotaFiscal;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "categoria_id",nullable = false)
    private CategoriaFrete categoria;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "cidadeDeOrigem_id",nullable = false)
    private Cidade cidadeDeOrigem;
    @ManyToOne
    @JoinColumn(name = "cidadeDeDestino_id",nullable = false)
    private Cidade cidadeDeDestino;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;
    @OneToMany(mappedBy = "frete", cascade = CascadeType.ALL)
    private List<ItemFrete> itemFrete;

    public Frete() {
    }

    public Integer getId() {
        return codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(int numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public CategoriaFrete getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFrete categoria) {
        this.categoria = categoria;
    }

    public Cidade getCidadeDeOrigem() {
        return cidadeDeOrigem;
    }

    public void setCidadeDeOrigem(Cidade cidadeDeOrigem) {
        this.cidadeDeOrigem = cidadeDeOrigem;
    }

    public Cidade getCidadeDeDestino() {
        return cidadeDeDestino;
    }

    public void setCidadeDeDestino(Cidade cidadeDeDestino) {
        this.cidadeDeDestino = cidadeDeDestino;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Frete)) return false;
        Frete frete = (Frete) o;
        return Objects.equals(codigo, frete.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
