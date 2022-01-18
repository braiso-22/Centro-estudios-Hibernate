/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  brais.fernandezvazqu
 * Created: 11 ene 2022
 */

﻿use mysql;
create database centro_estudios;


use centro_estudios;
create table alumno(id int not null auto_increment,dni varchar(9) not null,nombre varchar(35) not null, apellidos varchar(35) not null, curso varchar(15) not null, fecha_nacimiento date not null, primary key(id));


create table profesor(id int not null auto_increment, dni varchar(9),nombre varchar(35), apellidos varchar(35), departamento varchar(40), sueldo decimal(15,2), primary key(id));


create table asignatura(codigo varchar(20), nombre varchar(35), primary key(codigo));


create table matricula(alumno int, profesor int, asignatura varchar(20), primary key (alumno, profesor, asignatura), foreign key (alumno) references alumno(id),
foreign key (profesor) references profesor(id),
foreign key (asignatura) references asignatura(codigo));

create or replace view alumno_con_asignatura as select a.dni, a.nombre, a.apellidos, a.curso, a.fecha_nacimiento, asi.nombre as asignatura from alumno as a inner join matricula as dc on a.dni = dc.alumno inner join asignatura as asi on dc.asignatura = asi.codigo;
create or replace view alumno_con_profesor as select a.dni, a.nombre, a.apellidos, a.curso, a.fecha_nacimiento, dc.profesor from alumno as a inner join matricula as dc on a.dni = dc.alumno;

create or replace view profesor_con_asignatura as select p.dni, p.nombre, p.apellidos, p.departamento, p.sueldo, asi.nombre as asignatura from profesor as p join matricula as dc on p.dni = dc.profesor inner join asignatura as asi on dc.asignatura = asi.codigo;
create or replace view profesor_con_alumno as select p.dni, p.nombre, p.apellidos, p.departamento, p.sueldo, dc.alumno from profesor as p join matricula as dc on p.dni = dc.profesor;

create or replace view asignatura_con_alumno as select asi.codigo, asi.nombre, dc.alumno from asignatura as asi join matricula as dc on asi.codigo = dc.asignatura;
create or replace view asignatura_con_profesor as select asi.codigo, asi.nombre, dc.profesor from asignatura as asi join matricula as dc on asi.codigo = dc.asignatura;

