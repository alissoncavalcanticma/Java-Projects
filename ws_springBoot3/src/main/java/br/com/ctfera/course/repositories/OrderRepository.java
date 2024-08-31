package br.com.ctfera.course.repositories;

import br.com.ctfera.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//Declarando interface de repository, para ter acesso a todos os métodos do JPA
public interface OrderRepository extends JpaRepository<Order, Long> {

}
