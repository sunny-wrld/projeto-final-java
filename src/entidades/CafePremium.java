package entidades;

public class CafePremium implements ServicoAdicional {

    private int quantidadeDeCopos;
    private double valorPorCopo;

    public CafePremium(int quantidadeDeCopos, double valorPorCopo) {
        this.quantidadeDeCopos = quantidadeDeCopos;
        this.valorPorCopo = valorPorCopo;
    }

    @Override
    public String getDescricao() {
        return "Café Premium (" + quantidadeDeCopos + " copos)";
    }

    @Override
    public double getValorTotal() {
        return quantidadeDeCopos * valorPorCopo;
    }
}
