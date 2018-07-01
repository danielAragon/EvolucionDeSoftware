-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-05-05 21:02:13.126

-- tables
-- Table: Bus
CREATE TABLE Bus (
    Matricula nvarchar(8)  NOT NULL,
    Cant_Asiento int  NOT NULL,
    Nombre nvarchar(30)  NOT NULL,
    Linea char(1)  NOT NULL,
    Foto text  NULL,
    Ruta_ID bigint  NOT NULL,
    Fecha_Vehiculo datetime  NOT NULL,
    HP int  NOT NULL,
    Combustible int  NOT NULL,
    CONSTRAINT Bus_pk PRIMARY KEY  (Matricula)
);

-- Table: Bus_Paradero
CREATE TABLE Bus_Paradero (
    Bus_ID nvarchar(8)  NOT NULL,
    Paradero_ID bigint  NOT NULL,
    Fecha datetime  NOT NULL,
    Distancia float(4)  NOT NULL,
    CONSTRAINT Bus_Paradero_pk PRIMARY KEY  (Fecha)
);

-- Table: Cargo
CREATE TABLE Cargo (
    ID bigint  NOT NULL,
    Nombre nvarchar(30)  NOT NULL,
    Sueldo bigint  NOT NULL,
    CONSTRAINT Cargo_pk PRIMARY KEY  (ID)
);

-- Table: Color
CREATE TABLE Color (
    ID bigint  NOT NULL,
    Nombre nvarchar(30)  NOT NULL,
    Principal bit  NOT NULL,
    CONSTRAINT Color_pk PRIMARY KEY  (ID)
);

-- Table: Color_Bus
CREATE TABLE Color_Bus (
    Bus_ID nvarchar(8)  NOT NULL,
    Color_ID bigint  NOT NULL,
    CONSTRAINT Color_Bus_pk PRIMARY KEY  (Bus_ID)
);

-- Table: Distrito
CREATE TABLE Distrito (
    ID bigint  NOT NULL,
    Nombre nvarchar(30)  NOT NULL,
    CONSTRAINT Distrito_pk PRIMARY KEY  (ID)
);

-- Table: Estacion_Policial
CREATE TABLE Estacion_Policial (
    ID bigint  NOT NULL,
    Telefono numeric(7,9)  NOT NULL,
    Distrito_ID bigint  NOT NULL,
    CONSTRAINT Estacion_Policial_pk PRIMARY KEY  (ID)
);

-- Table: Estado_Del_Bus
CREATE TABLE Estado_Del_Bus (
    ID bigint  NOT NULL,
    Bus_ID nvarchar(8)  NOT NULL,
    Velocidad int  NOT NULL,
    Cant_Pasajeros int  NOT NULL,
    Fecha datetime  NOT NULL,
    Direccion nvarchar(50)  NOT NULL,
    Trabajador_ID bigint  NULL,
    TemperaturaMotor float(3)  NOT NULL,
    GasolinaDisponible int  NOT NULL,
    Bateria int  NOT NULL,
    Aceite bit  NOT NULL,
    CONSTRAINT Estado_Del_Bus_pk PRIMARY KEY  (ID,Fecha)
);

-- Table: Incidente
CREATE TABLE Incidente (
    ID bigint  NOT NULL,
    Descripcion text  NOT NULL,
    Prioridad int  NOT NULL,
    Bus_Matricula nvarchar(8)  NOT NULL,
    CONSTRAINT Incidente_pk PRIMARY KEY  (ID)
);

-- Table: OperadoraTarjeta
CREATE TABLE OperadoraTarjeta (
    ID bigint  NOT NULL,
    Nombre nvarchar(15)  NOT NULL,
    CONSTRAINT OperadoraTarjeta_pk PRIMARY KEY  (ID)
);

-- Table: Paradero
CREATE TABLE Paradero (
    ID bigint  NOT NULL,
    Calle text  NOT NULL,
    Provincia text  NOT NULL,
    Descripcion text  NOT NULL,
    Distrito double  NOT NULL,
    CONSTRAINT Paradero_pk PRIMARY KEY  (ID)
);

-- Table: Pasajero
CREATE TABLE Pasajero (
    PasajeroID bigint  NOT NULL,
    Fecha_Caducidad_Tarjeta date  NOT NULL,
    TieneSeguro bit  NOT NULL,
    SeguroDescripcion text  NOT NULL,
    CONSTRAINT Pasajero_pk PRIMARY KEY  (PasajeroID)
);

