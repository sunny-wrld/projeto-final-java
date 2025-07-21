package excecoes;

public class ReservaNaoEncontradaException {
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
