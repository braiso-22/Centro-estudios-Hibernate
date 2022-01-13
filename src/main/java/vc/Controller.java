/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vc;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import service.AlumnoService;
import service.AsignaturaService;
import service.ProfesorService;
import vo.Alumno;
import vo.Asignatura;
import vo.Profesor;

/**
 *
 * @author brais.fernandezvazqu
 */
public class Controller {

    static View v = new View();
    static List<Alumno> alumnos;
    static List<Profesor> profesores;
    static List<Asignatura> asignaturas;

    static AlumnoService alumnoService = new AlumnoService();
    static ProfesorService profesorService = new ProfesorService();
    static AsignaturaService asignaturaService = new AsignaturaService();

    public static void main(String[] args) {

        v.showMessage("Cargando...");
        int opcion;

        do {

            int opcion2 = -1;
            String output;
            opcion = v.menuTablas();
            do {

                output = "";

                try {

                    //cada opcion del menu 1 llama a su menu menos en el caso 5
                    switch (opcion) {
                        case 1:
                            opcion2 = v.menuAlumno();
                            output += alumno(opcion2);
                            break;
                        case 2:
                            opcion2 = v.menuProfesor();
                            output += profesor(opcion2);
                            break;
                        case 3:
                            opcion2 = v.menuAsignatura();
                            output += asignatura(opcion2);
                            break;
                        /*case 4:
                            opcion2 = v.menuMatriculas();
                            output += matricula(opcion2, conn);
                            break;*/
                        case 5:

                            opcion2 = 0;
                            break;
                        case 0:
                            v.showMessage("Saliendo...");
                            break;
                        case -1:
                            opcion2 = 0;
                            break;
                        default:
                            v.showMessage("opcion no valida");
                            opcion2 = 0;
                            break;

                    }
                } catch (Exception e) {
                    v.showMessage("Error " + e.getMessage());
                    opcion2 = 0;
                }
                v.showMessage(output);
            } while (opcion2 != 0 && opcion != 0);

        } while (opcion != 0);

    }

    public static String alumno(int opcion) {

        switch (opcion) {
            case 1:
                alumnos = alumnoService.findAll();
                return alumnos.isEmpty() ? "No hay alumnos" : alumnos.stream().map(al -> al.toString()).reduce("", (string, str) -> string.concat(str));

            case 2:
                return proccesAlumnos("Introduce el id");

            case 3:
                String dni,
                 nombre,
                 apellido,
                 curso;
                LocalDate fecha;

                dni = v.showMessageString("Introduce el dni");
                nombre = v.showMessageString("Introduce el nombre");
                apellido = v.showMessageString("introduce los apellidos");
                curso = v.showMessageString("Introduce el curso");

                try {
                    fecha = LocalDate.parse(v.showMessageString("Introduce la fecha de nacimiento YYYY-MM-DD"));
                    alumnoService.persist(new Alumno(dni, nombre, apellido, curso, fecha));
                    return "Alumno añadido";
                } catch (DateTimeParseException dTPE) {
                    return String.format("No se pudo añadir el alumno, fecha mal formada(%s)\n", dTPE.getParsedString());
                } catch (Exception e) {
                    return "No se pudo añadir el alumno ".concat(e.getMessage());
                }

            case 4:
                int id = v.showMessageInt("Introduce el id del alumno a borrar");
                try {
                    alumnoService.delete(id);
                    return "Alumno eliminado";
                } catch (IllegalArgumentException iAE) {
                    return "No hay alumnos con ese id";
                } catch (Exception e) {
                    return "Error: " + e.getMessage();
                }

            case 5:
                int aleatorio = generarClave();
                int codigo = v.showMessageInt("Si quieres borrar todo introduce el siguiente codigo: " + aleatorio);
                alumnoService.deleteAll();
                return codigo == aleatorio ? "Todos borrados\n" : "No se han borrado los datos\n";

            /*case 3:
                output = proccesAlumnos("Introduce el nombre", AlumnoDAO.GETBYNOMBRE, conn);
                break;
            case 4:

                id = v.showMessageString("Introduce los apellidos");
                id = "%" + id + "%";
                alumnos = alumnoDAO.get(AlumnoDAO.GETBYAPELLIDO, id, conn);
                for (Alumno al : alumnos) {
                    output += al.toString();
                }
                break;
            case 5:
                output = proccesAlumnos("Introduce el curso", AlumnoDAO.GETBYCURSO, conn);
                break;
            case 6:
                output = proccesAlumnos("Introduce el año", AlumnoDAO.GETBYNACIMIENTO, conn);
                break;
            case 7:
                output = proccesAlumnos("Introduce el nombre de asignatura:", AlumnoDAO.GETBYASIGNATURA, conn);
                break;
            case 8:
                output = proccesAlumnos("Introduce el DNI del profesor:", AlumnoDAO.GETBYPROFESOR, conn);
                break;
            case 9:
                id = v.showMessageString("Introduce el archivo:");
                alumnoDAO.insertUsingFile(id, conn);
                break;
             */
 /*case 3:
                output = proccesAlumnos("Introduce el nombre", AlumnoDAO.GETBYNOMBRE, conn);
                break;
            case 4:

                id = v.showMessageString("Introduce los apellidos");
                id = "%" + id + "%";
                alumnos = alumnoDAO.get(AlumnoDAO.GETBYAPELLIDO, id, conn);
                for (Alumno al : alumnos) {
                    output += al.toString();
                }
                break;
            case 5:
                output = proccesAlumnos("Introduce el curso", AlumnoDAO.GETBYCURSO, conn);
                break;
            case 6:
                output = proccesAlumnos("Introduce el año", AlumnoDAO.GETBYNACIMIENTO, conn);
                break;
            case 7:
                output = proccesAlumnos("Introduce el nombre de asignatura:", AlumnoDAO.GETBYASIGNATURA, conn);
                break;
            case 8:
                output = proccesAlumnos("Introduce el DNI del profesor:", AlumnoDAO.GETBYPROFESOR, conn);
                break;
            case 9:
                id = v.showMessageString("Introduce el archivo:");
                alumnoDAO.insertUsingFile(id, conn);
                break;
             */
            case 0:
                return "";
            default:
                return "";

        }

    }

