# Centro-estudios-Hibernate
Proyecto en el que se hace una base de datos para el centro y una aplicación que accede a los datos y los modifica
<!--https://docs.google.com/document/d/1DcK1GxR6Uccbla7L3Pi4PzJ1eG4iy5fiQ9_iqHW_fXY/edit?usp=sharing -->

<h2>Enunciado.</h2>
Vamos a diseñar una aplicación que se conecta a una base de datos y que tenga las siguientes características: 
<ol>
  <li>BD:</li>
Tenemos que diseñar un modelo E/R, modelo relacional y las tablas correspondientes para un modelo de datos muy simplificado de un centro de estudios. Tenemos alumnos (con la información básica esperada: dni, nombre, apellidos, fecha de nacimiento…) y profesores (también con la información necesaria). Los profesores pertenecen a un departamento e imparten asignaturas. Los alumnos atienden a las asignaturas. Documenta y justifica cualquier decisión que tomes sobre el diseño de la base de datos.
<li> Aplicación:</li>
Queremos una aplicación que se conecte a una base de datos y nos permita gestionar la base de datos anterior. Tiene que tener, por lo menos, la siguiente funcionalidad:
    <ul>
      <li>
 Crear las tablas e insertar información. 
</li>
   <li> 
Permitir recuperar información básica: 
     </li>
     <li>
 Todos los alumnos, los profesores, las asignaturas y los departamentos. 
       </li>
       <li>
         
 Todas las opciones que consideréis útiles para recuperar una fila de alumnos, profesores, asignaturas y departamento. Por ejemplo, recuperar alumno por dni, asignatura por código de asignatura, departamento por nombre… 
         </li>
         <li>
 Ofrecer funcionalidades básicas como: Todos los alumnos que asisten a una determinada asignatura, las asignaturas que imparte un profesor, los profesores que pertenecen a un departamento….
           
  
  </ol>
  <h2>Modelo E/R</h2>
 <img src="https://user-images.githubusercontent.com/81094589/141323030-e94a124b-054d-48a2-b7ab-3117174194fd.png">
Entiendo que se quiere saber qué profesor va a dar qué asignatura a qué alumno, y que cada asignatura puede ser impartida por varios profesores a la vez.
Considero que el departamento no necesita tabla ya que no aporta más información importante además de su nombre por lo que queda como atributo del profesor.

  <h2>Modelo relacional</h2>
<img src="https://user-images.githubusercontent.com/81094589/141324177-479487fe-56ef-4db4-9db5-cb4dd620acbb.png">
  La interrelación triple genera una nueva tabla que tiene como clave primaria las claves del resto de tablas.
  
  <h2>Creación de la DB</h2>
Código de creación: 
https://drive.google.com/file/d/1_ieqHbnwlNoHF6Cv-psoOiYTA-yOF5dn/view?usp=sharing 
