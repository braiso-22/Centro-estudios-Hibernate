package vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author brais.fernandezvazqu
 */
@Entity
@Table(name = "Alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dni", nullable = false)
    private String dni;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(name = "curso", nullable = false)
    private String curso;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "Alumno", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Matricula> matriculas;

    public Alumno() {
        super();
    }

    public Alumno(int id, String dni, String nombre, String apellidos, String curso, LocalDate fechaNacimiento) {
        super();
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Alumno(String dni, String nombre, String apellidos, String curso, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCodigo() {
        return id;
    }

    public void setCodigo(int codigo) {
        this.id = codigo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Set<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "id:" + id + ", dni:" + dni + ", nombre:" + nombre + ", apellidos:" + apellidos + ", curso:" + curso + ", fechaNacimiento:" + fechaNacimiento + "\n";
    }

}
