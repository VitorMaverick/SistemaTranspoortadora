package repositorio;

import modelo.Filial;

import javax.persistence.EntityManager;
import java.util.List;

public class FilialRepository {
    private final EntityManager manager;
    private DAOGenerico<Filial> daoGenerico;
    public FilialRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Filial>(manager);
    }

    public Filial buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Filial.class, id);
    }

    public List<Filial> buscaPor(String nome) {
        return this.manager.createQuery("from Cliente " +
                "where upper(nome) like :nome", Filial.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Filial salvaOuAtualiza(Filial filial) {
        return daoGenerico.salvaOuAtualiza(filial);
    }

    public void remove(Filial filial) {
        daoGenerico.remove(filial );
    }

}
