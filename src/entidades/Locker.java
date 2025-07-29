package entidades;

public class Locker implements ServicoAdicional {

    private int quantidade;
    private double valorPorUnidade;

    public Locker(int quantidade, double valorPorUnidade) {
        this.quantidade = quantidade;
        this.valorPorUnidade = valorPorUnidade;
    }

    @Override
    public String getDescricao() {
        return "Locker " + quantidade + " unidades"; }

    @Override
    public double getValorTotal() {
        return quantidade * valorPorUnidade;
    }
}
