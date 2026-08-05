-- TecnoMarket S.A.S. - Laboratorio SENA CRUD

CREATE DATABASE IF NOT EXISTS tecnomarket_db;
USE tecnomarket_db;

DROP TABLE IF EXISTS productos;

CREATE TABLE productos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  codigo VARCHAR(20) NOT NULL UNIQUE,
  nombre VARCHAR(120) NOT NULL,
  categoria VARCHAR(80) NOT NULL,
  precio DECIMAL(12, 2) NOT NULL,
  cantidad INT NOT NULL
);


