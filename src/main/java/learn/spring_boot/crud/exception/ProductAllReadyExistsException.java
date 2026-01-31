package learn.spring_boot.crud.exception;

public class ProductAllReadyExistsException extends RuntimeException{
    public ProductAllReadyExistsException(String message)
    {
        super(message);
    }
}
