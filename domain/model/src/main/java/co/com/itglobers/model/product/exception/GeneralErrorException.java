package co.com.itglobers.model.product.exception;

public class GeneralErrorException extends RuntimeException{
    /**
     * Generic Constructor
     * @param message
     */
    public GeneralErrorException(String message){
        super(message);
    }
}
