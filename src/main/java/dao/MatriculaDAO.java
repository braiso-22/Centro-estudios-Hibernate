/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import vo.Matricula;

/**
 *
 * @author brais.fernandezvazqu
 */
public class MatriculaDAO implements DaoInterface {

    @Override
    public void persist(Object entity, Session session) {
        session.persist(entity);
    }

    @Override
    public void update(Object entity, Session session) {
        session.update(entity);
    }

    @Override
    public Object findById(int id, Session session) {
        return (Matricula) session.get(Matricula.class, id);
    }

    public Object findById(int id, int id2, String id3, Session session) {
        return (Matricula) session.get(Matricula.class, new Matricula(id, id2, id3));
    }

    @Override
    public void delete(Object entity, Session session) {
        session.delete(entity);
    }

    @Override
    public List findAll(Session session) {
        return (List<Matricula>) session.createQuery("from Matricula").list();
    }

    @Override
    public void deleteAll(Session session) {
        List<Matricula> lista = findAll(session);
        for (Matricula alumno : lista) {
            delete(alumno, session);
        }
    }

}
