
-- DROP SCHEMA IF EXISTS bd_farmacia2017;
-- CREATE SCHEMA bd_farmacia2017;
-- USE bd_farmacia2017;

CREATE TABLE IF NOT EXISTS Laboratorio (
  IdLaboratorio   SMALLINT UNSIGNED AUTO_INCREMENT,
  Nombre          VARCHAR(64) UNIQUE NOT NULL,
  PRIMARY KEY (IdLaboratorio));
  
INSERT INTO Laboratorio (Nombre) VALUES 
('Bayer'),
('Baxter'),
('Esel'),
('Lilly'),
('IQ Farma'),
('Tecno Farma'),
('Nexus');

SELECT * FROM Laboratorio;

CREATE TABLE IF NOT EXISTS Categoria (
  IdCategoria     SMALLINT UNSIGNED AUTO_INCREMENT,
  Nombre          VARCHAR(24) UNIQUE NOT NULL,
  PRIMARY KEY (IdCategoria));
  
INSERT INTO Categoria (Nombre) VALUES 
('Analgésicos'),
('Antiinflamatorios'),
('Aines'),
('Antibióticos'),
('Amoxicilina'),
('Cefalosporina'),
('Eritromicina'),
('Quinolona'),
('Ampicilina'),
('Vancomicina'),
('Azitromicina'),
('Penicilinas');

SELECT * FROM Categoria;

CREATE TABLE IF NOT EXISTS Cargo (
  IdCargo         TINYINT UNSIGNED AUTO_INCREMENT,
  Nombre          VARCHAR(24) NOT NULL,
  PRIMARY KEY (IdCargo));

INSERT INTO Cargo (Nombre) VALUES 
('Cajero'),
('Vendedor'),
('Administrador'),
('Almacenero');

SELECT * FROM Cargo;

CREATE TABLE IF NOT EXISTS Cliente (
  IdCliente       SMALLINT UNSIGNED AUTO_INCREMENT,
  Nombre          VARCHAR(24) NOT NULL,
  PrimerApellido  VARCHAR(24) NOT NULL,
  SegundoApellido VARCHAR(24) NOT NULL,
  DNI			  CHAR(8) NOT NULL,
  FechaRegistro   DATETIME DEFAULT CURRENT_TIMESTAMP,
  Sexo            ENUM('M','F'),
  PRIMARY KEY (IdCliente));
  
INSERT INTO Cliente (Nombre, PrimerApellido, SegundoApellido, DNI, Sexo) VALUES 
('Renato','Beltrán','Suarez','37459678','M'),
('Emilio','Pino','Beltrán','37485902','M'),
('Estrella','Ramírez','Loza','27485037','F'),
('Luis','Morales','Durán','36475865','M'),
('Katia','Ruíz','Vásques','384957346','F'),
('Judith','Paredes','Armando','99999999','F'),
('Hector','Chafloque','Tirado','11111111','M'),
('Mauricio','Huamán','Garcia','22222222','M');
  
SELECT * FROM Cliente;

CREATE TABLE IF NOT EXISTS Empleado (
  IdEmpleado      SMALLINT UNSIGNED AUTO_INCREMENT,
  Nombre          VARCHAR(24) NOT NULL,
  PrimerApellido  VARCHAR(24) NOT NULL,
  SegundoApellido VARCHAR(24) NOT NULL,
  FechaNacimiento DATE NOT NULL,
  FechaIngreso    DATETIME DEFAULT CURRENT_TIMESTAMP,
  Usuario         VARCHAR(16) NOT NULL,
  Clave           VARCHAR(32) NOT NULL,
  IdCargo         TINYINT UNSIGNED NOT NULL,
  Telefono        CHAR(9) NULL,
  PRIMARY KEY (IdEmpleado),
  CONSTRAINT FK_Empleado_Cargo FOREIGN KEY (IdCargo) REFERENCES Cargo (IdCargo),
  INDEX FK_Empleado_Cargo_Idx (IdCargo ASC));  
  -- Alterando el campo de clave para el md5
  ALTER TABLE bd_farmacia2017.empleado MODIFY COLUMN Clave varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ;

INSERT INTO Empleado (Nombre, PrimerApellido, SegundoApellido, FechaNacimiento, Usuario, Clave, IdCargo, Telefono) VALUES 
('Lucia','Rojas','Torres','1995-06-09','luciapacheco','pass123',2,'991212077'),
('Luis','Sánchez','Díaz','1994-08-10','luissanchez','pass123',3,'991212077'),
('Mercedes','Garcia','Espinoza','1990-01-28','mercedesgarcia','pass123',2,'991212077'),
('Raúl','Castro','López','1988-01-18','raullopez','pass123',4,'991212077'),
('Wendy','Vargas','Salazar','1992-02-29','wendyvargas','pass123',1,'991212077');

