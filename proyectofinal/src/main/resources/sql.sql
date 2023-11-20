CREATE DATABASE IF NOT EXISTS remodelaciones_segura;

USE remodelaciones_segura;

CREATE TABLE IF NOT EXISTS citas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_cliente VARCHAR(255) NOT NULL,
    fecha_hora DATETIME NOT NULL,
    servicio VARCHAR(255) NOT NULL
);
