package modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Dependente implements EntidadedeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDependente;
    @Column
    private String nome;
    @Column
    private int dataDeNascimento;
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    public Dependente() {
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Integer getId() {
        return idDependente;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(int dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dependente)) return false;
        Dependente that = (Dependente) o;
        return Objects.equals(idDependente, that.idDependente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDependente);
    }


}
