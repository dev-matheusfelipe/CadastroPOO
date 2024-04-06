package model;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Matheus Felipe
 */

/**
 * Representa um repositório para operações CRUD em pessoas jurídicas.
 */
public class PessoaJuridicaRepo implements Serializable {
    
    /**
     * Para garantir que a codificação de caracteres UTF-8 seja usada ao ler e
     * escrever dados nos arquivos dessas classes.
     */
    private static final String CHARSET = "UTF-8";
    private ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
    /**
     * definir o serialVersionUID para o mesmo valor em todas as classes
     * serializáveis que podem ser gravadas em arquivos e recuperadas
     * posteriormente. Isso garante compatibilidade entre diferentes versões do
     * seu programa.
     */
    private static final long serialVersionUID = 123456789L;

    /**
     * Insere uma nova pessoa jurídica no repositório.
     *
     * @param pessoaJuridica A pessoa jurídica a ser inserida.
     */
    public void inserir(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
    }

    /**
     * Altera uma pessoa jurídica existente no repositório.
     *
     * @param pessoaJuridica A pessoa jurídica com as alterações a serem
     * aplicadas.
     */
    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId() == pessoaJuridica.getId()) {
                pessoasJuridicas.set(i, pessoaJuridica);
                break;
            }
        }
    }

    /**
     * Exclui uma pessoa jurídica do repositório pelo ID.
     *
     * @param id O ID da pessoa jurídica a ser excluída.
     */
    public void excluir(int id) {
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId() == id) {
                pessoasJuridicas.remove(i);
                break;
            }
        }
    }

    /**
     * Obtém uma pessoa jurídica do repositório pelo ID.
     *
     * @param id O ID da pessoa jurídica a ser obtida.
     * @return A pessoa jurídica encontrada ou null se não encontrada.
     */
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoa : pessoasJuridicas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }

    /**
     * Obtém todas as pessoas jurídicas do repositório.
     *
     * @return Uma lista de todas as pessoas jurídicas no repositório.
     */
    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }

    /**
     * Persiste os dados das pessoas jurídicas em um arquivo.
     *
     * @param nomeArquivo O nome do arquivo onde os dados serão persistidos.
     * @throws IOException Se ocorrer um erro de I/O durante a persistência.
     */
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            out.writeObject(pessoasJuridicas);
        }
    }

    /**
     * Recupera os dados das pessoas jurídicas de um arquivo.
     *
     * @param nomeArquivo O nome do arquivo de onde os dados serão recuperados.
     * @throws IOException Se ocorrer um erro de I/O durante a recuperação.
     * @throws ClassNotFoundException Se a classe das pessoas jurídicas não for
     * encontrada durante a recuperação.
     */
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) in.readObject();
        }
    }
}
