/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vc;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import service.AlumnoService;
import service.AsignaturaService;
import service.MatriculaService;
import service.ProfesorService;
import vo.Alumno;
import vo.Asignatura;
import vo.Matricula;
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
    static List<Matricula> matriculas;

    static AlumnoService alumnoService = new AlumnoService();
    static ProfesorService profesorService = new ProfesorService();
    static AsignaturaService asignaturaService = new AsignaturaService();
    static MatriculaService matriculaService = new MatriculaService();

    public static void main(String[] args) {

        v.showMessage("Cargando...");
        alumnos = new ArrayList<>();
        profesores = new ArrayList<>();
        asignaturas = new ArrayList<>();
        matriculas = new ArrayList<>();

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
                        case 4:
                            opcion2 = v.menuMatriculas();
                            output += matricula(opcion2);
                            break;
                        /*case 5:

                            opcion2 = 0;
                            break;*/
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

        } while (opcion
                != 0);

    }

    private static int generarClave() {
        return (int) (Math.random() * 10000 + 90001);
    }

    public static String alumno(int opcion) {
        int id;
        switch (opcion) {
            case 1:
                alumnos = alumnoService.findAll();
                return alumnos.isEmpty() ? "No hay alumnos" : alumnos.stream().map(al -> al.toString()).reduce("", (string, str) -> string.concat(str));

            case 2:
                id = v.showMessageInt("Introduce el id del alumno");
                try {
                    return alumnoService.findById(id).toString();
                } catch (NullPointerException nPE) {
                    return "No hay alumnos con ese id\n";
                } catch (Exception e) {
                    return "Error ".concat(e.getMessage().concat("\n"));
                }

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
                id = v.showMessageInt("Introduce el id del alumno a borrar");
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
                if (codigo == aleatorio) {
                    alumnoService.deleteAll();
                    return "Todos borrados\n";
                }

                return "No se han borrado los datos\n";
            case 0:
                return "";
            default:
                return "";

        }

    }

    private static String profesor(int opcion) {
        int id;
        switch (opcion) {
            case 1:
                profesores = profesorService.findAll();
                return profesores.isEmpty() ? "No hay profesores" : profesores.stream().map(al -> al.toString()).reduce("", (string, str) -> string.concat(str));

            case 2:
                id = v.showMessageInt("Introduce el id del profesor");
                try {
                    return profesorService.findById(id).toString();
                } catch (NullPointerException nPE) {
                    return "No hay profesores con ese id\n";
                } catch (Exception e) {
                    return "Error ".concat(e.getMessage().concat("\n"));
                }

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
                id = v.showMessageInt("Introduce el id del profesor a borrar");
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
                if (codigo == aleatorio) {
                    profesorService.deleteAll();
                    return "Todos borrados\n";
                }
                return "No se han borrado los datos\n";
            case 0:
                return "";
            default:
                return "";

        }
    }

    private static String asignatura(int opcion) {
        String id;
        switch (opcion) {
            case 1:
                asignaturas = asignaturaService.findAll();
                return asignaturas.isEmpty() ? "No hay asignaturas" : asignaturas.stream().map(al -> al.toString()).reduce("", (string, str) -> string.concat(str));

            case 2:
                try {
                id = v.showMessageString("Escribe el codigo");
                return asignaturaService.findById(id).toString();
            } catch (NullPointerException nPE) {
                return "No hay asignaturas con ese codigo\n";
            } catch (Exception e) {
                return "Error ".concat(e.getMessage().concat("\n"));
            }

            case 3:
                id = v.showMessageString("introduce el codigo");
                String nombre = v.showMessageString("Introduce el nombre");
                try {
                    asignaturaService.persist(new Asignatura(id, nombre));
                    return "Asignatura añadida";
                } catch (Exception e) {
                    return "No se pudo añadir la asignatura ".concat(e.getMessage());
                }
            case 4:
                id = v.showMessageString("Introduce el código");
                try {
                    asignaturaService.delete(id);
                    return "Asignatura eliminada";
                } catch (IllegalArgumentException iAE) {
                    return "No hay asignaturas con ese codigo";
                } catch (Exception e) {
                    return "Error:".concat(e.getMessage());
                }

            case 5:
                int aleatorio = generarClave();
                int codigo = v.showMessageInt("Si quieres borrar todo introduce el siguiente codigo: " + aleatorio);
                if (codigo == aleatorio) {
                    asignaturaService.deleteAll();
                    return "Todos borrados\n";
                }
                return "No se han borrado los datos\n";

            case 0:
                return "";
            default:
                return "";
        }
    }

    private static String matricula(int opcion) {
        String output = "";
        int alumno, profesor;
        String asignatura;
        switch (opcion) {
            case 1:
                matriculas = matriculaService.findAll();
                return matriculas.isEmpty() ? "No hay matriculas" : matriculas.stream().map(al -> al.toString()).reduce("", String::concat);
            case 2:
                alumno = v.showMessageInt("Introduce el id del alumno");
                profesor = v.showMessageInt("Introduce el id del profesor");
                asignatura = v.showMessageString("Introduce el codigo de asignatura");

                matriculaService.persist(new Matricula(alumno, profesor, asignatura));
                break;
            case 3:
                int idA = v.showMessageInt("introduce el id de alumno");
                int idP = v.showMessageInt("Introduce el id de profesor");
                String idAsi = v.showMessageString("Introduce el codigo de asignatura");

                try {
                    return matriculaService.findById(idA, idP, idAsi).toString();
                } catch (NullPointerException nPE) {
                    return "No hay matriculas con esos datos\n";
                } catch (Exception e) {
                    return "Error ".concat(e.getMessage().concat("\n"));
                }
            case 4:
                idA = v.showMessageInt("introduce el id de alumno");
                idP = v.showMessageInt("Introduce el id de profesor");
                idAsi = v.showMessageString("Introduce el codigo de asignatura");

                try {
                    matriculaService.delete(idA, idP, idAsi);
                    return "Asignatura eliminada";
                } catch (IllegalArgumentException iAE) {
                    return "No hay asignaturas con ese codigo";
                } catch (Exception e) {
                    return "Error:".concat(e.getMessage());
                }
            case 5:
                int aleatorio = generarClave();
                int codigo = v.showMessageInt("Si quieres borrar todo introduce el siguiente codigo: " + aleatorio);
                if (codigo == aleatorio) {
                    matriculaService.deleteAll();
                    return "Todos borrados\n";
                }
                return "No se han borrado los datos\n";

            default:
                break;
        }
        return output;
    }
}
