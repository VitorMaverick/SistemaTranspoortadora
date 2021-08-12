package modelo;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cidade")
public class Cidade implements EntidadedeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nome;

    @OneToMany(mappedBy = "id.origem", cascade = CascadeType.ALL)
    private Set<Distancia> distancia = new LinkedHashSet<>();

    public Cidade() {
    }

    public Set<Distancia> getDistancia() {
        return distancia;
    }

    public void setDistancia(Set<Distancia> distancia) {
        this.distancia = distancia;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adiciona(Distancia d) {

        distancia.add(d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cidade)) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
