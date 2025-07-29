package controle;

import entidades.Cliente;
import excecoes.FalhaPersistenciaException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RepositorioClientes {

    private Map<String, Cliente> clientes = new HashMap<>();

    public void adicionarCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
    }

    public Cliente buscarCliente(String cpf) {
        return clientes.get(cpf);
    }

    public void listarTodos() {
        for (Cliente c : clientes.values()) {
            System.out.println(c);
        }
    }

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
