drop schema if exists remodelaciones;
drop user if exists usuario_prueba;
CREATE SCHEMA remodelaciones ;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario_prueba'@'%' identified by 'Usuar1o_Clave.';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
GRANT ALL PRIVILEGES ON remodelaciones.* TO 'usuario_prueba'@'%';
FLUSH PRIVILEGES;


/*Se crea la tabla de clientes llamada cliente... igual que la clase Cliente */
CREATE TABLE remodelaciones.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  telefono VARCHAR(15) NULL,
  ruta_imagen varchar(1024),
  activo boolean,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

/*Se insertan 3 registros en la tabla cliente como ejemplo */
INSERT INTO remodelaciones.usuario (id_usuario, username,password,nombre, apellidos, correo, telefono,ruta_imagen,activo) VALUES 
(1,'admin','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Juan', 'Castro Mora',    'jcastro@gmail.com',    '4556-8978', 'https://upload.wikimedia.org/wikipedia/commons/thumb/2/2a/Juan_Diego_Madrigal.jpg/250px-Juan_Diego_Madrigal.jpg',true),
(2,'cliente','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','Rebeca',  'Contreras Mora', 'acontreras@gmail.com', '5456-8789','https://upload.wikimedia.org/wikipedia/commons/0/06/Photo_of_Rebeca_Arthur.jpg',true);


create table remodelaciones.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into remodelaciones.rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1), (2,'ROLE_USER',1);
 
 -- Crear la tabla de servicios
CREATE TABLE remodelaciones.servicio (
  id_servicio INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  descripcion TEXT,
  precio DECIMAL(10, 2) NOT NULL,
  ruta_imagen VARCHAR(255),
  activo BOOLEAN,
  PRIMARY KEY (id_servicio)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- Insertar algunos servicios de ejemplo
INSERT INTO remodelaciones.servicio (nombre, descripcion, precio, ruta_imagen, activo)
VALUES
('Construcción y Remodelación de Viviendas', 'Construcción de viviendas desde cero, remodelaciones de interiores y exteriores, ampliaciones y renovaciones de casas.', 5000.00, 'img/construccion.jpg', true),
('Techos y Estructuras', 'Instalación, reparación y mantenimiento de techos, diseño y construcción de estructuras personalizadas, cambio de aleros, precintas y canoas.', 3000.00, 'img/techorojo.jpg', true),
('Plomería y Tuberías', 'Resolución de problemas de tuberías y desagües, instalación y mantenimiento de sistemas de plomería, reparación de fugas y problemas de fontanería.', 1500.00, 'img/tuberias.jpg', true),
('Portones Eléctricos y Mantenimiento', 'Instalación y mantenimiento de portones eléctricos, reparación y ajuste de motores, automatización de accesos.', 2000.00, 'img/54436500_1424057357777013_338533522748735488_n.jpg', true),
('Sistemas de Seguridad y Cámaras', 'Diseño e instalación de sistemas de seguridad, cámaras de vigilancia, monitoreo remoto.', 2500.00, 'img/5.jpg', true),
('Canoas y Bajantes', 'Reparación y limpieza de canoas y bajantes, instalación de sistemas de drenaje pluvial.', 1200.00, 'img/construccion_1.jpg', true),
('Hojalatería', 'Trabajos de hojalatería, fabricación e instalación de láminas metálicas, reparación de estructuras metálicas.', 1800.00, 'img/casa colonial.jpg', true),
('Diseño y Consultoría', 'Servicios de diseño arquitectónico, asesoría y consultoría en proyectos de construcción y remodelación.', 3000.00, 'img/villa de lujo.jpg', true);

-- Crear una tabla de relación entre usuario y servicio para controlar qué usuario puede modificar o añadir servicios
CREATE TABLE remodelaciones.usuario_servicio (
  id_usuario_servicio INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  id_servicio INT NOT NULL,
  es_admin BOOLEAN,
  PRIMARY KEY (id_usuario_servicio),
  FOREIGN KEY (id_usuario) REFERENCES remodelaciones.usuario(id_usuario),
  FOREIGN KEY (id_servicio) REFERENCES remodelaciones.servicio(id_servicio)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- Agregar la tabla cita
CREATE TABLE remodelaciones.agendar (
  id_agendar INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(50) NOT NULL,
  descripcion TEXT,
  fecha DATE NOT NULL,
  activo BOOLEAN NOT NULL,
  PRIMARY KEY (id_agendar)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

-- Insertar algunas citas de ejemplo
INSERT INTO remodelaciones.agendar (nombre, descripcion, fecha, activo)
VALUES
('Sara Perez', 'Servicio de Remodelacion de Vivienda', '2023-12-15', true),
('Johan Castro', 'Servicio de Hojalateria', '2023-12-20', true),
('Sofia Araya', 'Servicio de Tuberia', '2023-12-25', true);


