-- Create a new database called 'AULA_SQL;'
CREATE DATABASE AULA_SQL;

DROP DATABASE AULA_SQL;

CREATE DATABASE DB_AULA25MAR24;

USE DB_AULA25MAR24;

CREATE TABLE IF NOT EXISTS Fornecedor(
    Fcodigo INT NOT NULL,
    Fnome VARCHAR(30) NOT NULL,
    Status INT,
    Cidade VARCHAR(30)
);

SELECT* FROM Fornecedor;

CREATE TABLE IF NOT EXISTS Departamento(
    Dcodigo INT NOT NULL,
    Dnome VARCHAR(30) NOT NULL,
    Status INT,
    Cidade VARCHAR(30),
    PRIMARY KEY (Dcodigo)
);

SELECT* FROM Departamento;

CREATE TABLE IF NOT EXISTS Empregado(
    Ecodigo INT NOT NULL,
    Enome VARCHAR(40) NOT NULL,
    CPF VARCHAR(17) NOT NULL,
    Salario DECIMAL(7,2),
    Dcodigo INT NOT NULL,
    PRIMARY KEY (Ecodigo, Enome)
);

SELECT* FROM Empregado;

--apagar tabela
DROP TABLE  Empregado;

--criação de tabela com FOREING TABLE
CREATE TABLE IF NOT EXISTS Empregado(
    Ecodigo INT NOT NULL,
    Enome VARCHAR(40) NOT NULL,
    CPF VARCHAR(17) NOT NULL,
    Salario DECIMAL(7,2),
    Dcodigo INT NOT NULL,
    PRIMARY KEY (Ecodigo, Enome),
    FOREIGN KEY (Dcodigo) REFERENCES Departamento
);

--exibir
SELECT* FROM Empregado;

--ALTERAR 

--add coluna (adicionar)
ALTER TABLE Empregado ADD sexo CHAR(1);

--add coluna (remover)
ALTER TABLE Empregado DROP sexo;

--Renomear Tabela
ALTER TABLE Empregado RENAME TO Funcionario;

--ALTER TABLE tabela ALTER COLUMN campo nome tipo_dado;
ALTER TABLE Fornecedor ALTER COLUMN Status TYPE ativo BOOLEAN;



