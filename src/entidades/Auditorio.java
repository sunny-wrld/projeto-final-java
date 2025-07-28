package entidades;

public class Auditorio extends Espaco {

    private static final long serialVersionUID = 1L;

    private boolean temProjetor;
    private boolean temSistemaSom;
    private boolean temPalco;
    private int capacidade;

    public Auditorio() {
        super("AUD_001", "Auditório Padrão", 50.0);
        this.capacidade = 100;
        this.temProjetor = false;
        this.temSistemaSom = false;
        this.temPalco = false;
    }

    public Auditorio(String id, String nome, double valorHora, int capacidade, boolean temProjetor, boolean temSistemaSom, boolean temPalco) {
        super(id, nome, valorHora);
        this.capacidade = capacidade;
        this.temProjetor = temProjetor;
        this.temSistemaSom = temSistemaSom;
        this.temPalco = temPalco;
    }

    @Override
    public String getTipo() {
        return "Auditório";
    }

    @Override
    public String getDescricaoCompleta() {
        return "Auditório: " + getNome() + " | ID: " + getId() +
                " | Valor por hora: R$ " + getValorHora() +
                " | Capacidade: " + getCapacidade() +
                " | Disponível: " + (isDisponivel() ? "Sim" : "Não") +
                " | Projetor: " + (temProjetor ? "Sim" : "Não") +
                " | Sistema de Som: " + (temSistemaSom ? "Sim" : "Não") +
                " | Palco: " + (temPalco ? "Sim" : "Não");
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isTemProjetor() {
        return temProjetor;
    }

    public void setTemProjetor(boolean temProjetor) {
        this.temProjetor = temProjetor;
    }

    public boolean isTemSistemaSom() {
        return temSistemaSom;
    }

    public void setTemSistemaSom(boolean temSistemaSom) {
        this.temSistemaSom = temSistemaSom;
    }

    public boolean isTemPalco() {
        return temPalco;
    }

    public void setTemPalco(boolean temPalco) {
        this.temPalco = temPalco;
    }

    @Override
    public String toString() {
        return "Auditorio{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", valorHora=" + getValorHora() +
                ", capacidade=" + getCapacidade() +
                ", disponivel=" + isDisponivel() +
                ", temProjetor=" + temProjetor +
                ", temSistemaSom=" + temSistemaSom +
                ", temPalco=" + temPalco +
                '}';
    }
}