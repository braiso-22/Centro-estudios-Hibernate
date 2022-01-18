/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import dao.AlumnoDAO;
import dao.AsignaturaDAO;
import dao.MatriculaDAO;
import dao.ProfesorDAO;

/**
 *
 * @author brais.fernandezvazqu
 */
public class DaoFactory {

    public DaoFactory() {
        super();
    }

    public AlumnoDAO getAlumnoDao() {
        return new AlumnoDAO();
    }

    public ProfesorDAO getProfesorDao() {
        return new ProfesorDAO();
    }

    public AsignaturaDAO getAsignaturaDao() {
        return new AsignaturaDAO();
    }

    public MatriculaDAO getMatriculaDao() {
        return new MatriculaDAO();
    }
}
