package co.com.itglobers.model.product.exception;

public class SavedDataException extends GeneralErrorException {
    private static final String GENERIC_MESSAGE = "Error al insertar o editar el producto";

    public SavedDataException(){
        super(GENERIC_MESSAGE);
    }

}