-- Table: Persona
CREATE TABLE Persona (
    ID bigint  NOT NULL,
    Nombre nvarchar(30)  NOT NULL,
    Apellido nvarchar(30)  NOT NULL,
    Celular bigint  NOT NULL,
    TelefonoFijo bigint  NULL,
    FechaNacimiento date  NOT NULL,
    Correo nvarchar(50)  NOT NULL,
    Direccion nvarchar(50)  NOT NULL,
    CONSTRAINT Persona_pk PRIMARY KEY  (ID)
);

-- Table: Recarga
CREATE TABLE Recarga (
    ID bigint  NOT NULL,
    TarjetaID int  NOT NULL,
    Monto double  NOT NULL,
    Fecha datetime  NOT NULL,
    TarjetaCredito_ID bigint  NOT NULL,
    TipoRecarga_ID int  NOT NULL,
    CONSTRAINT Recarga_pk PRIMARY KEY  (ID)
);

-- Table: Ruta
CREATE TABLE Ruta (
    ID bigint  NOT NULL,
    Nombre nvarchar(20)  NOT NULL,
    CONSTRAINT Ruta_pk PRIMARY KEY  (ID)
);

-- Table: Ruta_Paradero
CREATE TABLE Ruta_Paradero (
    Ruta_ID bigint  NOT NULL,
    Paradero_ID bigint  NOT NULL,
    CONSTRAINT Ruta_Paradero_pk PRIMARY KEY  (Ruta_ID,Paradero_ID)
);

-- Table: Tarjeta
CREATE TABLE Tarjeta (
    TarjetaID int  NOT NULL,
    Pasajeroid bigint  NULL,
    Saldo double  NOT NULL,
    CONSTRAINT Tarjeta_pk PRIMARY KEY  (TarjetaID)
);

-- Table: TarjetaCredito
CREATE TABLE TarjetaCredito (
    NumeroTarjeta bigint  NOT NULL,
    CodigoSeguridad int  NOT NULL,
    OperadoraTarjeta_ID bigint  NOT NULL,
    CONSTRAINT TarjetaCredito_pk PRIMARY KEY  (NumeroTarjeta)
);

-- Table: TipoRecarga
CREATE TABLE TipoRecarga (
    ID int  NOT NULL,
    Nombre nvarchar(15)  NOT NULL,
    Descripcion text  NOT NULL,
    CONSTRAINT TipoRecarga_pk PRIMARY KEY  (ID)
);

-- Table: Trabajador
CREATE TABLE Trabajador (
    ID bigint  NOT NULL,
    Fecha_Contratacion date  NOT NULL,
    Fecha_FinContrato date  NULL,
    Cargo_ID bigint  NOT NULL,
    ReportsTo bigint  NULL,
    CONSTRAINT Trabajador_pk PRIMARY KEY  (ID)
);

-- Table: Viaje
CREATE TABLE Viaje (
    ID bigint  NOT NULL,
    Bus_ID nvarchar(8)  NOT NULL,
    Fecha datetime  NOT NULL,
    Precio tinyint  NOT NULL,
    Tarjeta_ID int  NOT NULL,
    CONSTRAINT Viaje_pk PRIMARY KEY  (ID,Fecha)
);

-- foreign keys
-- Reference: Boleto_Tarjeta (table: Viaje)
ALTER TABLE Viaje ADD CONSTRAINT Boleto_Tarjeta
    FOREIGN KEY (Tarjeta_ID)
    REFERENCES Tarjeta (TarjetaID);

-- Reference: Bus_Paradero_Bus (table: Bus_Paradero)
ALTER TABLE Bus_Paradero ADD CONSTRAINT Bus_Paradero_Bus
    FOREIGN KEY (Bus_ID)
    REFERENCES Bus (Matricula);

-- Reference: Bus_Paradero_Paradero (table: Bus_Paradero)
ALTER TABLE Bus_Paradero ADD CONSTRAINT Bus_Paradero_Paradero
    FOREIGN KEY (Paradero_ID)
    REFERENCES Paradero (ID);

-- Reference: Bus_Ruta (table: Bus)
ALTER TABLE Bus ADD CONSTRAINT Bus_Ruta
    FOREIGN KEY (Ruta_ID)
    REFERENCES Ruta (ID);

-- Reference: Color_Bus_Bus (table: Color_Bus)
ALTER TABLE Color_Bus ADD CONSTRAINT Color_Bus_Bus
    FOREIGN KEY (Bus_ID)
    REFERENCES Bus (Matricula);

