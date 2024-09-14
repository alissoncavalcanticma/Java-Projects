package br.com.ctfera.course.resources.exceptions;

import br.com.ctfera.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

//Annotation para interceptar as execeções lançadas e permitir tratar com classes personalizadas.
@ControllerAdvice
public class ResourceExceptionHandler {

    //método de tratamento, com entidade de resposta StandardError
    @ExceptionHandler(ResourceNotFoundException.class) //Annotation para capturar tipo de exceção específica
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        //Instanciando obj StandardError
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
