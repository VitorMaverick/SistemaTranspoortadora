package repositorio;

import modelo.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class CidadeRepository {
    private final EntityManager manager;
    private DAOGenerico<Cidade> daoGenerico;


    public CidadeRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Cidade>(manager);
    }

    public Cidade BuscaPor(Integer id){
        return daoGenerico.buscaPorId(Cidade.class, id);
    }

    public List<Cidade> BuscaPor(String nome){
        return this.manager.createQuery("from cidade" + "where upper(nome) like :nome", Cidade.class)
                .setParameter("nome", nome.toUpperCase() + "%").getResultList();
    }

    public List<Cidade> comDistancia(Cidade cidade) {
        return manager
                .createQuery("Select c From Cidade c join c.distancia d where origem_id(d) = :cidade.id",
                        Cidade.class)
                .getResultList();
    }

    public Cidade buscaPorSku(String sku) {
        try {
            Cidade cidade = manager.createQuery("from Cidade where upper(sku) = :sku",
                    Cidade.class)
                    .setParameter("sku", sku.toUpperCase())
                    .getSingleResult();
            return cidade;

        } catch (NoResultException e) {
            return null;
        }
    }
    public Cidade salvaOuAtualiza(Cidade cidade){
        return daoGenerico.salvaOuAtualiza(cidade);
    }

    public void remove (Cidade cidade){
        daoGenerico.remove(cidade);
    }
}
