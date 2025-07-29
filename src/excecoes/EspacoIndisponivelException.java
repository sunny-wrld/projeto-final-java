package excecoes;

public class EspacoIndisponivelException extends Exception {

    public EspacoIndisponivelException(String message) {
        super(message);
    }

    public EspacoIndisponivelException(String message, Throwable cause) {
        super(message, cause);
    }
}