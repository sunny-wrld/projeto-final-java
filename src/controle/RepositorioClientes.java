package controle;

import entidades.Espaco;
import excecoes.FalhaPersistenciaException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Repositório responsável por armazenar espaços de coworking em arquivo de texto
public class RepositorioEspacos {

    private List<Espaco> listaDeEspacos;

    public RepositorioEspacos() {
        listaDeEspacos = new ArrayList<>();
    }

    public void adicionarEspaco(Espaco espaco) {
        listaDeEspacos.add(espaco);
    }

    public Espaco buscarEspaco(String id) {
        for (Espaco e : listaDeEspacos) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    public void listarTodos() {
        for (Espaco espaco : listaDeEspacos) {
            System.out.println(espaco);
        }
    }

    public void salvarEmArquivo(String nomeArquivo) throws FalhaPersistenciaException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Espaco e : listaDeEspacos) {
                escritor.write(e.getId() + "," +
                        e.getNome() + "," +
                        e.getValorHora() + "," +
                        e.estaDisponivel()); // supondo método boolean
                escritor.newLine();
            }
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao salvar os espaços no arquivo.");
        }
    }

    public void carregarDoArquivo(String nomeArquivo) throws FalhaPersistenciaException {
        listaDeEspacos.clear();

        try (Scanner leitor = new Scanner(new File(nomeArquivo))) {
            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                String[] partes = linha.split(",");

                if (partes.length >= 4) {
                    String id = partes[0];
                    String nome = partes[1];
                    double valorHora = Double.parseDouble(partes[2]);
                    boolean disponivel = Boolean.parseBoolean(partes[3]);

                    Espaco espaco = new Espaco(id, nome, valorHora, disponivel); // adaptado
                    listaDeEspacos.add(espaco);
                }
            }
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao carregar os espaços do arquivo.");
        }
    }
}
