package controle;

import entidades.*;
import excecoes.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AdministradorSistema {
    private RepositorioClientes repositorioClientes;
    private RepositorioEspacos repositorioEspacos;
    private RepositorioReservas repositorioReservas;

    public AdministradorSistema() {
        this.repositorioClientes = new RepositorioClientes();
        this.repositorioEspacos = new RepositorioEspacos();
        this.repositorioReservas = new RepositorioReservas();
    }

    public void cadastrarCliente(String nome, String cpf, String telefone) {
        Cliente novoCliente = new Cliente(nome, cpf, telefone);
        repositorioClientes.adicionarCliente(novoCliente);
    }

    public Cliente buscarCliente(String cpf) {
        return repositorioClientes.buscarCliente(cpf); // Usar buscarCliente em vez de buscarPorCpf
    }

    public void cadastrarEstacaoTrabalho(String id, String nome, double valorHora) {
        EstacaoTrabalho espaco = new EstacaoTrabalho(id, nome, valorHora);
        repositorioEspacos.adicionarEspaco(espaco);
    }

    public void cadastrarSalaPrivada(String id, String nome, double valorHora) {
        SalaPrivada espaco = new SalaPrivada(id, nome, valorHora);
        repositorioEspacos.adicionarEspaco(espaco);
    }

    public List<Espaco> listarEspacos() {
        return List.copyOf(repositorioEspacos.espacos.values()); // Converter Map para List
    }

    public void criarReserva(String cpfCliente, String espacoId,
                             LocalDate data, LocalTime horaInicio, LocalTime horaFim)
            throws ClienteNaoEncontradoException, EspacoIndisponivelException {

        Cliente cliente = buscarCliente(cpfCliente);
        if (cliente == null) {
            throw new ClienteNaoEncontradoException();
        }

        Espaco espaco = repositorioEspacos.buscarEspaco(espacoId); // Usar buscarEspaco
        if (espaco == null) {
            throw new EspacoIndisponivelException("Espaço não encontrado");
        }

        // Gerar ID para a reserva
        String reservaId = "R" + System.currentTimeMillis();
        Reserva novaReserva = new Reserva(reservaId, cliente, espaco, data, horaInicio, horaFim);
        repositorioReservas.adicionarReserva(novaReserva);
    }

    public List<Reserva> listarReservas() {
        return repositorioReservas.listarTodas();
    }
}