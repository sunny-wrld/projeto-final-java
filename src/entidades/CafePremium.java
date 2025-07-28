package entidades;

public class CafePremium implements ServicoAdicional {

    private static final long serialVersionUID = 1L;

    private double valor;

    public CafePremium(double valor) {
        this.valor = valor;
    }

    @Override
    public String getDescricao() {
        return "Café Premium";
    }

    @Override
    public double getValorTotal() {
        return valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
