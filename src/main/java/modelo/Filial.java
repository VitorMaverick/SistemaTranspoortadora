package modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Filial implements EntidadedeBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFilial;
    @Column
    private String nome;
    @Column
    private String telefone;
    @Column
    private String endereco;
    @OneToMany
    private List<Funcionario> funcionario;
    @OneToMany(mappedBy = "filial", cascade = CascadeType.ALL)
    private List<Veiculo> veiculo;

    public Filial() {
    }

    public Integer getId() {
        return idFilial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(List<Funcionario> funcionario) {
        this.funcionario = funcionario;
    }

    public List<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(List<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
}
