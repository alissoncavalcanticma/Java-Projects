package org.example.aplicacao;


import org.example.dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        //Instanciando gerentes de entidades
        //Cria entidade com conexão ativa ao banco de dados
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        //Cria entidade que irá se utilizar da conexão da entidade anterior para criação das entidades no banco
        EntityManager em = emf.createEntityManager();


        /*

        //Instanciando objetos para inserção em base de dados

        Pessoa p1 = new Pessoa(null, "Alisson Cavalcanti", "alisson@alisson.com");
        Pessoa p2 = new Pessoa(null, "Fabiana Cavalcanti", "fabiana@fabiana.com");
        Pessoa p3 = new Pessoa(null, "CT Cavalcanti", "ct@ct.com");

        //Persistindo entidades

            //Abrindo transação
            em.getTransaction().begin();

            //Persistindo Entidades
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);

            //Comitando Transação
            em.getTransaction().commit();

        System.out.println("Entidades persistidas");

        */


        /*

        //Realizando consultas via EntityManager

        Pessoa p = em.find(Pessoa.class, 3);

        System.out.println(p);

         */

        //Removendo dados com o EntityManager

        Pessoa p_remove = em.find(Pessoa.class, 4);

        em.getTransaction().begin();
        em.remove(p_remove);
        em.getTransaction().commit();

        System.out.println("Registro removido!");


        //Encerrando gerentes de entidades
        em.close();
        emf.close();
    }
}