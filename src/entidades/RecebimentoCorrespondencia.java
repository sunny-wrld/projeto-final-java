package entidades;

public class RecebimentoCorrespondencia extends Espaco {

    private static final long serialVersionUID = 1L;

    private boolean temSeguranca24h;
    private boolean temNotificacaoSMS;
    private int capacidadeEncomendas;

    public RecebimentoCorrespondencia() {
        super("REC_001", "Recebimento de Correspondência Padrão", 15.0);
        this.temSeguranca24h = false;
        this.temNotificacaoSMS = false;
        this.capacidadeEncomendas = 100;
    }

    public RecebimentoCorrespondencia(String id, String nome, double valorHora, boolean temSeguranca24h, boolean temNotificacaoSMS, int capacidadeEncomendas) {
        super(id, nome, valorHora);
        this.temSeguranca24h = temSeguranca24h;
        this.temNotificacaoSMS = temNotificacaoSMS;
        this.capacidadeEncomendas = capacidadeEncomendas;
    }

    @Override
    public String getTipo() {
        return "Recebimento de Correspondência";
    }

    public boolean isTemSeguranca24h() {
        return temSeguranca24h;
    }

    public void setTemSeguranca24h(boolean temSeguranca24h) {
        this.temSeguranca24h = temSeguranca24h;
    }

    public boolean isTemNotificacaoSMS() {
        return temNotificacaoSMS;
    }

    public void setTemNotificacaoSMS(boolean temNotificacaoSMS) {
        this.temNotificacaoSMS = temNotificacaoSMS;
    }

    public int getCapacidadeEncomendas() {
        return capacidadeEncomendas;
    }

    public void setCapacidadeEncomendas(int capacidadeEncomendas) {
        this.capacidadeEncomendas = capacidadeEncomendas;
    }

    @Override
    public String toString() {
        return "RecebimentoCorrespondencia{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", valorHora=" + getValorHora() +
                ", disponivel=" + isDisponivel() +
                ", temSeguranca24h=" + temSeguranca24h +
                ", temNotificacaoSMS=" + temNotificacaoSMS +
                ", capacidadeEncomendas=" + capacidadeEncomendas +
                '}';
    }
}