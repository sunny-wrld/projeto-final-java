package excecoes;

public class EspacoIndisponivelException extends Exception {

    private static final long serialVersionUID = 1L;

    public EspacoIndisponivelException(String message) {
        super(message);
    }

    public EspacoIndisponivelException(String message, Throwable cause) {
        super(message, cause);
    }
}