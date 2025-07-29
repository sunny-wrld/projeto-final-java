package controle;

import entidades.Cliente;
import excecoes.FalhaPersistenciaException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RepositorioClientes {

    // Mapa que guarda os clientes, onde o CPF é a chave
    private Map<String, Cliente> clientes = new HashMap<>();

    // Adiciona um cliente no mapa
    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    // Busca um cliente pelo CPF
    public Cliente buscarCliente(String cpf) {
        return clientes.get(cpf);
    }

    // Mostra todos os clientes cadastrados no console
    public void listarTodos() {
        for (Cliente c : clientes.values()) {
            System.out.println(c);
        }
    }

    // Salva os dados dos clientes em um arquivo .txt
    public void salvarArquivoCliente(String nomeArquivo) throws FalhaPersistenciaException {
        try (BufferedWriter gravador = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Cliente c : clientes.values()) {
                String linha = c.getCpf() + ";" + c.getNomeCliente() + ";" + c.getEmail();
                gravador.write(linha);
                gravador.newLine();
            }
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao salvar os clientes no arquivo: " + nomeArquivo);
        }
    }

    // Carrega os dados dos clientes de um arquivo .txt
    public void carregarArquivoCliente(String nomeArquivo) throws FalhaPersistenciaException {
        clientes.clear();
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    Cliente cliente = new Cliente(partes[0], partes[1], partes[2]);
                    clientes.put(cliente.getCpf(), cliente);
                }
            }
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao carregar os clientes do arquivo: " + nomeArquivo);
        }
    }
}
