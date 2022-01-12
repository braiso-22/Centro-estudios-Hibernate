/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import org.hibernate.Session;
import vo.Alumno;

/**
 *
 * @author brais.fernandezvazqu
 */
public class AlumnoDAO implements DaoInterface<Alumno> {

    @Override
    public void persist(Alumno entity, Session session) {

        session.persist(entity);

    }

    @Override
    public void update(Alumno entity, Session session) {
        session.update(entity);
    }

    @Override
    public Alumno findById(int id, Session session) {

        return (Alumno) session.get(Alumno.class, id);

    }

    @Override
    public void delete(Alumno entity, Session session) {
        session.delete(entity);
    }

    @Override
    public List<Alumno> findAll(Session session) {
        return (List<Alumno>) session.createQuery("from Alumno").list();
    }

    @Override
    public void deleteAll(Session session) {
        List<Alumno> lista = findAll(session);
        for (Alumno alumno : lista) {
            delete(alumno, session);
        }
    }

}
