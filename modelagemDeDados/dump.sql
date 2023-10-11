CREATE DATABASE agenciaDeViagem;

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY,
    nomeCliente VARCHAR(255),
    cpfCliente VARCHAR(11),
    enderecoCliente VARCHAR(255),
    telefoneCliente VARCHAR(15),
    emailCliente VARCHAR(255)
);

CREATE TABLE Pacotes_de_Interesse (
    idPacodeDeViagens INT PRIMARY KEY,
    destinos VARCHAR(255),
    precos DECIMAL(10, 2),
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

CREATE TABLE Pagamentos (
    idPagamento INT PRIMARY KEY,
    valorPago DECIMAL(10, 2),
    destinoPago VARCHAR(255),
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

