package co.com.itglobers.model.product.exception;

public class EmptyDataException extends GeneralErrorException {
    private static final String GENERIC_MESSAGE = "Error, el producto no existe";

    public EmptyDataException(){
        super(GENERIC_MESSAGE);
    }

}
