package entidades;

public class Locker extends Espaco {

    private static final long serialVersionUID = 1L;

    private String tamanho;
    private boolean temChave;
    private boolean temCadeado;

    public Locker() {
        super("1", "Locker", 15.0);
        this.tamanho = "Medio";
        this.temChave = false;
        this.temCadeado = false;
    }

    public Locker(String id, String nome, double valorHora, String tamanho, boolean temChave, boolean temCadeado) {
        super(id, nome, valorHora);
        this.tamanho = tamanho;
        this.temChave = temChave;
        this.temCadeado = temCadeado;
    }

    @Override
    public String getTipo() {
        return "Locker";
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isTemChave() {
        return temChave;
    }

    public void setTemChave(boolean temChave) {
        this.temChave = temChave;
    }

    public boolean isTemCadeado() {
        return temCadeado;
    }

    public void setTemCadeado(boolean temCadeado) {
        this.temCadeado = temCadeado;
    }

    @Override
    public String toString() {
        return "Locker{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", valorHora=" + getValorHora() +
                ", disponivel=" + isDisponivel() +
                ", tamanho='" + tamanho + '\'' +
                ", temChave=" + temChave +
                ", temCadeado=" + temCadeado +
                '}';
    }
}