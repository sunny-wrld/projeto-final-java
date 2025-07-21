package excecoes;

public class FalhaPersistenciaException {

    public FalhaPersistenciaException(String message) {
        super(message);
    }

    public FalhaPersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    public FalhaPersistenciaException(Throwable cause) {
        super(cause);
    }
}
