package repositorio;


import modelo.EntidadedeBase;

import javax.persistence.EntityManager;
import java.util.Objects;

public class DAOGenerico<T extends EntidadedeBase> {
    private final EntityManager manager;


    public DAOGenerico(EntityManager manager) {
        this.manager = manager;
    }
    T buscaPorId(Class<T> clazz, Integer id) {
        return manager.find(clazz, id);
    }
    T salvaOuAtualiza(T t) {
        if( Objects.isNull(t.getId()) )
            this.manager.persist(t);
        else
            t = this.manager.merge(t);
        return t;
    }
    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }
}
