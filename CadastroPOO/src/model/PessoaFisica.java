package model;

import java.io.Serializable;

/**
 *
 * @author Matheus Felipe
 */

/**
 * Representa uma pessoa física.
 */
public class PessoaFisica extends Pessoa implements Serializable {
    
    /**
     * definir o serialVersionUID para o mesmo valor em todas as classes
     * serializáveis que podem ser gravadas em arquivos e recuperadas
     * posteriormente. Isso garante compatibilidade entre diferentes versões do
     * seu programa.
     */
    private static final long serialVersionUID = 123456789L;
    private String cpf;
    private int idade;

    // Construtor completo
    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome); // Chama o construtor da classe Pai (Pessoa)
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getters e Setters para os atributos específicos de PessoaFisica
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Sobrescreve o método exibir para incluir os dados específicos de PessoaFisica
    @Override
    public void exibir() {
        super.exibir(); // Chama o método exibir da classe Pai (Pessoa)
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
    }
}
