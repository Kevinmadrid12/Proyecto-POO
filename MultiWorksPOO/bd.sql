-- Crear la base de datos
CREATE DATABASE MultiWorksGroup;
USE MultiWorksGroup;

-- Tabla para el módulo de Clientes
CREATE TABLE Clientes (
    ID_Cliente INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    DocumentoIdentificacion VARCHAR(20) UNIQUE NOT NULL,
    TipoPersona ENUM('Natural', 'Jurídica') NOT NULL,
    Telefono VARCHAR(15),
    Correo VARCHAR(100),
    Direccion VARCHAR(200),
    Estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
    CreadoPor VARCHAR(100) NOT NULL,
    FechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FechaActualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FechaInactivacion TIMESTAMP
);

-- Tabla para el módulo de Empleados
CREATE TABLE Empleados (
    ID_Empleado INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(100) NOT NULL,
    DocumentoIdentificacion VARCHAR(20) UNIQUE NOT NULL,
    TipoPersona ENUM('Natural', 'Jurídica') NOT NULL,
    TipoContratacion ENUM('Permanente', 'Por Horas') NOT NULL,
    Telefono VARCHAR(15),
    Correo VARCHAR(100),
    Direccion VARCHAR(200),
    Estado ENUM('Activo', 'Inactivo') DEFAULT 'Activo',
    CreadoPor VARCHAR(100) NOT NULL,
    FechaCreacion DATETIME,
    FechaActualizacion DATETIME,
    FechaInactivacion DATETIME
);

-- Tabla para el módulo de Cotizaciones
CREATE TABLE Cotizaciones (
    ID_Cotizacion INT PRIMARY KEY AUTO_INCREMENT,
    ID_Cliente INT NOT NULL,
    Estado ENUM('En proceso', 'Finalizada') DEFAULT 'En proceso',
    CostosAdicionales DECIMAL(10, 2) DEFAULT 0,
    FechaCreacion DATETIME,
    FechaFinalizacion DATETIME,
    FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente)
);

-- Tabla para las actividades de las cotizaciones
CREATE TABLE Actividades (
    ID_Actividad INT PRIMARY KEY AUTO_INCREMENT,
    ID_Cotizacion INT NOT NULL,
    Titulo VARCHAR(200) NOT NULL,
    ID_Empleado INT NOT NULL,
    AreaAsignada VARCHAR(100) NOT NULL,
    CostoPorHora DECIMAL(10, 2) NOT NULL,
    FechaInicio DATETIME NOT NULL,
    FechaFin DATETIME NOT NULL,
    HorasEstimadas INT NOT NULL,
    IncrementoExtra DECIMAL(5, 2) DEFAULT 0,
    FOREIGN KEY (ID_Cotizacion) REFERENCES Cotizaciones(ID_Cotizacion),
    FOREIGN KEY (ID_Empleado) REFERENCES Empleados(ID_Empleado)
);

-- Tabla para las subtareas de las actividades
CREATE TABLE Subtareas (
    ID_Subtarea INT PRIMARY KEY AUTO_INCREMENT,
    ID_Actividad INT NOT NULL,
    Titulo VARCHAR(200) NOT NULL,
    Descripcion TEXT,
    FOREIGN KEY (ID_Actividad) REFERENCES Actividades(ID_Actividad)
);