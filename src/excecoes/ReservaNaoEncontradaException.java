package excecoes;

public class ReservaNaoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;

    public ReservaNaoEncontradaException(String message) {
        super(message);
    }

    public ReservaNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservaNaoEncontradaException(Throwable cause) {
        super(cause);
    }
}