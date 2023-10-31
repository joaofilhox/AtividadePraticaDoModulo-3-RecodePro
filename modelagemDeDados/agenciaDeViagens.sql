CREATE DATABASE agenciaDeViagens;

CREATE TABLE Cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nomeCliente VARCHAR(255),
    cpfCliente VARCHAR(11),
    enderecoCliente VARCHAR(255),
    telefoneCliente VARCHAR(15),
    emailCliente VARCHAR(255)
);

CREATE TABLE Pacotes_de_Interesse (
    idPacoteDeViagens INT AUTO_INCREMENT PRIMARY KEY,
    destinos VARCHAR(255),
    precos VARCHAR(255),  
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

CREATE TABLE Pagamentos (
    idPagamento INT AUTO_INCREMENT PRIMARY KEY,
    valorPago VARCHAR(255),  
    destinoPago VARCHAR(255),
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);
