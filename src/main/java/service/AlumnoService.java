/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.AlumnoDAO;
import factory.DaoFactory;
import factory.SesionFactory;
import java.util.List;
import vo.Alumno;

/**
 *
 * @author brais.fernandezvazqu
 */
public class AlumnoService {

    private AlumnoDAO alumnoDao;
    private static SesionFactory sesionFactory;

    public AlumnoService() {
        alumnoDao = new DaoFactory().getAlumnoDao();
        sesionFactory = SesionFactory.getSesionFactory();
    }

    public void persist(Alumno entity) {
        sesionFactory.openCurrentSessionwithTransaction();
        alumnoDao.persist(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public void update(Alumno entity) {
        sesionFactory.openCurrentSessionwithTransaction();
        alumnoDao.update(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public Alumno findById(int id1) {
        sesionFactory.openCurrentSession();
        Alumno alumno = alumnoDao.findById(id1, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return alumno;
    }

    public void delete(int id3) {
        sesionFactory.openCurrentSessionwithTransaction();
        Alumno alumno = alumnoDao.findById(id3, sesionFactory.getCurrentSession());
        alumnoDao.delete(alumno, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public List<Alumno> findAll() {
        sesionFactory.openCurrentSession();
        List<Alumno> alumnos = alumnoDao.findAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return alumnos;
    }

    public void deleteAll() {
        sesionFactory.openCurrentSessionwithTransaction();
        alumnoDao.deleteAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }
}
