package vo;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 *
 * @author brais.fernandezvazqu
 */
@Entity
@Table(name = "STUDENT")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;
    @Column(name = "dni",nullable = false)
    private String dni;
    @Column(name = "nombre",nullable = false)
    private String nombre;
    @Column(name = "apellidos",nullable = false)
    private String apellidos;
    @Column(name = "curso",nullable = false)
    private String curso;
    @Column(name = "fecha_nacimiento",nullable = false)
    private LocalDate fechaNacimiento;
}
