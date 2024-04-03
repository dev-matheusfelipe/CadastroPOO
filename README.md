# Relatório Discente de Acompanhamento do projeto CadastroPOO

## Informações Gerais
- **Universidade:** Sociedade de Ensino Superior Estacio de SÁ
- **Campus:** Polo Santa Inêz – Belo Horizonte - MG
- **Curso:** Desenvolvimento Full Stack
- **Disciplina:** Nível 1: Iniciando o Caminho Pelo Java
- **Número da Turma:** 9001
- **Semestre Letivo:** 3º Semestre
- **Integrantes da Prática:** Matheus Felipe Basilio De Souza

## Título da Prática
Missão Prática | Nível 1 | Mundo 3

## Objetivo da Prática
- **Utilizar Herança e Polimorfismo:**
    - Aplicar conceitos de herança e polimorfismo para definir entidades no sistema.
- **Persistência em Arquivos Binários:**
    - Implementar a persistência de objetos em arquivos binários.
- **Interface Cadastral em Modo Texto:**
    - Criar uma interface de cadastro que funcione em modo de texto.
- **Controle de Exceções em Java:**
    - Utilizar o mecanismo de tratamento de exceções da plataforma Java.
- **Sistema Cadastral em Java:**
    - Ao final do projeto, o aluno terá desenvolvido um sistema cadastral em Java, aproveitando os recursos da programação orientada a objetos e a persistência em arquivos binários.

## Códigos Solicitados
A seguir, apresentamos os códigos desenvolvidos durante a prática:

- Class Pessoa
    ```
      package model;
    
      /**
       *
       * @author Matheus Felipe
       */
      public class Pessoa {
          private int id;
          private String nome;
      
          // Construtor padrão
          public Pessoa() {
          }
      
          // Construtor completo
          public Pessoa(int id, String nome) {
              this.id = id;
              this.nome = nome;
          }
      
          // Getters e Setters
          public int getId() {
              return id;
          }
      
          public void setId(int id) {
              this.id = id;
          }
      
          public String getNome() {
              return nome;
          }
      
          public void setNome(String nome) {
              this.nome = nome;
          }
      
          /**
           * Método para exibir os dados da Pessoa
           */
          public void exibir() {
              System.out.println("ID: " + id);
              System.out.println("Nome: " + nome);
          }
      }
  ```
- Class Pessoa Física
    ```
      package model;
    
      import java.io.*;
      /**
       *
       * @author Matheus Felipe
       */
      public class PessoaFisica extends Pessoa implements Serializable  {
          private int id;
          private String nome;
          private String cpf;
          private int idade;
      
          // Construtor padrão
          public PessoaFisica() {
          }
      
          // Construtor completo
          public PessoaFisica(int id, String nome, String cpf, int idade) {
              this.id = id;
              this.nome = nome;
              this.cpf = cpf;
              this.idade = idade;
          }
      
          // Getters e Setters
          public int getId() {
              return id;
          }
      
          public void setId(int id) {
              this.id = id;
          }
          
          public String getNome() {
              return nome;
          }
      
          public void setNome(String nome) {
              this.nome = nome;
          }
          
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
      
          // Método para exibir os dados da PessoaFisica
          @Override
          public void exibir() {
              super.exibir(); // Chama o método exibir da classe Pessoa
              System.out.println("CPF: " + cpf);
              System.out.println("Idade: " + idade);
          }
      }
  
    ```
- Class Pessoa Física Repo
    ``` 
      package model;
  
      import java.io.*;
      import java.util.ArrayList;
      
      /**
       *
       * @author Matheus Felipe
       */
      public class PessoaFisicaRepo implements Serializable {
          private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();
      
          // Métodos públicos
      
          public void inserir(PessoaFisica pessoaFisica) {
              pessoasFisicas.add(pessoaFisica);
          }
      
          public void alterar(PessoaFisica pessoaFisica) {
              for (int i = 0; i < pessoasFisicas.size(); i++) {
                  if (pessoasFisicas.get(i).getId() == pessoaFisica.getId()) {
                      pessoasFisicas.set(i, pessoaFisica);
                      break;
                  }
              }
          }
      
          public void excluir(int id) {
              for (int i = 0; i < pessoasFisicas.size(); i++) {
                  if (pessoasFisicas.get(i).getId() == id) {
                      pessoasFisicas.remove(i);
                      break;
                  }
              }
          }
      
          public PessoaFisica obter(int id) {
              for (PessoaFisica pessoa : pessoasFisicas) {
                  if (pessoa.getId() == id) {
                      return pessoa;
                  }
              }
              return null;
          }
      
          public ArrayList<PessoaFisica> obterTodos() {
              return pessoasFisicas;
          }
      
          public void persistir(String nomeArquivo) throws IOException {
              try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
                  out.writeObject(pessoasFisicas);
              }
          }
      
          public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
              try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
                  pessoasFisicas = (ArrayList<PessoaFisica>) in.readObject();
              }
          }
      }
  
    ```
