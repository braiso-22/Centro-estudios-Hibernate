/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ProfesorDAO;
import dao.ProfesorDAO;
import factory.DaoFactory;
import factory.SesionFactory;
import java.util.List;
import vo.Profesor;

/**
 *
 * @author brais.fernandezvazqu
 */
public class ProfesorService {

    private ProfesorDAO profesorDao;
    private static SesionFactory sesionFactory;

    public ProfesorService() {
        profesorDao = new DaoFactory().getProfesorDao();
        sesionFactory = SesionFactory.getSesionFactory();
    }

    public void persist(Profesor entity) {
        sesionFactory.openCurrentSessionwithTransaction();
        profesorDao.persist(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public void update(Profesor entity) {
        sesionFactory.openCurrentSessionwithTransaction();
        profesorDao.update(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public Profesor findById(int id1) {
        sesionFactory.openCurrentSession();
        Profesor profesor = (Profesor) profesorDao.findById(id1, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return profesor;
    }

    public void delete(int id3) {
        sesionFactory.openCurrentSessionwithTransaction();
        Profesor profesor = (Profesor) profesorDao.findById(id3, sesionFactory.getCurrentSession());
        profesorDao.delete(profesor, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public List<Profesor> findAll() {
        sesionFactory.openCurrentSession();
        List<Profesor> profesors = profesorDao.findAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return profesors;
    }

    public void deleteAll() {
        sesionFactory.openCurrentSessionwithTransaction();
        profesorDao.deleteAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }
}
