CREATE TABLE usuario(
	id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nomeProprietario VARCHAR(500) NOT NULL,
    cpfProprietario VARCHAR (11) NOT NULL,
    nomeEmpresa VARCHAR(500) NOT NULL,
    email VARCHAR(500) NOT NULL,
    numeroCelular VARCHAR(14) NOT NULL,
    idade INT NOT NULL
);
