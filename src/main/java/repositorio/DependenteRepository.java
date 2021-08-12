package repositorio;

import modelo.Dependente;


import javax.persistence.EntityManager;
import java.util.List;

public class DependenteRepository {
    private final EntityManager manager;
    private DAOGenerico<Dependente> daoGenerico;


    public DependenteRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Dependente>(manager);
    }

    public Dependente BuscaPor(Integer id){
        return daoGenerico.buscaPorId(Dependente.class, id);
    }

    public List<Dependente> BuscaPor(String nome){
        return this.manager.createQuery("from dependente" + "where upper(nome) like :nome", Dependente.class)
                .setParameter("nome", nome.toUpperCase() + "%").getResultList();
    }

    public Dependente salvaOuAtualiza(Dependente dependente){
        return daoGenerico.salvaOuAtualiza(dependente);
    }

    public void remove (Dependente dependente){
        daoGenerico.remove(dependente);
    }
}
