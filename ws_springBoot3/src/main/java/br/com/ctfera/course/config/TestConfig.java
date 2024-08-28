package br.com.ctfera.course.config;

import br.com.ctfera.course.entities.User;
import br.com.ctfera.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //Definindo a class como do tipo configuração
@Profile("test") //Definindo o perfil que será implementado com essa class //*Perfil "test" foi definido nas properties de test

public class TestConfig implements CommandLineRunner { //implements CommandLineRunner é uma interface para execução de comandos na execução da aplicação

    //Setando injeção de dependência com UserRepository
    @Autowired
    private UserRepository userRepository;

    //Método Run para execução de comandos na execução
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        //Usando o userRepository para persistir os objetos no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));
    }

}
