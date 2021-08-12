package test;

import modelo.Cliente;

import javax.persistence.*;

public class TesteCliente {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("sistemaTransportadora");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transacao = manager.getTransaction();
        transacao.begin();

        // cenário
        Cliente cliente = new Cliente();
        cliente.setNome("João de Sousa");
        cliente.setEndereco("Teste" );
        cliente.setTelefone("98984380862");

        // ação
        manager.persist(cliente);

        transacao.commit();

        manager.close();
        factory.close();

        //verificação
    }

}
