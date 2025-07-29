package entidades;

public class SalaReuniao extends Espaco {

    private int capacidade;
    private boolean temProjetor;
    private boolean temWifi;
    private boolean temQuadro;
    private boolean temArcondicionado;

    public SalaReuniao(String id, String nome, double valorHora, int capacidade,
                       boolean disponivel, boolean temProjetor, boolean temWifi,
                       boolean temQuadro, boolean temArcondicionado) {
        super(id, nome, valorHora, disponivel);
        this.capacidade = capacidade;
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
        String descricao = "Sala de Reunião: " + getNome();
        descricao += " Capacidade: " + capacidade;
        descricao += " Tem projetor: " + temProjetor;
        descricao += " Tem Wi-Fi: " + temWifi;
        descricao += " Tem quadro: " + temQuadro;
        descricao += " Tem ar-condicionado: " + temArcondicionado;
        return descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public boolean getTemProjetor() {
        return temProjetor;
    }

    public boolean getTemWifi() {
        return temWifi;
    }

    public boolean getTemQuadro() {
        return temQuadro;
    }

    public boolean getTemArcondicionado() {
        return temArcondicionado;
    }

    @Override
    public String toString() {
        return getId() + "," + getNome() + "," + getValorHora() + "," + estaDisponivel() + "," +
                capacidade + "," + temProjetor + "," + temWifi + "," + temQuadro + "," + temArcondicionado;
    }
}
