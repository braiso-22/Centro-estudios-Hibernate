/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vc;

import java.util.Scanner;

/**
 *
 * @author brais.fernandezvazqu
 */
public class View {

    private Scanner teclado = new Scanner(System.in);

    public boolean showMessage(String message) {
        System.out.println(message);
        return true;
    }

    public String showMessageString(String message) {
        System.out.println(message);
        return teclado.nextLine();
    }

    public int showMessageInt(String message) {
        System.out.println(message);
        return leerInt();
    }

    public int menuTablas() {

        System.out.println("Selecciona una opcion:");
        System.out.println("1.- Alumnos");
        System.out.println("2.- Profesores");
        System.out.println("3.- Asignaturas");
        System.out.println("4.- Matriculas");
        //System.out.println("5.- Cargar datos antiguos");
        System.out.println("0.- Salir");

        return leerInt();
    }

    public int menuAlumno() {
        System.out.println("Selecciona una opcion:");
        System.out.println("01.- Ver todos los alumnos");
        System.out.println("02.- Buscar alumno por id");
        System.out.println("03.- Insertar alumno a mano");
        System.out.println("04.- Eliminar un alumno");
        System.out.println("05.- Eliminar todos los alumnos");
        /*System.out.println("03.- Ver alumnos buscando por nombre");
        System.out.println("04.- Ver alumnos buscando por apellido");
        System.out.println("05.- Ver alumnos buscando por curso");
        System.out.println("06.- Ver alumnos por año de nacimiento");
        System.out.println("07.- Ver alumnos por asignatura");
        System.out.println("08.- Ver alumnos por profesor");
        System.out.println("09.- Insertar alumnos por archivo");*/

        System.out.println("0.- Volver");
        return leerInt();
    }

    public int menuProfesor() {
        System.out.println("Selecciona una opcion:");
        System.out.println("01.- Ver todos los profesores");
        System.out.println("02.- Buscar profesor por id");
        System.out.println("03.-Insertar profesores a mano");
        System.out.println("04.- Eliminar un profesor");
        System.out.println("05.- Eliminar todos los profesores");
        /*System.out.println("03.- Ver profesores buscando por nombre");
        System.out.println("04.- Ver profesores buscando por apellido");
        System.out.println("05.- Ver profesores buscando por departamento");
        System.out.println("06.- Ver profesores buscando por sueldo"
                + " mayor al introducido");
        System.out.println("07.- Ver profesores buscando por asignatura");
        System.out.println("08.- Ver profesores por alumno");
        System.out.println("09.- Insertar profesores por archivo");*/
        System.out.println("0.- Volver");
        return leerInt();
    }

    public int menuAsignatura() {
        System.out.println("Selecciona una opcion:");
        System.out.println("1.- Ver todas las asignaturas");
        System.out.println("2.- Buscar asignaturas por codigo");
        System.out.println("3.- Insertar asignaturas a mano");
        System.out.println("4.- Eliminar una asignatura");
        System.out.println("5.- Eliminar todas las asignaturas");
        /*System.out.println("3.- Buscar asignaturas por nombre");
        System.out.println("4.- Ver asignaturas buscando por alumno");
        System.out.println("5.- Ver asignaturas buscando por profesor");
        System.out.println("6.- Insertar asignaturas por archivo");*/
        System.out.println("0.- Volver");
        return leerInt();
    }

    public int menuMatriculas() {
        System.out.println("Selecciona una opcion:");
        System.out.println("1.- Ver todas las matriculas");
        System.out.println("2.- Añadir matricula a mano");
        System.out.println("3.- Eliminar una matricula");
        System.out.println("4.- Eliminar todas las matriculas");
        //System.out.println("2.- Añadir matriculas por archivo");
        System.out.println("0.- Volver");
        return leerInt();
    }

    private int leerInt() {
        try {
            int opcion = Integer.parseInt(teclado.nextLine());
            return opcion;
        } catch (NumberFormatException e) {
            System.out.println("Dato no valido " + e.getMessage());
            teclado = new Scanner(System.in);
        }
        return -1;
    }

}
