package excecoes;

public class ClienteNaoEncontradoException {

    // analisar isso
     private static final long serialVersionUID = 1L;

    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado.");
    }

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
