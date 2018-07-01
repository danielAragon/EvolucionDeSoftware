-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-05-23 17:32:08.562

-- tables
-- Table: Bus
CREATE TABLE Bus (
    Bus_ID nvarchar(8)  NOT NULL,
    Matricula nvarchar(8)  NOT NULL,
    Cant_Asiento int  NOT NULL,
    Fecha_Compra datetime  NOT NULL,
    Foto text  NULL,
    CONSTRAINT Bus_pk PRIMARY KEY  (Bus_ID)
);

-- Table: Bus_Ruta_Paradero
CREATE TABLE Bus_Ruta_Paradero (
    Bus_ID nvarchar(8)  NOT NULL,
    Fecha datetime  NOT NULL,
    Distancia float(4)  NOT NULL,
    Ruta_ID nvarchar(8)  NOT NULL,
    Paradero_ID nvarchar(8)  NOT NULL,
    CONSTRAINT Bus_Ruta_Paradero_pk PRIMARY KEY  (Fecha)
);

-- Table: Cargo
CREATE TABLE Cargo (
    Cargo_ID int  NOT NULL,
    Nombre nvarchar(30)  NOT NULL,
    Sueldo double  NOT NULL,
    CONSTRAINT Cargo_pk PRIMARY KEY  (Cargo_ID)
);

-- Table: Distrito
CREATE TABLE Distrito (
    Distrito_ID nvarchar(8)  NOT NULL,
    Nombre nvarchar(30)  NOT NULL,
    CONSTRAINT Distrito_pk PRIMARY KEY  (Distrito_ID)
);

-- Table: Estacion_Policial
CREATE TABLE Estacion_Policial (
    Estacion_ID int  NOT NULL,
    Telefono int  NOT NULL,
    Distrito_ID nvarchar(8)  NOT NULL,
    CONSTRAINT Estacion_Policial_pk PRIMARY KEY  (Estacion_ID)
);

-- Table: Estado_Bus
CREATE TABLE Estado_Bus (
    Estado_ID int  NOT NULL,
    Bus_ID nvarchar(8)  NOT NULL,
    Velocidad float  NOT NULL,
    Cant_Pasajeros int  NOT NULL,
    Fecha datetime  NOT NULL,
    Direccion nvarchar(50)  NOT NULL,
    Trabajador_ID int  NOT NULL,
    TemperaturaMotor float(3)  NULL,
    GasolinaDisponible int  NULL,
    Bateria int  NULL,
    CONSTRAINT Estado_Bus_pk PRIMARY KEY  (Estado_ID,Fecha)
);

-- Table: Incidente
CREATE TABLE Incidente (
    ID int  NOT NULL,
    Descripcion text  NOT NULL,
    Prioridad int  NOT NULL,
    Bus_ID int  NOT NULL,
    Fecha datetime  NOT NULL,
    CONSTRAINT Incidente_pk PRIMARY KEY  (ID)
);

-- Table: Paradero
CREATE TABLE Paradero (
    Paradero_ID nvarchar(8)  NOT NULL,
    Calle text  NOT NULL,
    Provincia text  NOT NULL,
    Descripcion text  NOT NULL,
    Distrito_ID nvarchar(8)  NOT NULL,
    CONSTRAINT Paradero_pk PRIMARY KEY  (Paradero_ID)
);

-- Table: Pasajero
CREATE TABLE Pasajero (
    Pasajero_ID int  NOT NULL,
    Fecha_Caducidad_Tarjeta date  NOT NULL,
    TieneSeguro bit  NOT NULL,
    SeguroDescripcion text  NOT NULL,
    CONSTRAINT Pasajero_pk PRIMARY KEY  (Pasajero_ID)
);

-- Table: Persona
CREATE TABLE Persona (
    Persona_ID int  NOT NULL,
    Nombre nvarchar(30)  NOT NULL,
    Apellido nvarchar(30)  NOT NULL,
    Celular int  NOT NULL,
    TelefonoFijo int  NULL,
    FechaNacimiento date  NOT NULL,
    Correo nvarchar(50)  NOT NULL,
    Direccion nvarchar(50)  NOT NULL,
    CONSTRAINT Persona_pk PRIMARY KEY  (Persona_ID)
);

-- Table: Recarga
CREATE TABLE Recarga (
    Recarga_ID int  NOT NULL,
    Tarjeta_ID int  NOT NULL,
    Monto double  NOT NULL,
    Fecha datetime  NOT NULL,
    TipoRecarga_ID int  NOT NULL,
    CONSTRAINT Recarga_pk PRIMARY KEY  (Recarga_ID)
);

-- Table: Ruta
CREATE TABLE Ruta (
    Ruta_ID nvarchar(8)  NOT NULL,
    Nombre nvarchar(20)  NOT NULL,
    CONSTRAINT Ruta_pk PRIMARY KEY  (Ruta_ID)
);

-- Table: Ruta_Paradero
CREATE TABLE Ruta_Paradero (
    Ruta_ID nvarchar(8)  NOT NULL,
    Paradero_ID nvarchar(8)  NOT NULL,
    CONSTRAINT Ruta_Paradero_pk PRIMARY KEY  (Ruta_ID,Paradero_ID)
);

-- Table: Tarjeta
CREATE TABLE Tarjeta (
    Tarjeta_ID int  NOT NULL,
    Pasajero_ID int  NULL,
    Saldo double  NOT NULL,
    CONSTRAINT Tarjeta_pk PRIMARY KEY  (Tarjeta_ID)
);

-- Table: TipoRecarga
CREATE TABLE TipoRecarga (
    TipoRecarga_ID int  NOT NULL,
    Nombre nvarchar(15)  NOT NULL,
    Descripcion text  NOT NULL,
    CONSTRAINT TipoRecarga_pk PRIMARY KEY  (TipoRecarga_ID)
);

-- Table: Trabajador
CREATE TABLE Trabajador (
    Trabajador_ID int  NOT NULL,
    Fecha_Contratacion date  NOT NULL,
    Fecha_FinContrato date  NULL,
    Cargo_ID int  NOT NULL,
    Reports_To int  NULL,
    CONSTRAINT Trabajador_pk PRIMARY KEY  (Trabajador_ID)
);

-- Table: Viaje
CREATE TABLE Viaje (
    Viaje_ID bigint  NOT NULL,
    Bus_ID nvarchar(8)  NOT NULL,
    Fecha datetime  NOT NULL,
    Precio double  NOT NULL,
    Tarjeta_ID int  NOT NULL,
    CONSTRAINT Viaje_pk PRIMARY KEY  (Viaje_ID,Fecha)
);

-- End of file.

