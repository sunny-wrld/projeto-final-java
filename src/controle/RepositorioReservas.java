package controle;

import entidades.Reserva;
import excecoes.FalhaPersistenciaException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Repositório responsável por guardar reservas feitas pelos clientes
public class RepositorioReservas {

    private List<Reserva> listaDeReservas;

    public RepositorioReservas() {
        listaDeReservas = new ArrayList<>();
    }

    public void adicionarReserva(Reserva reserva) {
        listaDeReservas.add(reserva);
    }

    public Reserva buscarReserva(int numero) {
        for (Reserva r : listaDeReservas) {
            if (r.getNumero() == numero) {
                return r;
            }
        }
        return null;
    }

    public void removerReserva(int numero) {
        listaDeReservas.removeIf(r -> r.getNumero() == numero);
    }

    public void listarTodas() {
        for (Reserva r : listaDeReservas) {
            System.out.println(r);
        }
    }

    public void salvarEmArquivo(String nomeArquivo) throws FalhaPersistenciaException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Reserva r : listaDeReservas) {
                escritor.write(r.getNumero() + "," +
                        r.getCpfCliente() + "," + // supondo método getCpfCliente()
                        r.getIdEspaco() + "," +   // supondo método getIdEspaco()
                        r.getDataReserva() + "," +
                        r.getHoraInicio() + "," +
                        r.getHoraFim() + "," +
                        r.getValorTotal());
                escritor.newLine();
            }
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao salvar as reservas no arquivo.");
        }
    }

    public void carregarDoArquivo(String nomeArquivo) throws FalhaPersistenciaException {
        listaDeReservas.clear();

        try (Scanner leitor = new Scanner(new File(nomeArquivo))) {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] partes = linha.split(",");

                if (partes.length >= 7) {
                    int numero = Integer.parseInt(partes[0]);
                    String cpfCliente = partes[1];
                    String idEspaco = partes[2];
                    String data = partes[3];
                    String horaInicio = partes[4];
                    String horaFim = partes[5];
                    double valorTotal = Double.parseDouble(partes[6]);

                    Reserva reserva = new Reserva(numero, cpfCliente, idEspaco, data, horaInicio, horaFim, valorTotal);
                    listaDeReservas.add(reserva);
                }
            }
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao carregar as reservas do arquivo.");
        }
    }
}
