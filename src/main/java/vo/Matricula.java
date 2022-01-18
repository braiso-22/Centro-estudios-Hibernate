/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author brais.fernandezvazqu
 */
@Entity
@IdClass(Matricula.class)
@Table(name = "Matricula")
public class Matricula implements Serializable {

    @Id
    private int Alumno;
    @Id
    private int Profesor;
    @Id
    private String Asignatura;

    public Matricula() {

    }

    public Matricula(int Alumno, int Profesor, String Asignatura) {
        this.Alumno = Alumno;
        this.Profesor = Profesor;
        this.Asignatura = Asignatura;
    }

    /**
     * Get the value of Asignatura
     *
     * @return the value of Asignatura
     */
    public String getAsignatura() {
        return Asignatura;
    }

    /**
     * Set the value of Asignatura
     *
     * @param Asignatura new value of Asignatura
     */
    public void setAsignatura(String Asignatura) {
        this.Asignatura = Asignatura;
    }

    /**
     * Get the value of Profesor
     *
     * @return the value of Profesor
     */
    public int getProfesor() {
        return Profesor;
    }

    /**
     * Set the value of Profesor
     *
     * @param Profesor new value of Profesor
     */
    public void setProfesor(int Profesor) {
        this.Profesor = Profesor;
    }

    /**
     * Get the value of Alumno
     *
     * @return the value of Alumno
     */
    public int getAlumno() {
        return Alumno;
    }

    /**
     * Set the value of Alumno
     *
     * @param Alumno new value of Alumno
     */
    public void setAlumno(int Alumno) {
        this.Alumno = Alumno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Matricula other = (Matricula) obj;
        if (this.Alumno != other.Alumno) {
            return false;
        }
        if (this.Profesor != other.Profesor) {
            return false;
        }
        return Objects.equals(this.Asignatura, other.Asignatura);
    }

    @Override
    public String toString() {
        return "Alumno:" + Alumno + ", Profesor:" + Profesor + ", Asignatura:" + Asignatura + "\n";
    }

}
