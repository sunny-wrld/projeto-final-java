package excecoes;

public class ReservaNaoEncontradaException extends Exception {

    public ReservaNaoEncontradaException() {
        super("Reserva nao encontrada.");
    }

    public ReservaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}
