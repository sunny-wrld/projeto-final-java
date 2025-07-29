package controle;

import entidades.Espaco;
import excecoes.FalhaPersistenciaException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Repositório responsável por armazenar os espaços de trabalho do coworking.
 * O ID do espaço é a chave no mapa.
 */
public class RepositorioEspacos {

    private Map<String, Espaco> mapaDeEspacos;

    public RepositorioEspacos() {
        mapaDeEspacos = new HashMap<>();
    }

    public void adicionarEspaco(Espaco espaco) {
        mapaDeEspacos.put(espaco.getId(), espaco);
    }

    public Espaco buscarEspaco(String id) {
        return mapaDeEspacos.get(id);
    }

    public void listarTodosOsEspacos() {
        for (Espaco espaco : mapaDeEspacos.values()) {
            System.out.println(espaco);
        }
    }

    public void salvarArquivoEspaco(String nomeDoArquivo) throws FalhaPersistenciaException {
        try {
            ObjectOutputStream gravador = new ObjectOutputStream(new FileOutputStream(nomeDoArquivo));
            gravador.writeObject(mapaDeEspacos);
            gravador.close();
        } catch (IOException erro) {
            throw new FalhaPersistenciaException("Erro ao salvar os espaços no arquivo: " + nomeDoArquivo);
        }
    }

    @SuppressWarnings("unchecked")
    public void carregarArquivoEspaco(String nomeDoArquivo) throws FalhaPersistenciaException {
        try {
            ObjectInputStream leitor = new ObjectInputStream(new FileInputStream(nomeDoArquivo));
            mapaDeEspacos = (Map<String, Espaco>) leitor.readObject();
            leitor.close();
        } catch (IOException | ClassNotFoundException erro) {
            throw new FalhaPersistenciaException("Erro ao carregar os espaços do arquivo: " + nomeDoArquivo);
        }
    }
}
