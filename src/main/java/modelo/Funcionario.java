package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="funcionario")
public class Funcionario extends PessoaFisica implements EntidadedeBase {
    @Column(unique = true)
    private Integer matricula;
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private Set<Dependente> dependente = new LinkedHashSet<>();

    public Funcionario() {
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Set<Dependente> getDependente() {
        return dependente;
    }

    public void setDependente(Set<Dependente> dependente) {
        this.dependente = dependente;
    }

    public void adiciona(Dependente d) {

        dependente.add(d);
    }

}
