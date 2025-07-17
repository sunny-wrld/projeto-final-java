package entidades;

import java.time.LocalDate;

public class Reserva {
    private int idReserva;
    private Cliente cliente;
    private Espaco espaco;
    private LocalDate dataReserva;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private list<ServicosAdicional> servicpsAdcionais;
    private double valorTotal;
}