-- Reference: Color_Bus_Color (table: Color_Bus)
ALTER TABLE Color_Bus ADD CONSTRAINT Color_Bus_Color
    FOREIGN KEY (Color_ID)
    REFERENCES Color (ID);

-- Reference: Estacion_Policial_Distrito (table: Estacion_Policial)
ALTER TABLE Estacion_Policial ADD CONSTRAINT Estacion_Policial_Distrito
    FOREIGN KEY (Distrito_ID)
    REFERENCES Distrito (ID);

-- Reference: Estado_Del_Bus_Bus (table: Estado_Del_Bus)
ALTER TABLE Estado_Del_Bus ADD CONSTRAINT Estado_Del_Bus_Bus
    FOREIGN KEY (Bus_ID)
    REFERENCES Bus (Matricula);

-- Reference: Estado_Del_Bus_Trabajador (table: Estado_Del_Bus)
ALTER TABLE Estado_Del_Bus ADD CONSTRAINT Estado_Del_Bus_Trabajador
    FOREIGN KEY (Trabajador_ID)
    REFERENCES Trabajador (ID);

-- Reference: Incidente_Bus (table: Incidente)
ALTER TABLE Incidente ADD CONSTRAINT Incidente_Bus
    FOREIGN KEY (Bus_Matricula)
    REFERENCES Bus (Matricula);

-- Reference: Paradero_Distrito (table: Paradero)
ALTER TABLE Paradero ADD CONSTRAINT Paradero_Distrito
    FOREIGN KEY (Distrito)
    REFERENCES Distrito (ID);

-- Reference: Pasajero_Entidad (table: Pasajero)
ALTER TABLE Pasajero ADD CONSTRAINT Pasajero_Entidad
    FOREIGN KEY (PasajeroID)
    REFERENCES Persona (ID);

-- Reference: Recarga_Tarjeta (table: Recarga)
ALTER TABLE Recarga ADD CONSTRAINT Recarga_Tarjeta
    FOREIGN KEY (TarjetaID)
    REFERENCES Tarjeta (TarjetaID);

-- Reference: Recarga_TarjetaCredito (table: Recarga)
ALTER TABLE Recarga ADD CONSTRAINT Recarga_TarjetaCredito
    FOREIGN KEY (TarjetaCredito_ID)
    REFERENCES TarjetaCredito (NumeroTarjeta);

-- Reference: Recarga_TipoRecarga (table: Recarga)
ALTER TABLE Recarga ADD CONSTRAINT Recarga_TipoRecarga
    FOREIGN KEY (TipoRecarga_ID)
    REFERENCES TipoRecarga (ID);

-- Reference: Ruta_Paradero_Paradero (table: Ruta_Paradero)
ALTER TABLE Ruta_Paradero ADD CONSTRAINT Ruta_Paradero_Paradero
    FOREIGN KEY (Paradero_ID)
    REFERENCES Paradero (ID);

-- Reference: Ruta_Paradero_Ruta (table: Ruta_Paradero)
ALTER TABLE Ruta_Paradero ADD CONSTRAINT Ruta_Paradero_Ruta
    FOREIGN KEY (Ruta_ID)
    REFERENCES Ruta (ID);

-- Reference: Table_31_Pasajero (table: Tarjeta)
ALTER TABLE Tarjeta ADD CONSTRAINT Table_31_Pasajero
    FOREIGN KEY (Pasajeroid)
    REFERENCES Pasajero (PasajeroID);

-- Reference: TarjetaCredito_OperadoraTarjeta (table: TarjetaCredito)
ALTER TABLE TarjetaCredito ADD CONSTRAINT TarjetaCredito_OperadoraTarjeta
    FOREIGN KEY (OperadoraTarjeta_ID)
    REFERENCES OperadoraTarjeta (ID);

-- Reference: Trabajador_Cargo (table: Trabajador)
ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_Cargo
    FOREIGN KEY (Cargo_ID)
    REFERENCES Cargo (ID);

-- Reference: Trabajador_Entidad (table: Trabajador)
ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_Entidad
    FOREIGN KEY (ID)
    REFERENCES Persona (ID);

-- Reference: Trabajador_Trabajador (table: Trabajador)
ALTER TABLE Trabajador ADD CONSTRAINT Trabajador_Trabajador
    FOREIGN KEY (ReportsTo)
    REFERENCES Trabajador (ID);

-- Reference: Transporte_Bus (table: Viaje)
ALTER TABLE Viaje ADD CONSTRAINT Transporte_Bus
    FOREIGN KEY (Bus_ID)
    REFERENCES Bus (Matricula);

-- End of file.

