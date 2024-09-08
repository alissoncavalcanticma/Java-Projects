package br.com.ctfera.course.resources;

import br.com.ctfera.course.entities.User;
import br.com.ctfera.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //Definindo como endpoint REST
@RequestMapping(value = "/users") //mapeando para o endpoint /users
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping //Annotation para recurso de endpoint GET
    public ResponseEntity<List<User>> findAll(){

        //Acessando findAll() do UserService
        List<User> list = userService.findAll();

        //Definindo o response do endpoint
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Definindo a passagem de UIR parameter id
    public ResponseEntity<User> findById(@PathVariable Long id){ //Declarando passagem de URI parameter id
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //Usando Annotation para POST
    @PostMapping
    public ResponseEntity<User> insert (@RequestBody User obj){
        obj = userService.insert(obj);
        //Instanciando obj URI para retorno 201
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();

        //retorno 201, usando método created e passando o uri criado acima
        return ResponseEntity.created(uri).body(obj);
    }

}
