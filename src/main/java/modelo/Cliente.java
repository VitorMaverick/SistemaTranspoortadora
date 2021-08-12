package modelo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente extends PessoaFisica implements EntidadedeBase {

    @OneToMany
    private List<Frete> frete;

    public Cliente() {
    }

    public List<Frete> getFrete() {
        return frete;
    }

    public void setFrete(List<Frete> frete) {
        this.frete = frete;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "frete=" + frete +
                '}';
    }
}
