package entidades;

public abstract class Espaco {

    private String id;
    private String nome;
    private double valorHora;
    private boolean disponivel;

    public Espaco(String id, String nome, double valorHora, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.valorHora = valorHora;
        this.disponivel = disponivel;
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

    public boolean estaDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public abstract String getTipo();

    public abstract String getDescricaoCompleta();

    @Override
    public String toString() {
        String status;

        if (disponivel) {
            status = "Disponível";
        } else {
            status = "Indisponível";
        }

        return getTipo() + ": " + nome + " ID: " + id +
                " R$ " + valorHora + "hora  " + status;
    }
}
