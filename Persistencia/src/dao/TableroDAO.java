/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Tablero;
import interfaces.baseDAO;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

/**
 *
 * @author jjavi
 */
public class TableroDAO extends baseDAO<Tablero> {

    @Override
    public Tablero agregar(Tablero tablero) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(tablero);
            entityManager.getTransaction().commit();
            return tablero;
        } catch (HeadlessException | PersistenceException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tablero actualizar(Tablero tablero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(long idTablero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Tablero consultar(long idTablero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tablero> consultarTodos() {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT t FROM Tablero t", Tablero.class);
            List<Tablero> listaTablero = query.getResultList();
            return listaTablero;
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
