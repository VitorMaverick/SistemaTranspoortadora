package test;

import modelo.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TesteFrete {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("sistemaTransportadora");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transacao = manager.getTransaction();
        transacao.begin();

        // cenário
        Frete frete = new Frete();
        frete.setValor(40);
        frete.setNumeroNotaFiscal(001);

        CategoriaFrete categoria = new CategoriaFrete();
        categoria.setDesconto(20);
        categoria.setPercentual(0.2);

        Cidade cidade = new Cidade();
        cidade.setNome("Sao luis");

        Cidade cidade1 = new Cidade();
        cidade.setNome("Caxias");

        Distancia distancia = new Distancia();
        distancia.setQuilometros(200);
        distancia.getId().setOrigem(cidade);
        distancia.getId().setDestino(cidade1);
        //cidade.adiciona(distancia);

        Cliente cliente = new Cliente();
        cliente.setNome("João de Sousa");
        cliente.setEndereco("Teste" );
        cliente.setTelefone("98984380862");

        Veiculo veiculo = new Veiculo();
        veiculo.setNumeroPlaca("KDW134");

        //itemFrete item

        frete.setCategoria(categoria);
        frete.setVeiculo(veiculo);
        frete.setCidadeDeOrigem(cidade);
        frete.setCidadeDeDestino(cidade1);
        frete.setCliente(cliente);


        // ação
        //manager.persist(cidade);
        //manager.persist(cidade1);
        manager.persist(frete);

        transacao.commit();

        manager.close();
        factory.close();

        //verificação
    }
}