    private static int generarClave() {
        return (int) (Math.random() * 10000 + 90001);
    }

    private static String proccesAlumnos(String mensaje) {

        int id = v.showMessageInt(mensaje);
        try {
            alumnos.clear();
            alumnos.add(alumnoService.findById(id));
            return alumnos.stream().map(al -> al.toString()).reduce("", String::concat);
        } catch (NullPointerException nPE) {
            return "No hay alumnos con ese id";
        } catch (Exception e) {
            return "Error " + e.getMessage();
        }
    }

    private static String profesor(int opcion) {
        switch (opcion) {
            case 1:
                profesores = profesorService.findAll();
                return profesores.isEmpty() ? "No hay profesores" : profesores.stream().map(al -> al.toString()).reduce("", (string, str) -> string.concat(str));

            case 2:
                return processProfesores("Introduce el id");

            case 3:
                String dni,
                 nombre,
                 apellido,
                 departamento;
                float sueldo;

                dni = v.showMessageString("Introduce el dni");
                nombre = v.showMessageString("Introduce el nombre");
                apellido = v.showMessageString("introduce los apellidos");
                departamento = v.showMessageString("Introduce el departamento");

                try {
                    sueldo = Float.valueOf(v.showMessageString("Introduce el sueldo"));
                    profesorService.persist(new Profesor(dni, nombre, apellido, departamento, sueldo));
                    return "profesor añadido";
                } catch (NumberFormatException e) {
                    return "No se pudo añadir el profesor ".concat(e.getMessage());
                } catch (Exception e) {
                    return "Error: ".concat(e.getMessage());
                }

            case 4:
                int id = v.showMessageInt("Introduce el id del profesor a borrar");
                try {
                    profesorService.delete(id);
                    return "Profesor eliminado";
                } catch (IllegalArgumentException iAE) {
                    return "No hay profesores con ese id";
                } catch (Exception e) {
                    return "Error:".concat(e.getMessage());
                }

            case 5:
                int aleatorio = generarClave();
                int codigo = v.showMessageInt("Si quieres borrar todo introduce el siguiente codigo: " + aleatorio);

                profesorService.deleteAll();
                return codigo == aleatorio ? "Todos borrados\n" : "No se han borrado los datos\n";
            /*case 3:
                output = processProfesores("Introduce el nombre", ProfesorDAO.GETBYNOMBRE, conn);
                break;
            case 4:
                id = v.showMessageString("Introduce los apellidos");
                id = "%" + id + "%";
                profesores = profesorDAO.get(ProfesorDAO.GETBYAPELLIDO, id, conn);
                for (Profesor prof : profesores) {
                    output += prof.toString();
                }
                break;
            case 5:
                output = processProfesores("Introduce el departamento", ProfesorDAO.GETBYDEPARTAMENTO, conn);
                break;
            case 6:
                try {
                output = processProfesores("Introduce el sueldo", ProfesorDAO.GETBYSUELDO, conn);
            } catch (Exception e) {
                v.showMessage("Error " + e.getMessage());
            }
            break;
            case 7:
                output = processProfesores("Introduce la asignatura", ProfesorDAO.GETBYASIGNATURA, conn);
                break;
            case 8:
                output = processProfesores("Introduce el DNI del alumno", ProfesorDAO.GETBYALUMNO, conn);
                break;
            case 9:
                id = v.showMessageString("Introduce el archivo");
                profesorDAO.insertUsingFile(id, conn);
                break;*/
            case 0:
                return "";
            default:
                return "";

        }
    }

