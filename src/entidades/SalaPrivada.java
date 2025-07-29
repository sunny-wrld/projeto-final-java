package entidades;

public class SalaReuniao extends Espaco {

    public SalaReuniao(String id, String nome, double valorHora, boolean disponivel) {
        super(id, nome, valorHora, disponivel);
    }

    @Override
    public String getTipo() {
        return "Sala de Reunião";
    }

    @Override
    public String getDescricaoCompleta() {
        return "Sala de Reunião: " + getNome() + " (ID: " + getId() + ")";
    }
}