SELECT * FROM Empleado;

CREATE TABLE IF NOT EXISTS Producto (
  IdProducto      INT UNSIGNED AUTO_INCREMENT,
  Nombre          VARCHAR(64) NOT NULL,
  Precio          DECIMAL(5,2) NOT NULL,
  Stock           MEDIUMINT UNSIGNED NOT NULL,
  IdCategoria     SMALLINT UNSIGNED NOT NULL,
  IdLaboratorio   SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (IdProducto),
  CONSTRAINT FK_Producto_Laboratorio FOREIGN KEY (IdLaboratorio) REFERENCES Laboratorio (IdLaboratorio),
  CONSTRAINT FK_Producto_Categoria FOREIGN KEY (IdCategoria) REFERENCES Categoria (IdCategoria),
  INDEX FK_Producto_Laboratorio_Idx (IdLaboratorio ASC),
  INDEX FK_Producto_Categoria_Idx (IdCategoria ASC));
  
INSERT INTO Producto (Nombre, Precio, Stock, IdCategoria, IdLaboratorio) VALUES 
('Asgesic 10mg',2,80,11,5),
('Asgesic 20mg',3.5,95,11,1),
('Asgesic 30mg',5,74,7,2),
('Asgesic 60mg',8.5,65,12,4),
('Dolalgial',3,76,9,5),
('Naclodil',5,43,8,6),
('Dolostop 20mg',6,54,10,6),
('Aspirina',1,99,7,1),
('Cafiaspirina',1,65,5,3),
('Dolpiret cmp',2,54,5,3),
('Dolpiret ssp',3,64,4,3),
('Dontoflamon cmp',2.5,3,10,3),
('Dontoflamon ssp',3.5,5,10,3),
('Ibuflamar',6.5,75,1,2),
('Piredol',5,48,1,1),
('Flamadin',3,46,2,1),
('Diprofen cmp',6,84,2,2),
('Diprofen ssp',7.5,46,1,1),
('Ibupronal forte',10,64,4,1),
('Ceflex 200mg',4.5,76,8,4);

SELECT * FROM Producto;

CREATE TABLE IF NOT EXISTS OrdenVenta (
  IdOrdenVenta    INT UNSIGNED AUTO_INCREMENT,
  FechaOrden      DATETIME DEFAULT CURRENT_TIMESTAMP,
  FechaPago		  DATETIME,
  Estado		  INT DEFAULT 0,	
  IdCliente		  SMALLINT UNSIGNED NOT NULL,
  IdEmpleado 	  SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (IdOrdenVenta),
  CONSTRAINT FK_OrdenVenta_Cliente FOREIGN KEY (IdCliente) REFERENCES Cliente (IdCliente),
  CONSTRAINT FK_OrdenVenta_Empleado FOREIGN KEY (IdEmpleado) REFERENCES Empleado (IdEmpleado),
  INDEX FK_OrdenVenta_Cliente_Idx (IdCliente ASC),
  
  INDEX FK_OrdenVenta_Empleado_Idx (IdEmpleado ASC));

CREATE TABLE IF NOT EXISTS DetalleVenta (
  IdOrdenVenta    INT UNSIGNED NOT NULL,
  IdProducto      INT UNSIGNED NOT NULL,
  Cantidad        INT UNSIGNED NOT NULL,
  Monto           DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (IdProducto, IdOrdenVenta),
  CONSTRAINT FK_DetalleVenta_OrdenVenta FOREIGN KEY (IdOrdenVenta) REFERENCES OrdenVenta (IdOrdenVenta),
  CONSTRAINT FK_DetalleVenta_Producto FOREIGN KEY (IdProducto) REFERENCES Producto (IdProducto),  
  INDEX FK_DetalleVenta_Producto_Idx (IdProducto ASC));

-- Datos orden Venta
select * from producto;
insert into ordenventa values(null,'2017-12-01',null,1,2,4); 
insert into ordenventa values(null,'2017-12-06',null,1,1,2); 
insert into ordenventa values(null,'2017-12-05',null,1,5,5); 
insert into ordenventa values(null,'2017-12-08',null,1,3,3); 
-- Datos detalle Venta
insert into detalleventa values(1,10,79,158.0);
insert into detalleventa values(1,19,98,980.0);
insert into detalleventa values(1,7,139,834.0);
insert into detalleventa values(3,13,50,135.0);
insert into detalleventa values(3,15,120,600.0);
insert into detalleventa values(3,20,30,135.0);
insert into detalleventa values(2,5,29,145.0);
insert into detalleventa values(2,12,79,197.5);
insert into detalleventa values(4,10,54,108.0);
insert into detalleventa values(4,14,790,5135.0);
