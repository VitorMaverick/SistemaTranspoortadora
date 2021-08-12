package test;

import modelo.Dependente;
import modelo.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Maria");
        funcionario.setEndereco("Teste");
        funcionario.setTelefone("984380862");
        funcionario.setMatricula(002);
        Dependente dependente = new Dependente();
        dependente.setDataDeNascimento(26/06/1997);
        dependente.setNome("Maria Filha");
        dependente.setFuncionario(funcionario);
        funcionario.adiciona(dependente);

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("sistemaTransportadora");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transacao = manager.getTransaction();
        transacao.begin();

        //ação
        manager.persist(funcionario);

        transacao.commit();

        manager.close();
        factory.close();

        // Verificação
        System.out.println(funcionario);
    }
    }


