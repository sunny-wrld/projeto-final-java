package entidades;

public class RecebimentoCorrespondencia implements ServicoAdicional {

    private int quantidade;
    private double valorUnitario;

    public RecebimentoCorrespondencia(int quantidade, double valorUnitario) {
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String getDescricao() {
        return "Recebimento de Correspondencia " + quantidade;
    }

    @Override
    public double getValorTotal() {
        return quantidade * valorUnitario;
    }
}
