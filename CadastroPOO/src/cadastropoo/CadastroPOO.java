package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 * Classe de exemplo para demonstrar o uso de repositórios de pessoas físicas e jurídicas.
 * 
 * @author Matheus Felipe
 */
public class CadastroPOO {

    public static void main(String[] args) throws Exception {
                String arquivoPessoas = "pessoas.dat";

        try {
            // Repositório de pessoas físicas
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            PessoaFisica pessoa1 = new PessoaFisica(1, "Joao", "123.456.789-01", 30);
            PessoaFisica pessoa2 = new PessoaFisica(2, "Maria", "987.654.321-09", 25);

            repo1.inserir(pessoa1);
            repo1.inserir(pessoa2);

            repo1.persistir(arquivoPessoas);
            System.out.println("Dados de Pessoa Fisica armazenados.");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar(arquivoPessoas);
            System.out.println("Dados de Pessoa Fisica Recuperados:");

            for (PessoaFisica pessoa : repo2.obterTodos()) {
                System.out.println("Id: " + pessoa.getId());
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("CPF: " + pessoa.getCpf());
                System.out.println("Idade: " + pessoa.getIdade());
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        
        String arquivoEmpresas = "empresas.dat";    

        // Repositório de pessoas jurídicas
        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

        // Adicionando duas empresas
        PessoaJuridica empresa1 = new PessoaJuridica(1, "XPTO Sales", "12345678901234");
        PessoaJuridica empresa2 = new PessoaJuridica(2, "XPTO Solutions", "98765432109876");

        repo3.inserir(empresa1);
        repo3.inserir(empresa2);

        try {
            // Persistindo os dados em disco
            repo3.persistir(arquivoEmpresas);
            System.out.println("\nDados de Pessoa Juridica armazenados.");

            // Recuperando os dados
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar(arquivoEmpresas);
            System.out.println("Dados de Pessoa Juridica Recuperados:");

            // Exibindo os dados das empresas recuperadas
            for (PessoaJuridica empresa : repo4.obterTodos()) {
                System.out.println("Id: " + empresa.getId());
                System.out.println("Nome: " + empresa.getNome());
                System.out.println("CNPJ: " + empresa.getCnpj());
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}


