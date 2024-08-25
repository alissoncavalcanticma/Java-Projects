package br.com.ctfera.course.repositories;

import br.com.ctfera.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Declarando interface de repository, para ter acesso a todos os métodos do JPA
public interface UserRepository extends JpaRepository<User, Long> {


}
