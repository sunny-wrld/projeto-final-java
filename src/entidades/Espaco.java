package entidades;

import java.io.Serializable;

public abstract class Espaco implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private double valorHora;
    private boolean disponivel;

    public Espaco(String id, String nome, double valorHora) {
        this.id = id;
        this.nome = nome;
        this.valorHora = valorHora;
        this.disponivel = true;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public abstract String getTipo();

    public String getDescricaoCompleta() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Tipo: " + getTipo() +
                " | Valor/hora: R$" + valorHora +
                " | Disponível: " + (disponivel ? "Sim" : "Não");
    }

    @Override
    public String toString() {
        return getDescricaoCompleta();
    }
}
