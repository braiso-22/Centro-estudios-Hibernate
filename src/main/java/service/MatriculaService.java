/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.MatriculaDAO;
import factory.DaoFactory;
import factory.SesionFactory;
import java.util.List;
import vo.Matricula;

/**
 *
 * @author brais.fernandezvazqu
 */
public class MatriculaService {

    private MatriculaDAO matriculaDao;
    private static SesionFactory sesionFactory;

    public MatriculaService() {
        matriculaDao = new DaoFactory().getMatriculaDao();
        sesionFactory = SesionFactory.getSesionFactory();
    }

    public void persist(Matricula entity) {
        sesionFactory.openCurrentSessionwithTransaction();
        matriculaDao.persist(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public void update(Matricula entity) {
        sesionFactory.openCurrentSessionwithTransaction();
        matriculaDao.update(entity, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public Matricula findById(int id1) {
        sesionFactory.openCurrentSession();
        Matricula matricula = (Matricula) matriculaDao.findById(id1, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return matricula;
    }

    public Matricula findById(int id, int id2, String id3) {
        sesionFactory.openCurrentSession();
        Matricula matricula = (Matricula) matriculaDao.findById(id, id2, id3, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return matricula;
    }

    public void delete(int id3) {
        sesionFactory.openCurrentSessionwithTransaction();
        Matricula matricula = (Matricula) matriculaDao.findById(id3, sesionFactory.getCurrentSession());
        matriculaDao.delete(matricula, sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }

    public List<Matricula> findAll() {
        sesionFactory.openCurrentSession();
        List<Matricula> matriculas = matriculaDao.findAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSession();
        return matriculas;
    }

    public void deleteAll() {
        sesionFactory.openCurrentSessionwithTransaction();
        matriculaDao.deleteAll(sesionFactory.getCurrentSession());
        sesionFactory.closeCurrentSessionwithTransaction();
    }
}
