package entidades;

public class Estacionamento extends Espaco {

    private static final long serialVersionUID = 1L;

    private int numeroVagas;
    private boolean temCobertura;

    public Estacionamento() {
        super("EST_001", "Estacionamento Padrão", 10.0);
        this.numeroVagas = 50;
        this.temCobertura = false;
    }

    public Estacionamento(String id, String nome, double valorHora, int numeroVagas, boolean temCobertura) {
        super(id, nome, valorHora);
        this.numeroVagas = numeroVagas;
        this.temCobertura = temCobertura;
    }

    @Override
    public String getTipo() {
        return "Estacionamento";
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public void setNumeroVagas(int numeroVagas) {
        this.numeroVagas = numeroVagas;
    }

    public boolean isTemCobertura() {
        return temCobertura;
    }

    public void setTemCobertura(boolean temCobertura) {
        this.temCobertura = temCobertura;
    }

    @Override
    public String toString() {
        return "Estacionamento{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", valorHora=" + getValorHora() +
                ", disponivel=" + isDisponivel() +
                ", numeroVagas=" + numeroVagas +
                ", temCobertura=" + temCobertura +
                '}';
    }
}