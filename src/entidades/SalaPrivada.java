package entidades;

public class SalaPrivada extends Espaco {

    private static final long serialVersionUID = 1L;

    private boolean temAcessoPrivativo;
    private boolean temChave;
    private boolean temSeguranca;
    private int capacidade;

    public SalaPrivada() {
        super("SALA_001", "Sala Privada Padrão", 50.0);
        this.capacidade = 4;
        this.temAcessoPrivativo = true;
        this.temChave = true;
        this.temSeguranca = false;
    }

    public SalaPrivada(String id, String nome, double valorHora, int capacidade,
                       boolean temAcessoPrivativo, boolean temChave, boolean temSeguranca) {
        super(id, nome, valorHora);
        this.capacidade = capacidade;
        this.temAcessoPrivativo = temAcessoPrivativo;
        this.temChave = temChave;
        this.temSeguranca = temSeguranca;
    }

    @Override
    public String getTipo() {
        return "Sala Privada";
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isTemAcessoPrivativo() {
        return temAcessoPrivativo;
    }

    public void setTemAcessoPrivativo(boolean temAcessoPrivativo) {
        this.temAcessoPrivativo = temAcessoPrivativo;
    }

    public boolean isTemChave() {
        return temChave;
    }

    public void setTemChave(boolean temChave) {
        this.temChave = temChave;
    }

    public boolean isTemSeguranca() {
        return temSeguranca;
    }

    public void setTemSeguranca(boolean temSeguranca) {
        this.temSeguranca = temSeguranca;
    }

    @Override
    public String toString() {
        return "SalaPrivada{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", valorHora=" + getValorHora() +
                ", capacidade=" + capacidade +
                ", disponivel=" + isDisponivel() +
                ", temAcessoPrivativo=" + temAcessoPrivativo +
                ", temChave=" + temChave +
                ", temSeguranca=" + temSeguranca +
                '}';
    }
}