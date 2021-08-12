package modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Distancia  {
    @Id
    private DistanciaPK id = new DistanciaPK();

    @Column
    private double quilometros;

    public Distancia() {
    }


    public void setId(DistanciaPK id) {
        this.id = id;
    }

    public DistanciaPK getId() {
        return id;
    }

    public double getQuilometros() {
        return quilometros;
    }

    public void setQuilometros(double quilometros) {
        this.quilometros = quilometros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distancia)) return false;
        Distancia distancia = (Distancia) o;
        return Objects.equals(id, distancia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
