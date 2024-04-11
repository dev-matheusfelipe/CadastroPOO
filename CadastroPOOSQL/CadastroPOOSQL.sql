-- CREATE DATABASE CadastroPOOSQL;
-- USE CadastroPOOSQL;
CREATE TABLE Usuarios (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Nome NVARCHAR(100) NOT NULL,
    Username NVARCHAR(50) NOT NULL,
    Senha NVARCHAR(50) NOT NULL
);
-- Tabela de Produtos
CREATE TABLE Produtos (
    ProdutoID INT PRIMARY KEY AUTO_INCREMENT,
    Nome NVARCHAR(100) NOT NULL,
    Quantidade INT NOT NULL,
    PrecoVenda DECIMAL(10, 2) NOT NULL
);
CREATE TABLE Pessoas (
    PessoaID INT PRIMARY KEY AUTO_INCREMENT,
    Nome NVARCHAR(100) NOT NULL,
    Endereco NVARCHAR(255),
    Email NVARCHAR(100),
    Telefone NVARCHAR(20)
);
CREATE TABLE PessoasFisicas (
    PessoaID INT PRIMARY KEY,
    CPF NVARCHAR(14) NOT NULL,
    FOREIGN KEY (PessoaID) REFERENCES Pessoas(PessoaID)
);
CREATE TABLE PessoasJuridicas (
    PessoaID INT PRIMARY KEY,
    CNPJ NVARCHAR(18) NOT NULL,
    FOREIGN KEY (PessoaID) REFERENCES Pessoas(PessoaID)
);
CREATE TABLE Compras (
    CompraID INT PRIMARY KEY AUTO_INCREMENT,
    ProdutoID INT,
    PessoaJuridicaID INT,
    Quantidade INT NOT NULL,
    PrecoUnitario DECIMAL(10, 2) NOT NULL,
    DataCompra DATE,
    FOREIGN KEY (ProdutoID) REFERENCES Produtos(ProdutoID),
    FOREIGN KEY (PessoaJuridicaID) REFERENCES PessoasJuridicas(PessoaID)
);
CREATE TABLE Vendas (
    VendaID INT PRIMARY KEY AUTO_INCREMENT,
    ProdutoID INT,
    PessoaFisicaID INT,
    Quantidade INT NOT NULL,
    PrecoUnitario DECIMAL(10, 2) NOT NULL,
    DataVenda DATE,
    FOREIGN KEY (ProdutoID) REFERENCES Produtos(ProdutoID),
    FOREIGN KEY (PessoaFisicaID) REFERENCES PessoasFisicas(PessoaID)
);



