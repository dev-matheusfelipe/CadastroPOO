package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;

/**
 * Classe de exemplo para demonstrar o uso de repositórios de pessoas físicas e
 * jurídicas.
 *
 * @author Matheus Felipe
 */
public class CadastroPOO {

    public static void main(String[] args) {

        String arquivoPessoas = "pessoas.dat";
        String arquivoEmpresas = "empresas.dat";
        try (Scanner scanner = new Scanner(System.in)) {
            PessoaFisicaRepo fisicaRepo = new PessoaFisicaRepo();
            PessoaJuridicaRepo juridicaRepo = new PessoaJuridicaRepo();
            try {
                // Recuperando dados previamente armazenados
                fisicaRepo.recuperar(arquivoPessoas);
                juridicaRepo.recuperar(arquivoEmpresas);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao recuperar os dados: " + e.getMessage());
            }
            int opcao;
            do {
                System.out.println("====================================");
                System.out.println("Menu de Opcoes:");
                System.out.println("====================================");
                System.out.println("1 - Incluir Pessoa/Empresa");
                System.out.println("2 - Alterar Pessoa/Empresa");
                System.out.println("3 - Excluir Pessoa/Empresa");
                System.out.println("4 - Buscar Pelo Id");
                System.out.println("5 - Exibir Todos");
                System.out.println("6 - Persistir Dados");
                System.out.println("7 - Recuperar Dados");
                System.out.println("0 - Finalizar Programa");
                System.out.println("====================================");
                System.out.print("Escolha uma opcao: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha pendente

                switch (opcao) {
                    case 1 -> {
                        System.out.println("====================================");
                        System.out.println("Escolha uma opcao para cadastrar:");
                        System.out.println("1 - Pessoa Fisica");
                        System.out.println("2 - Empresa");
                        int tipoPessoa = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha pendente
                        switch (tipoPessoa) {
                            case 1 -> {
                                // Cadastro de Pessoa Física
                                do {
                                    System.out.println("====================================");
                                    System.out.println("Cadastro de Pessoa Fisica");
                                    System.out.print("Informe o nome: ");
                                    String nome = scanner.nextLine();
                                    System.out.print("Informe o CPF: ");
                                    String cpf = scanner.nextLine();
                                    System.out.print("Informe a idade: ");
                                    int idade = scanner.nextInt();
                                    fisicaRepo.inserir(new PessoaFisica(fisicaRepo.obterTodos().size() + 1, nome, cpf, idade));
                                    System.out.println("Dados incluidos com sucesso.");

                                    /**
                                     * Nesta implementação, após o cadastro de
                                     * uma pessoa física ou jurídica,
                                     * perguntamos ao usuário se ele deseja
                                     * cadastrar outra pessoa. Se a resposta for
                                     * "S" (sim), o loop continuará e o usuário
                                     * poderá cadastrar outra pessoa. Se a
                                     * resposta for qualquer outra coisa que não
                                     * "S", o loop será interrompido e o
                                     * programa retornará ao menu principal.
                                     * Isso oferece uma experiência de usuário
                                     * mais fluída e intuitiva.
                                     */
                                    // Consumir a nova linha pendente
                                    scanner.nextLine();

                                    // Perguntar ao usuário se deseja cadastrar outra pessoa
                                    System.out.println("====================================");
                                    System.out.println("Deseja cadastrar outra pessoa? (S/N)");
                                    String resposta = scanner.nextLine();
                                    if (!(resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("SIM"))) {
                                        break; // Sair do loop e continuar o fluxo do programa
                                    }
                                } while (true); // Loop continuará até que o usuário decida sair
                            }
                            case 2 -> {
                                // Cadastro de Pessoa Jurídica
                                do {
                                    System.out.println("====================================");
                                    System.out.println("Cadastro de Empresa");
                                    System.out.print("Informe o nome da empresa: ");
                                    String nomeEmpresa = scanner.nextLine();
                                    System.out.print("Informe o CNPJ: ");
                                    String cnpj = scanner.nextLine();
                                    juridicaRepo.inserir(new PessoaJuridica(juridicaRepo.obterTodos().size() + 1, nomeEmpresa, cnpj));
                                    System.out.println("Dados incluidos com sucesso.");

                                    /**
                                     * Nesta implementação, após o cadastro de
                                     * uma pessoa física ou jurídica,
                                     * perguntamos ao usuário se ele deseja
                                     * cadastrar outra pessoa. Se a resposta for
                                     * "S" (sim), o loop continuará e o usuário
                                     * poderá cadastrar outra pessoa. Se a
                                     * resposta for qualquer outra coisa que não
                                     * "S", o loop será interrompido e o
                                     * programa retornará ao menu principal.
                                     * Isso oferece uma experiência de usuário
                                     * mais fluída e intuitiva.
                                     */
                                    // Consumir a nova linha pendente
                                    //scanner.nextLine();

                                    // Perguntar ao usuário se deseja cadastrar outra pessoa
                                    System.out.println("====================================");
                                    System.out.println("Deseja cadastrar outra empresa? (S/N)");
                                    String resposta = scanner.nextLine();
                                    if (!(resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("sim") || resposta.equalsIgnoreCase("SIM"))) {
                                        break; // Sair do loop e continuar o fluxo do programa
                                    }
                                } while (true); // Loop continuará até que o usuário decida sair

                            }
                            default -> {
                                System.out.println("Opcao invalida.");
                                break;
                            }
                        }
                    }
                    case 2 -> {
                        // Implementar alteração de pessoa
                        System.out.println("====================================");
                        System.out.println("Escolha uma opcao a ser alterada:");
                        System.out.println("1 - Pessoa Fisica");
                        System.out.println("2 - Empresa");
                        int tipoPessoa = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha pendente
                        switch (tipoPessoa) {
                            case 1 -> {
                                // Alterar Pessoa Física
                                System.out.println("====================================");
                                System.out.print("Informe o ID da pessoa fisica a ser alterada: ");
                                int idPessoa = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha pendente
                                PessoaFisica pessoaFisica = fisicaRepo.obter(idPessoa);
                                if (pessoaFisica != null) {
                                    System.out.println("Informe os novos dados:");
                                    System.out.print("Nome: ");
                                    String novoNome = scanner.nextLine();
                                    System.out.print("CPF: ");
                                    String novoCpf = scanner.nextLine();
                                    System.out.print("Idade: ");
                                    int novaIdade = scanner.nextInt();
                                    scanner.nextLine(); // Consumir a nova linha pendente

                                    pessoaFisica.setNome(novoNome);
                                    pessoaFisica.setCpf(novoCpf);
                                    pessoaFisica.setIdade(novaIdade);
                                    fisicaRepo.alterar(pessoaFisica);
                                    System.out.println("Pessoa fisica alterada com sucesso.");
                                } else {
                                    System.out.println("Pessoa fisica com o ID fornecido nao encontrada.");
                                    break;
                                }
                            }
                            case 2 -> {
                                // Alterar Pessoa Jurídica
                                System.out.println("====================================");
                                System.out.print("Informe o ID da Empresa a ser alterada: ");
                                int idPessoa = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha pendente
                                PessoaJuridica pessoaJuridica = juridicaRepo.obter(idPessoa);
                                if (pessoaJuridica != null) {
                                    System.out.println("Informe os novos dados:");
                                    System.out.print("Nome da empresa: ");
                                    String novoNome = scanner.nextLine();
                                    System.out.print("CNPJ: ");
                                    String novoCnpj = scanner.nextLine();

                                    pessoaJuridica.setNome(novoNome);
                                    pessoaJuridica.setCnpj(novoCnpj);
                                    juridicaRepo.alterar(pessoaJuridica);
                                    System.out.println("Empresa alterada com sucesso.");
                                } else {
                                    System.out.println("Empresa com o ID fornecido não encontrada.");
                                }
                            }
                            default -> {
                                System.out.println("Opção invalida.");
                                break;
                            }
                        }
                    }
                    case 3 -> {
                        // Implementar exclusão de pessoa
                        System.out.println("====================================");
                        System.out.println("Escolha uma opcao a ser excluida:");
                        System.out.println("1 - Pessoa Fisica");
                        System.out.println("2 - Empresa");
                        int tipoPessoa = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha pendente

                        switch (tipoPessoa) {
                            case 1 -> {
                                // Excluir Pessoa Física
                                System.out.println("====================================");
                                System.out.print("Informe o ID da pessoa fisica a ser excluida: ");
                                int idPessoa = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha pendente
                                PessoaFisica pessoaFisica = fisicaRepo.obter(idPessoa);
                                if (pessoaFisica != null) {
                                    fisicaRepo.excluir(idPessoa);
                                    System.out.println("Pessoa fisica excluída com sucesso.");
                                } else {
                                    System.out.println("Pessoa fisica com o ID fornecido não encontrada.");
                                }
                            }
                            case 2 -> {
                                // Excluir Pessoa Jurídica
                                System.out.println("====================================");
                                System.out.print("Informe o ID da Empresa a ser excluida: ");
                                int idPessoa = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha pendente
                                PessoaJuridica pessoaJuridica = juridicaRepo.obter(idPessoa);
                                if (pessoaJuridica != null) {
                                    juridicaRepo.excluir(idPessoa);
                                    System.out.println("Empresa excluída com sucesso.");
                                } else {
                                    System.out.println("Empresa com o ID fornecido não encontrada.");
                                }
                            }
                            default -> {
                                System.out.println("Opcao invalida.");
                                break;
                            }
                        }
                        break;
                    }
                    case 4 -> {
                        // Implementar busca por ID
                        // Busca de pessoa pelo ID
                        System.out.println("====================================");
                        System.out.println("Escolha uma opcao a ser buscada:");
                        System.out.println("1 - Pessoa Fisica");
                        System.out.println("2 - Empresa");
                        int tipoPessoa = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha pendente

                        switch (tipoPessoa) {
                            case 1 -> {
                                // Buscar Pessoa Física
                                System.out.println("====================================");
                                System.out.print("Informe o ID da pessoa fisica a ser buscada: ");
                                int idPessoa = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha pendente
                                PessoaFisica pessoaFisica = fisicaRepo.obter(idPessoa);
                                if (pessoaFisica != null) {
                                    System.out.println("Pessoa Física encontrada:");
                                    pessoaFisica.exibir();
                                } else {
                                    System.out.println("Pessoa física com o ID fornecido não encontrada.");
                                }
                            }
                            case 2 -> {
                                // Buscar Pessoa Jurídica
                                System.out.println("====================================");
                                System.out.print("Informe o ID da Empresa a ser buscada: ");
                                int idPessoa = scanner.nextInt();
                                scanner.nextLine(); // Consumir a nova linha pendente
                                PessoaJuridica pessoaJuridica = juridicaRepo.obter(idPessoa);
                                if (pessoaJuridica != null) {
                                    System.out.println("Empresa encontrada:");
                                    System.out.println("====================================");
                                    pessoaJuridica.exibir();
                                } else {
                                    System.out.println("Empresa com o ID fornecido nao encontrada.");
                                }
                            }
                            default ->
                                System.out.println("Opção invalida.");
                        }
                        break;
                    }
                    case 5 -> {
                        // Implementar exibição de todas as pessoas / Poder escolher qual Pessoa exibir Fisica/Juridica
                        // Exibir registros de pessoas físicas ou jurídicas
                        System.out.println("====================================");
                        System.out.println("Escolha a opcao de exibicao:");
                        System.out.println("1 - Pessoa Fisica");
                        System.out.println("2 - Empresa");
                        System.out.println("3 - Exibir todas pessoas Fisicas e Empresas");
                        int tipoPessoa = scanner.nextInt();
                        scanner.nextLine(); // Consumir a nova linha pendente
                        switch (tipoPessoa) {
                            case 1 -> {
                                // Exibir pessoas físicas
                                System.out.println("========== Pessoas Fisicas ==========");
                                if (fisicaRepo.obterTodos().isEmpty()) {
                                    System.out.println("Nenhuma pessoa fisica cadastrada.");
                                } else {
                                    for (PessoaFisica pessoa : fisicaRepo.obterTodos()) {
                                        pessoa.exibir();
                                        System.out.println("----------------------");
                                        System.out.println(); // Adiciona uma linha em branco entre as pessoas
                                    }
                                }
                            }
                            case 2 -> {
                                // Exibir pessoas jurídicas
                                System.out.println("========== Empresas ==========");
                                if (juridicaRepo.obterTodos().isEmpty()) {
                                    System.out.println("Nenhuma pessoa juridica cadastrada.");
                                } else {
                                    for (PessoaJuridica empresa : juridicaRepo.obterTodos()) {
                                        empresa.exibir();
                                        System.out.println("----------------------");
                                        System.out.println(); // Adiciona uma linha em branco entre as pessoas
                                    }
                                }
                            }
                            case 3 -> {
                                System.out.println("========== Pessoas Fisicas ==========");
                                if (fisicaRepo.obterTodos().isEmpty()) {
                                    System.out.println("Nenhuma pessoa fisica cadastrada.");
                                } else {
                                    for (PessoaFisica pessoa : fisicaRepo.obterTodos()) {
                                        pessoa.exibir();
                                        System.out.println("----------------------");
                                    }
                                }

                                System.out.println("========== Empresas ==========");
                                if (juridicaRepo.obterTodos().isEmpty()) {
                                    System.out.println("Nenhuma pessoa juridica cadastrada.");
                                } else {
                                    for (PessoaJuridica empresa : juridicaRepo.obterTodos()) {
                                        empresa.exibir();
                                        System.out.println("----------------------");
                                    }
                                }
                            }
                            default ->
                                System.out.println("Opção invalida.");
                        }
                        break;
                    }
                    case 6 -> {
                        // Persistindo os dados
                        File filePessoas = new File(arquivoPessoas);
                        File fileEmpresas = new File(arquivoEmpresas);

                        if (filePessoas.exists()) {
                            filePessoas.delete();
                        }

                        if (fileEmpresas.exists()) {
                            fileEmpresas.delete();
                        }
                        try {
                            fisicaRepo.persistir(arquivoPessoas);
                            juridicaRepo.persistir(arquivoEmpresas);
                            System.out.println("====================================");
                            System.out.println("Dados persistidos com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Erro ao persistir os dados: " + e.getMessage());
                        }
                    }
                    case 7 -> {
                        // Recuperando os dados
                        // Verificar se os arquivos existem antes de tentar recuperar os dados
                        File filePessoas = new File(arquivoPessoas);
                        File fileEmpresas = new File(arquivoEmpresas);

                        /**
                         * if (filePessoas.exists()) { filePessoas.delete(); }
                         *
                         * if (fileEmpresas.exists()) { fileEmpresas.delete(); }
                         *
                         */
                        if (!filePessoas.exists() || !fileEmpresas.exists()) {
                            System.out.println("Arquivos de dados nao encontrados. Certifique-se de que os arquivos existem.");
                            break;
                        }

                        try {
                            fisicaRepo.recuperar(arquivoPessoas);
                            juridicaRepo.recuperar(arquivoEmpresas);
                            System.out.println("===================================");
                            System.out.println("Dados recuperados com sucesso.");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                        }
                    }
                    case 0 -> {
                        System.out.println("Finalizando o programa. Ate mais!");
                        break;
                    }
                    default -> {
                        System.out.println("Opcao invalida. Tente novamente.");
                        break;
                    }
                }
            } while (opcao != 0);
        }
    }
}
