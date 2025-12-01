CREATE DATABASE `my_eshop` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;

-- BORRAR TABLAS SI EXISTEN

USE my_eshop;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS linea_compra;
DROP TABLE IF EXISTS compra;
DROP TABLE IF EXISTS articulo;
DROP TABLE IF EXISTS info_fiscal;
DROP TABLE IF EXISTS persona;

SET FOREIGN_KEY_CHECKS=1;

-- TABLA PERSONA

CREATE TABLE persona (
    nifcif char(10) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL default '',
    telefono VARCHAR(20),
    email VARCHAR(150) UNIQUE NOT NULL default '',
    fecha_registro DATE NOT NULL
);

-- TABLA INFO_FISCAL (1:1 CON PERSONA)

CREATE TABLE info_fiscal (
    nifcif char(10) PRIMARY KEY,
    dni VARCHAR(15) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    ciudad VARCHAR(100),
    provincia VARCHAR(100),
    cp VARCHAR(10),
    FOREIGN KEY (nifcif) REFERENCES persona(nifcif)
    	on update cascade
        ON DELETE CASCADE
);

-- TABLA ARTICULO (YA SIN IVA)

CREATE TABLE articulo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL default '',
    precio_base DECIMAL(10,2) NOT NULL default 0.00,
    descripcion VARCHAR(255)
);

-- TABLA COMPRA (N:1 CON PERSONA)

CREATE TABLE compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME NOT NULL,
    importe_total DECIMAL(10,2) NOT NULL default 0.00,
    escritor char(10) not null default '',
    foreign key (escritor) references persona(nifcif)
    	on update cascade on delete SET default
);

-- TABLA LINEA_COMPRA (N:1 CON COMPRA, N:1 CON ARTICULO)

CREATE TABLE linea_compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    compra_id INT NOT NULL,
    articulo_id INT NOT NULL,
    unidades INT NOT NULL default 0 check (unidades >= 0),
    precio_unitario DECIMAL(10,2) NOT NULL default 0.00,

    FOREIGN KEY (compra_id) REFERENCES compra(id)
        ON DELETE restrict,

    FOREIGN KEY (articulo_id) REFERENCES articulo(id)
        ON DELETE RESTRICT
);

FLUSH TABLES;

INSERT INTO my_eshop.persona
(nifcif, nombre, telefono, email, fecha_registro)
VALUES('', '', NULL, '', now());

INSERT INTO my_eshop.info_fiscal
(nifcif, dni, direccion, ciudad, provincia, cp)
VALUES('', '', '', NULL, NULL, NULL);

commit;