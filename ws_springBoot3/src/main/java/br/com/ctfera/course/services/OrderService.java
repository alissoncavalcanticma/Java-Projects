package br.com.ctfera.course.services;

import br.com.ctfera.course.entities.Order;
import br.com.ctfera.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Registrando class como component service do Spring
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long Id){
        Optional <Order> obj = orderRepository.findById(Id);
        return obj.get();
    }

}
