package controle;

import entidades.Cliente;
import entidades.Espaco;
import entidades.Reserva;

public class AdministradorSistema {

    private RepositorioClientes repositorioClientes;
    private RepositorioEspacos repositorioEspacos;
    private RepositorioReservas repositorioReservas;

    public AdministradorSistema() {
        repositorioClientes = new RepositorioClientes();
        repositorioEspacos = new RepositorioEspacos();
        repositorioReservas = new RepositorioReservas();
    }

    public void cadastrarCliente(Cliente cliente) {
        repositorioClientes.adicionarCliente(cliente);
    }

    public void cadastrarEspaco(Espaco espaco) {
        repositorioEspacos.adicionarEspaco(espaco);
    }

    public void realizarReserva(String cpfCliente, String idEspaco, String data, String horaInicio, String horaFim) {
        Cliente cliente = repositorioClientes.buscarCliente(cpfCliente);
        Espaco espaco = repositorioEspacos.buscarEspaco(idEspaco);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        if (espaco == null || !espaco.estaDisponivel()) {
            System.out.println("Espaço não encontrado ou indisponível.");
            return;
        }

        // Gerar número da reserva com base na quantidade atual
        int numero = repositorioReservas.pegarQuantidadeReserva() + 1;

        double valorTotal = espaco.getValorHora(); // cálculo simples para iniciantes

        Reserva nova = new Reserva(numero, cpfCliente, idEspaco, data, horaInicio, horaFim, valorTotal);
        repositorioReservas.adicionarReserva(nova);
        espaco.setDisponivel(false);

        System.out.println("Reserva realizada com sucesso.");
    }

    public void listarClientes() {
        repositorioClientes.listarTodos();
    }

    public void listarEspacos() {
        repositorioEspacos.listarTodosOsEspacos();
    }

    public void listarReservas() {
        repositorioReservas.listarTodasReservas();
    }
}
