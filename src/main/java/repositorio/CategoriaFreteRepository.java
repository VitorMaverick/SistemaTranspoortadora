package repositorio;

import modelo.CategoriaFrete;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaFreteRepository {
    private final EntityManager manager;
    private DAOGenerico<CategoriaFrete> daoGenerico;


    public CategoriaFreteRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<CategoriaFrete>(manager);
    }

    public CategoriaFrete BuscaPor(Integer id){
        return daoGenerico.buscaPorId(CategoriaFrete.class, id);
    }

    public List<CategoriaFrete> BuscaPor(String nome){
        return this.manager.createQuery("from categoriafrete" + "where upper(nome) like :nome", CategoriaFrete.class)
                .setParameter("nome", nome.toUpperCase() + "%").getResultList();
    }

    public CategoriaFrete salvaOuAtualiza(CategoriaFrete categoria){
        return daoGenerico.salvaOuAtualiza(categoria);
    }

    public void remove (CategoriaFrete categoria){
        daoGenerico.remove(categoria);
    }
}
