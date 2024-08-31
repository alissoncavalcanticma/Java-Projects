package br.com.ctfera.course.resources;

import br.com.ctfera.course.entities.Order;
import br.com.ctfera.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Definindo como endpoint REST
@RequestMapping(value="/orders") //Mapeando o endpoint "/orders"
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping //Annotation para recurso de endpoint GET
    public ResponseEntity<List<Order>> findAll(){

        //Acessando o findAll do OrderService
        List<Order> list = orderService.findAll();

        ///Retornando lista de orders
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}") //Definindo a passagem do URI Parameter id como identificador do recurso
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
