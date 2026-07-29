CREATE DATABASE IF NOT EXISTS biblioteca_java;
USE biblioteca_java;

CREATE TABLE IF NOT EXISTS livro (
	id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    genero VARCHAR(100) NOT NULL,
    idioma VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    preco INT NOT NULL
);