package model;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Matheus Felipe
 */
/**
 * Representa um repositório para operações CRUD em pessoas físicas.
 */
public class PessoaFisicaRepo implements Serializable {

    /**
     * Para garantir que a codificação de caracteres UTF-8 seja usada ao ler e
     * escrever dados nos arquivos dessas classes.
     */
    private static final String CHARSET = "UTF-8";
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();
    /**
     * definir o serialVersionUID para o mesmo valor em todas as classes
     * serializáveis que podem ser gravadas em arquivos e recuperadas
     * posteriormente. Isso garante compatibilidade entre diferentes versões do
     * seu programa.
     */
    private static final long serialVersionUID = 123456789L;

    /**
     * Insere uma nova pessoa física no repositório.
     *
     * @param pessoaFisica A pessoa física a ser inserida.
     */
    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }

    /**
     * Altera uma pessoa física existente no repositório.
     *
     * @param pessoaFisica A pessoa física com as alterações a serem aplicadas.
     */
    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == pessoaFisica.getId()) {
                pessoasFisicas.set(i, pessoaFisica);
                break;
            }
        }
    }

    /**
     * Exclui uma pessoa física do repositório pelo ID.
     *
     * @param id O ID da pessoa física a ser excluída.
     */
    public void excluir(int id) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == id) {
                pessoasFisicas.remove(i);
                break;
            }
        }
    }

    /**
     * Obtém uma pessoa física do repositório pelo ID.
     *
     * @param id O ID da pessoa física a ser obtida.
     * @return A pessoa física encontrada ou null se não encontrada.
     */
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoa : pessoasFisicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    /**
     * Obtém todas as pessoas físicas do repositório.
     *
     * @return Uma lista de todas as pessoas físicas no repositório.
     */
    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    /**
     * Persiste os dados das pessoas físicas em um arquivo.
     *
     * @param nomeArquivo O nome do arquivo onde os dados serão persistidos.
     * @throws IOException Se ocorrer um erro de I/O durante a persistência.
     */
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(pessoasFisicas);
        }
    }

    /**
     * Recupera os dados das pessoas físicas de um arquivo.
     *
     * @param nomeArquivo O nome do arquivo de onde os dados serão recuperados.
     * @throws IOException Se ocorrer um erro de I/O durante a recuperação.
     * @throws ClassNotFoundException Se a classe das pessoas físicas não for
     * encontrada durante a recuperação.
     */
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasFisicas = (ArrayList<PessoaFisica>) in.readObject();
        }
    }
}
