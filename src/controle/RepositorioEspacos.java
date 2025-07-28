package controle;

import entidades.Espaco;
import entidades.EstacaoTrabalho;
import entidades.SalaPrivada;
import entidades.SalaReuniao;
import entidades.Auditorio;
import excecoes.FalhaPersistenciaException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RepositorioEspacos {

    private Map<String, Espaco> espacos = new HashMap<>();

    // Adiciona um novo espaço ao repositório
    public void adicionarEspaco(Espaco espaco) {
        espacos.put(espaco.getId(), espaco);
    }

    // Busca um espaço pelo ID
    public Espaco buscarEspaco(String id) {
        return espacos.get(id);
    }

    // Lista todos os espaços cadastrados
    public void listarTodos() {
        for (Espaco e : espacos.values()) {
            System.out.println(e);
        }
    }

    // Salva o mapa de espaços em um arquivo texto (.txt)
    public void salvarArquivo(String nomeArquivo) throws FalhaPersistenciaException {
        try {
            FileWriter fw = new FileWriter(nomeArquivo, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Espaco espaco : espacos.values()) {
                // id;nome;valorHora;disponivel;tipo
                bw.write(
                        espaco.getId() + ";" +
                                espaco.getNome() + ";" +
                                espaco.getValorHora() + ";" +
                                espaco.isDisponivel() + ";" +
                                espaco.getTipo()
                );
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao salvar os dados no arquivo texto: " + nomeArquivo);
        }
    }

    // Carrega o mapa de espaços de um arquivo texto (.txt)
    public void carregarArquivo(String nomeArquivo) throws FalhaPersistenciaException {
        try {
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);

            espacos.clear();

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (partes.length != 5) continue; // linha inválida, pula

                String id = partes[0];
                String nome = partes[1];
                double valorHora = Double.parseDouble(partes[2]);
                boolean disponivel = Boolean.parseBoolean(partes[3]);
                String tipo = partes[4];

                Espaco espaco = null;
                switch (tipo) {
                    case "Estação de Trabalho":
                        espaco = new EstacaoTrabalho(id, nome, valorHora);
                        break;
                    case "Sala Privada":
                        espaco = new SalaPrivada(id, nome, valorHora);
                        break;
                    case "Sala de Reunião":
                        espaco = new SalaReuniao(id, nome, valorHora);
                        break;
                    case "Auditório":
                        espaco = new Auditorio(id, nome, valorHora);
                        break;
                }
                if (espaco != null) {
                    espaco.setDisponivel(disponivel);
                    espacos.put(id, espaco);
                }
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de espaços não encontrado. Criando novo repositório.");
            espacos = new HashMap<>();
        } catch (IOException e) {
            throw new FalhaPersistenciaException("Erro ao carregar os dados do arquivo texto: " + nomeArquivo);
        }
    }
}
