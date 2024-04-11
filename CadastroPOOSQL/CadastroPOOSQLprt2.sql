-- Inserir usuário op1
INSERT INTO Usuarios (Nome, Username, Senha)
VALUES ('Operador 1', 'op1', 'op1');

-- Inserir usuário op2
INSERT INTO Usuarios (Nome, Username, Senha)
VALUES ('Operador 2', 'op2', 'op2');

-- Inserir produtos
INSERT INTO Produtos (Nome, Quantidade, PrecoVenda)
VALUES ('Produto A', 10, 100.00),
       ('Produto B', 20, 150.00),
       ('Produto C', 15, 120.00);

-- Inserir pessoa física
INSERT INTO Pessoas (PessoaID, Nome, Endereco, Email, Telefone)
VALUES (1, 'João', 'Rua A', 'joao@email.com', '123456789');

-- Inserir pessoa física com CPF
INSERT INTO PessoasFisicas (PessoaID, CPF)
VALUES (1, '123.456.789-01');

-- Inserir pessoa jurídica
INSERT INTO Pessoas (PessoaID, Nome, Endereco, Email, Telefone)
VALUES (2, 'Empresa X', 'Rua B', 'empresa@email.com', '987654321');

-- Inserir pessoa jurídica com CNPJ
INSERT INTO PessoasJuridicas (PessoaID, CNPJ)
VALUES (2, '12.345.678/0001-99');

-- Inserir movimentações de entrada
INSERT INTO Movimentacoes (Tipo, ProdutoID, PessoaID, Quantidade, PrecoUnitario)
VALUES ('E', 1, 2, 5, 90.00),
       ('E', 2, 3, 10, 130.00);

-- Inserir movimentações de saída
INSERT INTO Movimentacoes (Tipo, ProdutoID, PessoaID, Quantidade, PrecoUnitario)
VALUES ('S', 1, 1, 2, 100.00),
       ('S', 3, 2, 5, 120.00);

SELECT *
FROM PessoasFisicas;

SELECT *
FROM PessoasJuridicas;

SELECT *
FROM Pessoas;

SELECT *
FROM produtos;

SELECT *
FROM usuarios;




