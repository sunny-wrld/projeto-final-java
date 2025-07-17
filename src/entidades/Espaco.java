package entidades;

public abstract Espaco {
    private String idEspaco;
    private String nomeEspaco;
    private double valorHora;
    private boolean disponivel;;

    public Espaco(String idEspaco, String nomeEspaco, double valorHora) {
        this.idEspaco = idEspaco;
        this.nomeEspaco = nomeEspaco;
        this.valorHora = valorHora;
        this.disponivel = true;
    }



}
