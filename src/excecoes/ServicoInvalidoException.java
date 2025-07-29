package excecoes;

public class ServicoInvalidoException extends Exception {

    public ServicoInvalidoException() {
        super("Servico adicional invalido ou nao encontrado.");
    }

    public ServicoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
