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

    public void salvarArquivo(String nomeArquivo) throws FalhaPersistenciaException {
        try {
            FileOutputStream arquivo = new FileOutputStream(nomeArquivo, false);
            ObjectOutputStream gravador = new ObjectOutputStream(arquivo);
            gravador.writeObject(clientes);
            gravador.close();
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao salvar os dados no arquivo: " + nomeArquivo);
        }
    }

    public void carregarArquivo(String nomeArquivo) throws FalhaPersistenciaException {
        try {
            FileInputStream arquivo = new FileInputStream(nomeArquivo);
            ObjectInputStream leitor = new ObjectInputStream(arquivo);
            Object objetoLido = leitor.readObject();
            leitor.close();

            if (objetoLido instanceof Map<?, ?> mapaGenerico) {
                boolean tiposOk = true;
                for (Map.Entry<?, ?> entrada : mapaGenerico.entrySet()) {
                    if (!(entrada.getKey() instanceof String) || !(entrada.getValue() instanceof Cliente)) {
                        tiposOk = false;
                        break;
                    }
                }

                if (tiposOk) {
                    clientes = new HashMap<>();
                    for (Map.Entry<?, ?> entrada : mapaGenerico.entrySet()) {
                        String cpf = (String) entrada.getKey();
                        Cliente cliente = (Cliente) entrada.getValue();
                        clientes.put(cpf, cliente);
                    }
                } else {
                    throw new FalhaPersistenciaException("Erro: o arquivo contém dados incompatíveis.");
                }
            } else {
                throw new FalhaPersistenciaException("Erro: o arquivo não contém um mapa de clientes.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de clientes não encontrado. Criando novo repositório.");
            clientes = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new FalhaPersistenciaException("Erro ao carregar os dados do arquivo: " + nomeArquivo);
        }
    }
}
