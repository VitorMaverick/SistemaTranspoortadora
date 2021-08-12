package repositorio;

import modelo.Funcionario;

import javax.persistence.EntityManager;
import java.util.List;

public class FuncionarioRepository {
    private final EntityManager manager;
    private DAOGenerico<Funcionario> daoGenerico;


    public FuncionarioRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Funcionario>(manager);
    }

    public Funcionario BuscaPor(Integer id){
        return daoGenerico.buscaPorId(Funcionario.class, id);
    }

    public List<Funcionario> BuscaPor(String nome){
        return this.manager.createQuery("from funcionario" + "where upper(nome) like :nome", Funcionario.class)
                .setParameter("nome", nome.toUpperCase() + "%").getResultList();
    }

    public Funcionario salvaOuAtualiza(Funcionario funcionario){
        return daoGenerico.salvaOuAtualiza(funcionario);
    }

    public void remove (Funcionario funcionario){
        daoGenerico.remove(funcionario);
    }

}
