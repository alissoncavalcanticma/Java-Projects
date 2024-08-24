package br.com.ctfera.course.resources;

import br.com.ctfera.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users") //mapeando para o endpoint /users
public class UserResource {

    @GetMapping //Annotation para recurso de endpoint GET
    public ResponseEntity<User> findAll(){

        User u = new User(1L, "Alisson", "alisson@alisson.com", "818181818181", "123");
        //Definindo o response do endpoint
        return ResponseEntity.ok().body(u);
    }
}
