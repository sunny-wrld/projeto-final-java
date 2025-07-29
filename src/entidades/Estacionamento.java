package entidades;

public class Estacionamento implements ServicoAdicional {

    private int duracaoHoras;
    private double valorPorHora;

    public Estacionamento(int duracaoHoras, double valorPorHora) {
        this.duracaoHoras = duracaoHoras;
        this.valorPorHora = valorPorHora;
    }

    @Override
    public String getDescricao() {
        return "Estacionamento "
                + duracaoHoras + " horas";
    }

    @Override
    public double getValorTotal() {
        return duracaoHoras * valorPorHora;
    }
}
