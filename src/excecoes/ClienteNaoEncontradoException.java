package excecoes;

public class ClienteNaoEncontradoException extends Exception {

    public ClienteNaoEncontradoException() {
        super("Cliente nao encontrado no sistema.");
    }

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
