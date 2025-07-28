package controle;

import entidades.Reserva;
import entidades.Cliente;
import entidades.Espaco;
import excecoes.FalhaPersistenciaException;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class RepositorioReservas {

    private Map<String, Reserva> reservas = new HashMap<>();

    // Adiciona uma nova reserva ao repositório
    public void adicionarReserva(Reserva reserva) {
        reservas.put(reserva.getId(), reserva);
    }

    // Busca uma reserva pelo ID
    public Reserva buscarReserva(String id) {
        return reservas.get(id);
    }

    // Lista todas as reservas cadastradas
    public List<Reserva> listarTodas() {
        return new ArrayList<>(reservas.values());
    }

    // Remove uma reserva pelo ID
    public boolean removerReserva(String id) {
        return reservas.remove(id) != null;
    }

    // Salva o mapa de reservas em um arquivo texto (.txt)
    public void salvarArquivo(String nomeArquivo) throws FalhaPersistenciaException {
        try {
            FileWriter fw = new FileWriter(nomeArquivo, false);
            BufferedWriter bw = new BufferedWriter(fw);

            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

            for (Reserva reserva : reservas.values()) {
                // id;clienteId;espacoId;data;horaInicio;horaFim;status
                bw.write(
                        reserva.getId() + ";" +
                                reserva.getCliente().getCpf() + ";" +
                                reserva.getEspaco().getId() + ";" +
                                reserva.getData().format(formatoData) + ";" +
                                reserva.getHoraInicio().format(formatoHora) + ";" +
                                reserva.getHoraFim().format(formatoHora) + ";" +
                                reserva.getStatus()
                );
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao salvar os dados no arquivo texto: " + nomeArquivo);
        }
    }

    // Carrega o mapa de reservas de um arquivo texto (.txt)
    public void carregarArquivo(String nomeArquivo, RepositorioClientes repoClientes, RepositorioEspacos repoEspacos) throws FalhaPersistenciaException {
        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            reservas.clear();

            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (partes.length != 7) continue; // linha inválida, pula

                String id = partes[0];
                String clienteCpf = partes[1];
                String espacoId = partes[2];
                LocalDate data = LocalDate.parse(partes[3], formatoData);
                LocalTime horaInicio = LocalTime.parse(partes[4], formatoHora);
                LocalTime horaFim = LocalTime.parse(partes[5], formatoHora);
                String status = partes[6];

                // Busca o cliente e o espaço nos respectivos repositórios
                Cliente cliente = repoClientes.buscarCliente(clienteCpf);
                Espaco espaco = repoEspacos.buscarEspaco(espacoId);

                if (cliente != null && espaco != null) {
                    Reserva reserva = new Reserva(id, cliente, espaco, data, horaInicio, horaFim);
                    reserva.setStatus(status);
                    reservas.put(id, reserva);
                }
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de reservas não encontrado. Criando novo repositório.");
            reservas = new HashMap<>();
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao carregar os dados do arquivo texto: " + nomeArquivo);
        }
    }
}