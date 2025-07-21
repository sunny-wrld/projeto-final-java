package excecoes;

public class ClienteJaCadastradoException extends Exception {

    public ClienteJaCadastradoException(String message) {
        super(message);
    }

    public ClienteJaCadastradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteJaCadastradoException(Throwable cause) {
        super(cause);
    }
}