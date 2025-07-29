package excecoes;

public class ClienteJaCadastradoException extends Exception {

    public ClienteJaCadastradoException() {
        super("Ja existe um cliente cadastrado com este CPF.");
    }

    public ClienteJaCadastradoException(String mensagem) {
        super(mensagem);
    }
}