    private static String processProfesores(String mensaje) {

        int id = v.showMessageInt(mensaje);
        try {
            profesores.clear();
            profesores.add(profesorService.findById(id));
            return profesores.stream().map(prof -> prof.toString()).reduce("", String::concat);
        } catch (NullPointerException nPE) {
            return "No hay profesores con ese id";
        } catch (Exception e) {
            return "Error ".concat(e.getMessage());
        }

    }

    private static String asignatura(int opcion) {

        String id;
        switch (opcion) {
            case 1:
                asignaturas = asignaturaService.findAll();
                return asignaturas.isEmpty() ? "No hay asignaturas" : asignaturas.stream().map(al -> al.toString()).reduce("", (string, str) -> string.concat(str));

            case 2:
                return proccesAsignatura("Escribe el codigo");
            case 3:
                String codigo = v.showMessageString("introduce el codigo");
                String nombre = v.showMessageString("Introduce el nombre");
                try {
                    asignaturaService.persist(new Asignatura(codigo, nombre));
                    return "Asignatura añadida";
                } catch (Exception e) {
                    return "No se pudo añadir la asignatura ".concat(e.getMessage());
                }
            /*case 3:
                output = proccesAsignatura("Escribe el nombre", AsignaturaDAO.GETBYNOMBRE, conn);
                break;
            case 4:
                output = proccesAsignatura("Escribe el dni del alumno", AsignaturaDAO.GETBYALUMNO, conn);
                break;
            case 5:
                output = proccesAsignatura("Escribe el dni del profesor", AsignaturaDAO.GETBYPROFESOR, conn);
                break;
            case 6:
                id = v.showMessageString("Introduce el archivo");
                asignaturaDAO.insertUsingFile(id, conn);
                break;*/

            case 0:
                return "";
            default:
                return "";
        }
    }

    private static String proccesAsignatura(String mensaje) {
        String id = "";
        id = v.showMessageString(mensaje);
        asignaturas.add(asignaturaService.findById(id));
        id = asignaturas.stream().map(asig -> asig.toString()).reduce(id, String::concat);
        return id;
    }
    /*
    private static String matricula(int opcion, Connection conn) {
        String output = "";
        String id;
        switch (opcion) {
            case 1:
                matriculas = detalleClaseDAO.get(DetalleClaseDAO.GETALL, "", conn);
                for (DetalleClase matri : matriculas) {
                    output += matri;
                }
                break;
            case 2:
                id = v.showMessageString("Introduce el archivo");
                detalleClaseDAO.insertUsingFile(id, conn);
                break;
            case 3:
                String alumno = v.showMessageString("Introduce el dni del alumno");
                String profesor = v.showMessageString("Introduce el dni del profesor");
                String asignatura = v.showMessageString("Introduce el codigo de asignatura");
                detalleClaseDAO.add(new DetalleClase(alumno, profesor, asignatura), conn);
                break;
            default:
                break;
        }
        return output;
    }


     */
}
