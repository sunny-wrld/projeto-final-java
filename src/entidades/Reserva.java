package entidades;
import java.time.LocalDate;

public class Reserva {
        private int idReserva;
        private Cliente cliente;
        private Espaco espaco;
        private LocalDate dataReserva;
        private LocalTime horaInicio;
        private LocalTime horaFim;
        private List<ServicosAdicional> servicpsAdcionais;
        private double valorTotal;

    }

    public Reserva(int idReserva, Cliente cliente, Espaco espaco, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaFim, list<ServicosAdicional> servicpsAdcionais, double valorTotal) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.espaco = espaco;
        this.dataReserva = dataReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.servicpsAdcionais = servicpsAdcionais;
        this.valorTotal = valorTotal;


    }

    public int getIdReserva() {
        return idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public void setEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public List<ServicosAdicional> getServicpsAdcionais() {
        return servicpsAdcionais;
    }

    public void setServicpsAdcionais(List<ServicosAdicional> servicpsAdcionais) {
        this.servicpsAdcionais = servicpsAdcionais;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

}
