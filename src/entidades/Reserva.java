package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.util.List;
import java.util.ArrayList;

public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contadorId = 1;

    private int id;
    private Cliente cliente;
    private Espaco espaco;
    private LocalDate dataReserva;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    private List<ServicoAdicional> servicosAdicionais;
    private double valorBase;

    public Reserva(Cliente cliente, Espaco espaco, LocalDate dataReserva,
                   LocalTime horaInicio, LocalTime horaFim, double valorBase) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.espaco = espaco;
        this.dataReserva = dataReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.servicosAdicionais = new ArrayList<>();
        this.valorBase = valorBase;
    }

    public double calcularValorTotal() {
        double total = valorBase;
        for (ServicoAdicional servico : servicosAdicionais) {
            total += servico.getValorTotal();
        }
        return total;
    }

    public void adicionarServico(ServicoAdicional servico) {
        this.servicosAdicionais.add(servico);
    }

    public void removerServico(ServicoAdicional servico) {
        this.servicosAdicionais.remove(servico);
    }

    public int getId() {
        return id;
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

    public List<ServicoAdicional> getServicosAdicionais() {
        return servicosAdicionais;
    }

    public void setServicosAdicionais(List<ServicoAdicional> servicosAdicionais) {
        this.servicosAdicionais = servicosAdicionais;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", cliente=" + cliente.getNome() +
                ", espaco=" + espaco.getNome() +
                ", dataReserva=" + dataReserva +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                ", valorTotal=" + calcularValorTotal() +
                '}';
    }
}