- Class Pessoa Jurídica
  ```
    package model;
    
    /**
     *
     * @author Matheus Felipe
     */
    import java.io.Serializable;
    
    public class PessoaJuridica extends Pessoa implements Serializable {
       
        private int id;
        private String nome;
        private String cnpj;
    
        // Construtor padrão
        public PessoaJuridica() {
        }
    
        // Construtor completo
        public PessoaJuridica(int id, String nome, String cnpj) {
            this.id = id;
            this.nome = nome;
            this.cnpj = cnpj;
        }
    
        // Getters e Setters
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
        
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
        public String getCnpj() {
            return cnpj;
        }
    
        public void setCnpj(String cnpj) {
            this.cnpj = cnpj;
        }
    
        // Método para exibir os dados da PessoaJuridica
        @Override
        public void exibir() {
            super.exibir(); // Chama o método exibir da classe Pessoa
            System.out.println("CNPJ: " + cnpj);
        }
    }
  ```
- Class Pessoa Jurídica Repo
    ```
      package model;
      
      import java.io.*;
      import java.util.ArrayList;
      
      /**
       *
       * @author Matheus Felipe
       */
      public class PessoaJuridicaRepo implements Serializable {
          private ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
      
          // Métodos públicos
      
          public void inserir(PessoaJuridica pessoaJuridica) {
              pessoasJuridicas.add(pessoaJuridica);
          }
      
          public void alterar(PessoaJuridica pessoaJuridica) {
              for (int i = 0; i < pessoasJuridicas.size(); i++) {
                  if (pessoasJuridicas.get(i).getId() == pessoaJuridica.getId()) {
                      pessoasJuridicas.set(i, pessoaJuridica);
                      break;
                  }
              }
          }
      
          public void excluir(int id) {
              for (int i = 0; i < pessoasJuridicas.size(); i++) {
                  if (pessoasJuridicas.get(i).getId() == id) {
                      pessoasJuridicas.remove(i);
                      break;
                  }
              }
          }
      
          public PessoaJuridica obter(int id) {
              for (PessoaJuridica pessoa : pessoasJuridicas) {
                  if (pessoa.getId() == id) {
                      return pessoa;
                  }
              }
              return null;
          }
      
          public ArrayList<PessoaJuridica> obterTodos() {
              return pessoasJuridicas;
          }
      
          public void persistir(String nomeArquivo) throws IOException {
              try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
                  out.writeObject(pessoasJuridicas);
              }
          }
      
          public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
              try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
                  pessoasJuridicas = (ArrayList<PessoaJuridica>) in.readObject();
              }
          }
      }

    ```
- Class CadastroPOO
    ```
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

    ```
  
## Resultados da Execução dos Códigos
Os resultados obtidos ao executar os códigos foram os seguintes:

- Resultado
  ```
    run:
    Dados de Pessoa Fisica armazenados.
    Dados de Pessoa Fisica Recuperados:
    Id: 1
    Nome: Joao
    CPF: 123.456.789-01
    Idade: 30
    Id: 2
    Nome: Maria
    CPF: 987.654.321-09
    Idade: 25
    
    Dados de Pessoa Juridica armazenados.
    Dados de Pessoa Juridica Recuperados:
    Id: 1
    Nome: XPTO Sales
    CNPJ: 12345678901234
    Id: 2
    Nome: XPTO Solutions
    CNPJ: 98765432109876
    BUILD SUCCESSFUL (total time: 0 seconds)
  ```

## Análise e Conclusão
  - **Vantagens e Desvantagens do Uso de Herança**
     - **Vantagens:
        - Reutilização de Código: A herança permite que uma classe herde atributos e métodos de outra classe, evitando duplicação de implementações semelhantes.
        - Polimorfismo: Classes derivadas podem ser tratadas como objetos da classe base, facilitando a criação de código flexível e genérico.
        - Organização Hierárquica: A herança ajuda a organizar classes em uma hierarquia, refletindo relações do mundo real.
    - **Desvantagens:
        - Acoplamento Forte: Mudanças na classe base afetam todas as classes derivadas, criando um acoplamento forte.
        - Herança Múltipla Complexa: Em linguagens que suportam herança múltipla, conflitos podem surgir quando uma classe herda de várias classes.
        - Quebra de Encapsulamento: Herdar membros privados pode expor detalhes internos da classe base.
  - **Necessidade da Interface Serializable em Persistência em Arquivos Binários**
      - A interface Serializable é essencial para permitir que objetos sejam convertidos em bytes e salvos em arquivos binários. Isso é fundamental para a persistência de dados.
  - **Uso do Paradigma Funcional pela API Stream no Java**
      - A API Stream utiliza conceitos do paradigma funcional, como operações de mapeamento, filtragem e redução. Isso permite escrever código mais conciso e expressivo, melhorando a legibilidade e a manutenção.
  - **Padrão de Desenvolvimento na Persistência de Dados em Arquivos no Java**
      - No contexto do desenvolvimento Java, o padrão comumente adotado para persistência de dados em arquivos é usar a serialização (como a interface Serializable) ou formatos como JSON ou XML.
      O projeto desenvolvido atendeu aos objetivos propostos, aplicando os conceitos estudados e demonstrando a capacidade de criar um sistema cadastral em Java. O uso de herança, polimorfismo e persistência em arquivos binários contribuiu para a solução           eficiente e organizada. O controle de exceções garantiu a robustez do sistema.
      
## Repositório no GIT
O projeto está armazenado no seguinte repositório no GitHub: https://github.com/dev-matheusfelipe/CadastroPOO

Se precisar de mais informações ou tiver outras dúvidas, estou à disposição! 😊
