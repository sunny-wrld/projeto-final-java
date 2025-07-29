package entidades;

public class EstacaoTrabalho extends Espaco {

    private boolean temComputador;
    private boolean temImpressora;
    private int capacidade;

    public EstacaoTrabalho(String id, String nome, double valorHora,
                           boolean disponivel, int capacidade, boolean temComputador, boolean temImpressora) {
        super(id, nome, valorHora, disponivel);
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
    public String getDescricaoCompleta() {
        return "Estação de Trabalho: " + getNome() +
                "\nID: " + getId() +
                "\nValor/hora: R$ " + getValorHora() +
                "\nDisponível: " + (estaDisponivel() ? "Sim" : "Não") +
                "\nCapacidade: " + capacidade +
                "\nComputador: " + (temComputador ? "Sim" : "Não") +
                "\nImpressora: " + (temImpressora ? "Sim" : "Não");
    }

    @Override
    public String toString() {
        return "EstacaoTrabalho{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", valorHora=" + getValorHora() +
                ", capacidade=" + capacidade +
                ", disponivel=" + estaDisponivel() +
                ", temComputador=" + temComputador +
                ", temImpressora=" + temImpressora +
                '}';
    }
}
