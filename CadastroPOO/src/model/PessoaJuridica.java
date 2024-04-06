package model;

import java.io.Serializable;

/**
 *
 * @author Matheus Felipe
 */
/**
 * Representa uma pessoa jurídica.
 */
public class PessoaJuridica extends Pessoa implements Serializable {

    /**
     * definir o serialVersionUID para o mesmo valor em todas as classes
     * serializáveis que podem ser gravadas em arquivos e recuperadas
     * posteriormente. Isso garante compatibilidade entre diferentes versões do
     * seu programa.
     */
    private static final long serialVersionUID = 123456789L;
    private String cnpj;

    // Construtor completo
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome); // Chama o construtor da classe Pai (Pessoa)
        this.cnpj = cnpj;
    }

    // Getters e Setters para os atributos específicos de PessoaJuridica
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Sobrescreve o método exibir para incluir os dados específicos de PessoaJuridica
    @Override
    public void exibir() {
        super.exibir(); // Chama o método exibir da classe Pai (Pessoa)
        System.out.println("CNPJ: " + cnpj);
    }
}
