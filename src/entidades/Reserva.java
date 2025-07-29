package entidades;

public class Reserva {

    private int numero;
    private String cpfCliente;
    private String idEspaco;
    private String dataReserva;
    private String horaInicio;
    private String horaFim;
    private double valorTotal;

    public Reserva(int numero, String cpfCliente, String idEspaco,
                   String dataReserva, String horaInicio, String horaFim, double valorTotal) {
        this.numero = numero;
        this.cpfCliente = cpfCliente;
        this.idEspaco = idEspaco;
        this.dataReserva = dataReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.valorTotal = valorTotal;
    }

    public int getNumero() {
        return numero;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getIdEspaco() {
        return idEspaco;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Reserva " + numero + " | Cliente: " + cpfCliente + " | Espaço: " + idEspaco +
                " | Data: " + dataReserva + " | " + horaInicio + " às " + horaFim +
                " | Total: R$ " + valorTotal;
    }
}
