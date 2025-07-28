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
                   LocalTime horaInicio, LocalTime horaFim) {
        validarParametros(cliente, espaco, dataReserva, horaInicio, horaFim);

        this.id = contadorId++;
        this.cliente = cliente;
        this.espaco = espaco;
        this.dataReserva = dataReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.servicosAdicionais = new ArrayList<>();
        this.valorBase = calcularValorBase();
    }

    public Reserva(int id, Cliente cliente, Espaco espaco, LocalDate dataReserva,
                   LocalTime horaInicio, LocalTime horaFim, double valorBase) {
        this.id = id;
        this.cliente = cliente;
        this.espaco = espaco;
        this.dataReserva = dataReserva;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.servicosAdicionais = new ArrayList<>();
        this.valorBase = valorBase;

        // att o atualizador
        if (id >= contadorId) {
            contadorId = id + 1;
        }
    }

    private void validarParametros(Cliente cliente, Espaco espaco, LocalDate dataReserva,
                                   LocalTime horaInicio, LocalTime horaFim) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        if (espaco == null) {
            throw new IllegalArgumentException("Espaço não pode ser nulo");
        }
        if (dataReserva == null) {
            throw new IllegalArgumentException("Data da reserva não pode ser nula");
        }
        if (horaInicio == null || horaFim == null) {
            throw new IllegalArgumentException("Horários não podem ser nulos");
        }
        if (dataReserva.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data da reserva deve ser futura");
        }
        if (horaFim.isBefore(horaInicio) || horaFim.equals(horaInicio)) {
            throw new IllegalArgumentException("Hora fim deve ser posterior à hora início");
        }
    }

    private double calcularValorBase() {
        Duration duracao = Duration.between(horaInicio, horaFim);
        double horas = duracao.toMinutes() / 60.0;
        return horas * espaco.getValorHora();
    }

    public double calcularValorTotal() {
        double total = valorBase;
        for (ServicoAdicional servico : servicosAdicionais) {
            total += servico.getValorTotal();
        }
        return total;
    }

    public void adicionarServico(ServicoAdicional servico) {
        if (servico != null) {
            this.servicosAdicionais.add(servico);
        }
    }

    public void removerServico(ServicoAdicional servico) {
        this.servicosAdicionais.remove(servico);
    }

    public long getDuracaoEmMinutos() {
        return Duration.between(horaInicio, horaFim).toMinutes();
    }

    public double getDuracaoEmHoras() {
        return getDuracaoEmMinutos() / 60.0;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Espaco getEspaco() {
        return espaco;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public List<ServicoAdicional> getServicosAdicionais() {
        return new ArrayList<>(servicosAdicionais);
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        this.cliente = cliente;
    }

    public void setEspaco(Espaco espaco) {
        if (espaco == null) {
            throw new IllegalArgumentException("Espaço não pode ser nulo");
        }
        this.espaco = espaco;
        // Recalcula valor base se o espaço mudar
        this.valorBase = calcularValorBase();
    }

    public void setDataReserva(LocalDate dataReserva) {
        if (dataReserva == null || dataReserva.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data da reserva deve ser futura");
        }
        this.dataReserva = dataReserva;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        if (horaInicio == null) {
            throw new IllegalArgumentException("Hora início não pode ser nula");
        }
        if (horaFim != null && horaInicio.isAfter(horaFim)) {
            throw new IllegalArgumentException("Hora início deve ser anterior à hora fim");
        }
        this.horaInicio = horaInicio;
        this.valorBase = calcularValorBase();
    }

    public void setHoraFim(LocalTime horaFim) {
        if (horaFim == null) {
            throw new IllegalArgumentException("Hora fim não pode ser nula");
        }
        if (horaInicio != null && horaFim.isBefore(horaInicio)) {
            throw new IllegalArgumentException("Hora fim deve ser posterior à hora início");
        }
        this.horaFim = horaFim;
        this.valorBase = calcularValorBase();
    }

    public void setServicosAdicionais(List<ServicoAdicional> servicosAdicionais) {
        this.servicosAdicionais = servicosAdicionais != null ?
                new ArrayList<>(servicosAdicionais) : new ArrayList<>();
    }

    public void setValorBase(double valorBase) {
        if (valorBase < 0) {
            throw new IllegalArgumentException("Valor base não pode ser negativo");
        }
        this.valorBase = valorBase;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", cliente=" + (cliente != null ? cliente.getNomeCliente() : "null") +
                ", espaco=" + (espaco != null ? espaco.getNome() : "null") +
                ", dataReserva=" + dataReserva +
                ", horaInicio=" + horaInicio +
                ", horaFim=" + horaFim +
                ", duração=" + getDuracaoEmHoras() + "h" +
                ", valorBase=" + String.format("%.2f", valorBase) +
                ", valorTotal=" + String.format("%.2f", calcularValorTotal()) +
                ", servicosAdicionais=" + servicosAdicionais.size() +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Reserva reserva = (Reserva) obj;
        return id == reserva.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}