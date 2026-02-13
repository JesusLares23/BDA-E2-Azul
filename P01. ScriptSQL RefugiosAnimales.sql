DROP DATABASE IF EXISTS RefugiosAnimales;
CREATE DATABASE IF NOT EXISTS RefugiosAnimales;

USE refugiosAnimales;

CREATE TABLE Voluntarios (
  id_voluntario int primary key auto_increment,
  nombre varchar(100) not null,
  edad int not null,
  especialidad varchar(20) not null,
  correo varchar(50) not null,
  telefono varchar(20) not null
);

CREATE TABLE Refugios (
  id_refugio int primary key auto_increment,
  nombre varchar(50) not null,
  ubicacion point not null,
  nombre_responsable varchar(100) not null
);

CREATE TABLE Animales (
  id_animal int primary key auto_increment,
  nombre varchar(30) not null,
  especie varchar(30) not null,
  edad int not null,
  fecha_ingreso datetime not null,
  id_refugio int not null,
  
  foreign key (id_refugio) references Refugios(id_refugio)
);

CREATE TABLE Tareas (
  id_tarea int primary key auto_increment,
  fecha datetime not null,
  actividad varchar(50) not null,
  id_voluntario int not null,
  id_animal int not null,
  id_refugio int not null,
  
  foreign key(id_voluntario) references Voluntarios(id_voluntario),
  foreign key(id_animal) references Animales(id_animal),
  foreign key(id_refugio) references Refugios(id_refugio)
);









