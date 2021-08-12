package test;

import modelo.Cidade;
import modelo.Cliente;
import modelo.Distancia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TesteCidade {
    public static void main(String[] args) {
        // cenário
        Cidade cidade = new Cidade();
        cidade.setNome("Teste");

        Cidade cidade1 = new Cidade();
        cidade1.setNome("Teste1");

        Distancia distancia = new Distancia();
        distancia.setQuilometros(200);
        distancia.getId().setOrigem(cidade);
        distancia.getId().setDestino(cidade1);
        //cidade.adiciona(distancia);




        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("sistemaTransportadora");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transacao = manager.getTransaction();
        transacao.begin();

        // ação
        manager.persist(cidade);

        transacao.commit();

        manager.close();
        factory.close();

        //verificação
    }
}
