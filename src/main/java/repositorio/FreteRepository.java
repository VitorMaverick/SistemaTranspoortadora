package repositorio;

import modelo.Cliente;
import modelo.Frete;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;

public class FreteRepository {
    private final EntityManager manager;
    private DAOGenerico<Frete> daoGenerico;
    public FreteRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Frete>(manager);
    }

    public Frete buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Frete.class, id);
    }

    public List<Frete> buscaPor(String nome) {
        return this.manager.createQuery("from frete " +
                "where upper(nome) like :nome", Frete.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Frete salvaOuAtualiza(Frete frete) {
        return daoGenerico.salvaOuAtualiza(frete);
    }

    public void remove(Frete frete) {
        daoGenerico.remove(frete );
    }

    public List<Frete> filtrar(FreteFiltro filtro) {


        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Frete> cq = cb.createQuery(Frete.class );

        // 2. clausula from e joins
        Root<Frete> freteRoot = cq.from(Frete.class );

        // 3. adiciona as restrições (os predicados) que serão passadas na clausula where
        Predicate[] restricoes = this.criaRestricoes(filtro, cb, freteRoot );

        // 4. monta a consulta com as restrições
        cq.select(freteRoot )
                .where(restricoes )
                .orderBy( cb.asc(freteRoot.get("nome")) );


        // 5. cria e executa a consula
        return manager.createQuery(cq)
                .getResultList();
    }


    private Predicate[] criaRestricoes(FreteFiltro filtro,
                                       CriteriaBuilder cb,
                                       Root<Frete> freteRoot) {

        List<Predicate> predicates = new ArrayList<>();


        if ( filtro.getMinValor() != null ){
            predicates.add( cb.le( freteRoot.get("valor"), filtro.getMinValor() ));
        }


        if ( filtro.getMaxValor() != null ){
            predicates.add( cb.ge( freteRoot.get("valor"), filtro.getMaxValor() ));
        }

        /*
        if( filtro.getPrecoAte()  != null ) {
            predicates.add( cb.le( freteRoot.get("precoAtual"), filtro.getPrecoAte() ));
        }
         */

        if (filtro.getCidadeDeOrigem_id() != null) {
            // antes faz o join com categorias
            Path<Integer> origemPath = freteRoot.join("cidade").<Integer>get("id");

            // semelhante a clausula "on" com o critério de junção
            predicates.add ( cb.equal(origemPath, filtro.getCidadeDeOrigem_id() ) );
        }

        if (filtro.getCidadeDeDestino_id() != null) {
            // antes faz o join com categorias
            Path<Integer> destinoPath = freteRoot.join("cidade").<Integer>get("id");

            // semelhante a clausula "on" com o critério de junção
            predicates.add ( cb.equal(destinoPath, filtro.getCidadeDeDestino_id() ) );
        }



        return predicates.toArray(new Predicate[ predicates.size() ] );
    }


}
