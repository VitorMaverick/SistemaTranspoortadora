package servico;

import modelo.Cidade;
import repositorio.CidadeRepository;

import javax.persistence.*;
import java.util.Objects;

public class CadastroCidadeService {
   /* private final CidadeRepository repositorio;
    private final EntityManager manager;

    public CadastroCidadeService( ) {
        this.manager = new EMFactory().getEntityManager();
        this.repositorio = new CidadeRepository(manager );
    }


    public Cidade salva(Cidade cidade) throws FreteException {

        try {
            manager.getTransaction().begin();

            Cidade cidadeExistente = repositorio.BuscaPor(cidade.getId());


            if (Objects.nonNull(cidadeExistente) && !Objects.equals(cidade, cidadeExistente)) {
                throw new FreteException("Já existe um produto com o SKU informado.");
            }
            Cidade cidadeSalvo = repositorio.salvaOuAtualiza(cidade);

            manager.getTransaction().commit();
            return cidadeSalvo;

        } catch	(Exception e) {
            throw new RuntimeException(e );
        }

    }

    */
}
