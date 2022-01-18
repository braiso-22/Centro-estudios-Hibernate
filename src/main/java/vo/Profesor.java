/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author brais.fernandezvazqu
 */
@Entity
@Table(name = "Profesor")
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dni", nullable = false)
    private String dni;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidos", nullable = false)
    private String apellidos;
    @Column(name = "departamento", nullable = false)
    private String departamento;
    @Column(name = "sueldo", nullable = false)
    private float sueldo;

    @OneToMany(mappedBy = "Profesor", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Matricula> matriculas;

    public Profesor() {
    }

    public Profesor(String dni, String nombre, String apellidos, String departamento, float sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.sueldo = sueldo;
    }

    public Profesor(int id, String dni, String nombre, String apellidos, String departamento, float sueldo) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.sueldo = sueldo;
    }

    /**
     * Get the value of sueldo
     *
     * @return the value of sueldo
     */
    public float getSueldo() {
        return sueldo;
    }

    /**
     * Set the value of sueldo
     *
     * @param sueldo new value of sueldo
     */
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Get the value of departamento
     *
     * @return the value of departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Set the value of departamento
     *
     * @param departamento new value of departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Get the value of apellidos
     *
     * @return the value of apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Set the value of apellidos
     *
     * @param apellidos new value of apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of dni
     *
     * @return the value of dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Set the value of dni
     *
     * @param dni new value of dni
     */
    public void setDni(String dni) {
        this.dni = dni;
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
    public String toString() {
        return "id:" + id + ", dni:" + dni + ", nombre:" + nombre + ", apellidos:" + apellidos + ", departamento=" + departamento + ", sueldo=" + sueldo + "\n";
    }

}
