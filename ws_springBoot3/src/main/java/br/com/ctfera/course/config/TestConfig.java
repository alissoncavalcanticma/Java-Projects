package br.com.ctfera.course.config;

import br.com.ctfera.course.entities.Order;
import br.com.ctfera.course.entities.User;
import br.com.ctfera.course.repositories.OrderRepository;
import br.com.ctfera.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration //Definindo a class como do tipo configuração
@Profile("test") //Definindo o perfil que será implementado com essa class //*Perfil "test" foi definido nas properties de test

public class TestConfig implements CommandLineRunner { //implements CommandLineRunner é uma interface para execução de comandos na execução da aplicação

    //Setando injeção de dependência com UserRepository
    @Autowired
    private UserRepository userRepository;

    //Setando injeção de dependência com OrderRepository
    @Autowired
    private OrderRepository orderRepository;

    //Método Run para execução de comandos na execução
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //Usando o userRepository para persistir os objetos no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        //Usando o orderRepository para persistir os objetos no banco de dados
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));


    }

}
