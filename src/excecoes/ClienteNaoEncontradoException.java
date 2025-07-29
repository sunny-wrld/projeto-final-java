package excecoes;

public class ClienteNaoEncontradoException extends Exception {

    public ClienteNaoEncontradoException() {
        super("Cliente nao encontrado.");
    }

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}