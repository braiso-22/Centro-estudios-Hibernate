/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import vo.Profesor;

/**
 *
 * @author brais.fernandezvazqu
 */
public class ProfesorDAO implements DaoInterface {

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
        return (Profesor) session.get(Profesor.class, id);
    }

    @Override
    public void delete(Object entity, Session session) {
        session.delete(entity);
    }

    @Override
    public List findAll(Session session) {
        return (List<Profesor>) session.createQuery("from Profesor").list();
    }

    @Override
    public void deleteAll(Session session) {
        List<Profesor> lista = findAll(session);
        for (Profesor alumno : lista) {
            delete(alumno, session);
        }
    }

}
