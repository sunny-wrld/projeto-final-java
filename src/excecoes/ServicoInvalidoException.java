package excecoes;

public class ServicoInvalidoException {
    public ServicoInvalidoException(String message) {
        super(message);
    }

    public ServicoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicoInvalidoException(Throwable cause) {
        super(cause);
    }
}
