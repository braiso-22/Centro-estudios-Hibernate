/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author brais.fernandezvazqu
 * @param <T>
 */
public interface AlumnoDaoInterface<T> {

    public void persist(T entity, Session session);

    public void update(T entity, Session session);

    public T findById(int id, Session session);

    public void delete(T entity, Session session);

    public List<T> findAll(Session session);

    public void deleteAll(Session session);
}
