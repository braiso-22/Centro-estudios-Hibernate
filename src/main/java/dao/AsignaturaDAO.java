/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import vo.Asignatura;

/**
 *
 * @author brais.fernandezvazqu
 */
public class AsignaturaDAO implements DaoInterface<Asignatura> {

    @Override
    public void persist(Asignatura entity, Session session) {
        session.persist(entity);
    }

    @Override
    public void update(Asignatura entity, Session session) {
        session.update(entity);
    }

    @Override
    public Asignatura findById(int id, Session session) {
        return (Asignatura) session.get(Asignatura.class, id);
    }

    public Asignatura findById(String id, Session session) {
        return (Asignatura) session.get(Asignatura.class, id);
    }

    @Override
    public void delete(Asignatura entity, Session session) {
        session.delete(entity);
    }

    @Override
    public List<Asignatura> findAll(Session session) {
        return (List<Asignatura>) session.createQuery("from asignatura").list();
    }

    @Override
    public void deleteAll(Session session) {
        List<Asignatura> lista = findAll(session);
        for (Asignatura alumno : lista) {
            delete(alumno, session);
        }
    }
}
