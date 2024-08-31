package br.com.ctfera.course.resources;

import br.com.ctfera.course.entities.Category;
import br.com.ctfera.course.services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Definindo como endpoint REST
@RequestMapping(value = "/categories")  //mapeando para o endpoint /categories
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping //Annotation para recurso de endpoint GET
    public ResponseEntity<List<Category>> findAll(){

        List<Category> list = categoryService.findAll();

        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}") //Definindo a passagem de URI parameter id
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = categoryService.findById(id);

        return ResponseEntity.ok().body(obj);
    }
}
