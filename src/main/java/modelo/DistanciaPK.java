package modelo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DistanciaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "origem_id", nullable = false)
    private Cidade origem;
    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false)
    private Cidade destino;


    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DistanciaPK)) return false;
        DistanciaPK that = (DistanciaPK) o;
        return Objects.equals(getOrigem(), that.getOrigem()) &&
                Objects.equals(getDestino(), that.getDestino());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigem(), getDestino());
    }
}
