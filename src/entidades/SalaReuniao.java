package entidades;

public class SalaReuniao extends Espaco {

    private static final long serialVersionUID = 1L;

    private boolean temProjetor;
    private boolean temWifi;
    private boolean temQuadro;
    private boolean temArcondicionado;

    public SalaReuniao(String nome, double valorHora, int capacidade, boolean temProjetor, boolean temWifi, boolean temQuadro, boolean temArcondicionado) {
        super(nome, valorHora, capacidade);
        this.temProjetor = temProjetor;
        this.temWifi = temWifi;
        this.temQuadro = temQuadro;
        this.temArcondicionado = temArcondicionado;
    }

    public SalaReuniao(int id, String nome, double valorHora, int capacidade, boolean disponivel, boolean temProjetor, boolean temWifi, boolean temQuadro, boolean temArcondicionado) {
        super(id, nome, valorHora, capacidade, disponivel);
        this.temProjetor = temProjetor;
        this.temWifi = temWifi;
        this.temQuadro = temQuadro;
        this.temArcondicionado = temArcondicionado;
    }

    @Override
    public String getTipo() {
        return "Sala de Reunião";
    }

    @Override
    public String getDescricaoCompleta() {
        return "Sala de Reunião: " + getNome() + " | ID: " + getId() +
                " | Valor por hora: R$ " + getValorHora() +
                " | Capacidade: " + getCapacidade() +
                " | Disponível: " + (isDisponivel() ? "Sim" : "Não") +
                " | Projetor: " + (temProjetor ? "Sim" : "Não") +
                " | WiFi: " + (temWifi ? "Sim" : "Não") +
                " | Quadro: " + (temQuadro ? "Sim" : "Não") +
                " | Ar Condicionado: " + (temArcondicionado ? "Sim" : "Não");
    }

    public boolean isTemProjetor() {
        return temProjetor;
    }

    public void setTemProjetor(boolean temProjetor) {
        this.temProjetor = temProjetor;
    }

    public boolean isTemWifi() {
        return temWifi;
    }

    public void setTemWifi(boolean temWifi) {
        this.temWifi = temWifi;
    }

    public boolean isTemQuadro() {
        return temQuadro;
    }

    public void setTemQuadro(boolean temQuadro) {
        this.temQuadro = temQuadro;
    }

    public boolean isTemArcondicionado() {
        return temArcondicionado;
    }

    public void setTemArcondicionado(boolean temArcondicionado) {
        this.temArcondicionado = temArcondicionado;
    }

    @Override
    public String toString() {
        return "SalaReuniao{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", valorHora=" + getValorHora() +
                ", capacidade=" + getCapacidade() +
                ", disponivel=" + isDisponivel() +
                ", temProjetor=" + temProjetor +
                ", temWifi=" + temWifi +
                ", temQuadro=" + temQuadro +
                ", temArcondicionado=" + temArcondicionado +
                '}';
    }
}