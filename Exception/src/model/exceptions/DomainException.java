package model.exceptions;

public class DomainException extends Exception{
    //Classe Exception é serializable, e necessita dessa definição
    private static final long serialVersionUID = 1L;

    public DomainException(String msg){
        super(msg);
    }


}
