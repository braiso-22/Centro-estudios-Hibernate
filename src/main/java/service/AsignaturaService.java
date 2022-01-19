/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.AsignaturaDAO;
import factory.DaoFactory;
import factory.SesionFactory;
import java.util.List;
import vo.Asignatura;

/**
 *
 * @author brais.fernandezvazqu
 */
public class AsignaturaService {

    private AsignaturaDAO asignaturaDao;
    private static SesionFactory sesionFactory;

    public AsignaturaService() {
        asignaturaDao = new DaoFactory().getAsignaturaDao();
        sesionFactory = SesionFactory.getSesionFactory();
    }

    public void persist(Asignatura entity) {
        sesionFactory.openCurrentSessionwithTransaction();
        asignaturaDao.persist(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public void update(Asignatura entity) {
        sesionFactory.openCurrentSessionwithTransaction();
        asignaturaDao.update(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public Asignatura findById(String id1) {
        sesionFactory.openCurrentSession();
        Asignatura asignatura = (Asignatura) asignaturaDao.findById(id1, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return asignatura;
    }

    public void delete(String id3) {
        sesionFactory.openCurrentSessionwithTransaction();
        Asignatura asignatura = (Asignatura) asignaturaDao.findById(id3, sesionFactory.getCurrentSession());
        asignaturaDao.delete(asignatura, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public List<Asignatura> findAll() {
        sesionFactory.openCurrentSession();
        List<Asignatura> asignaturas = asignaturaDao.findAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return asignaturas;
    }

    public void deleteAll() {
        sesionFactory.openCurrentSessionwithTransaction();
        asignaturaDao.deleteAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }
}
