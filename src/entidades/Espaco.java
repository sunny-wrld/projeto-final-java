package entidades;

public class Espaco {
    package entidades;

    public abstract class Espaco {
        private String idEspaco;
        private String nomeEspaco;
        private double valorHora;
        private boolean disponivel;


    }

    public Espaco(String idEspaco, String nomeEspaco, double valorHora) {
        this.idEspaco = idEspaco;
        this.nomeEspaco = nomeEspaco;
        this.valorHora = valorHora;
        this.disponivel = true;


        public String getIdEspaco() {
            return idEspaco;
        }

        public void setIdEspaco(String idEspaco) {
            this.idEspaco = idEspaco;

        }
    }
}
