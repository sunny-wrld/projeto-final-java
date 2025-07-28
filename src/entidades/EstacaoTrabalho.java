package entidades;

public class EstacaoTrabalho extends Espaco {

    private static final long serialVersionUID = 1L;

    private boolean temComputador;
    private boolean temImpressora;
    private int capacidade; // Adicionar atributo próprio

    public EstacaoTrabalho() {
        super("EST_001", "Estação de Trabalho Padrão", 20.0);
        this.capacidade = 1;
        this.temComputador = false;
        this.temImpressora = false;
    }

    public EstacaoTrabalho(String id, String nome, double valorHora, int capacidade, boolean temComputador, boolean temImpressora) {
        super(id, nome, valorHora);
        this.capacidade = capacidade;
        this.temComputador = temComputador;
        this.temImpressora = temImpressora;
    }

    @Override
    public String getTipo() {
        return "Estação de Trabalho";
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isTemComputador() {
        return temComputador;
    }

    public void setTemComputador(boolean temComputador) {
        this.temComputador = temComputador;
    }

    public boolean isTemImpressora() {
        return temImpressora;
    }

    public void setTemImpressora(boolean temImpressora) {
        this.temImpressora = temImpressora;
    }

    @Override
    public String toString() {
        return "EstacaoTrabalho{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", valorHora=" + getValorHora() +
                ", capacidade=" + getCapacidade() +
                ", disponivel=" + isDisponivel() +
                ", temComputador=" + temComputador +
                ", temImpressora=" + temImpressora +
                '}';
    }
}