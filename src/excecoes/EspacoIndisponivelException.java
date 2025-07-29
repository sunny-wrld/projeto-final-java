package excecoes;

public class EspacoIndisponivelException extends Exception {

    public EspacoIndisponivelException() {
        super("O espaco selecionado ja ocupado no horario desejado.");
    }

    public EspacoIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
