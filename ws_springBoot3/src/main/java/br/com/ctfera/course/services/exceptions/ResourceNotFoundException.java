package br.com.ctfera.course.services.exceptions;


//Extendendo de RunTimeException por ser uma classe de exceção que o Java não te obriga a tratar.
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }
}
