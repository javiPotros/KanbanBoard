/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.Tablero;
import entidades.Tarea;
import entidades.Usuario;
import interfaces.baseDAO;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

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
        try {
            if (tablero.getId() == null || tablero == null) {
                throw new IllegalArgumentException("El tablero no es valido");
            }
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Tablero tableroViejo = entityManager.find(Tablero.class, tablero.getId());
            if (tableroViejo == null) {
                throw new Exception("El tablero no existe");
            }
            tableroViejo.setNombre(tablero.getNombre());
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            return tablero;
        } catch (Exception e) {
            //REVISAR
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void eliminar(long idTablero) {
        System.out.println(idTablero);
        Long id = idTablero;
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Tablero tablero = entityManager.find(Tablero.class, id);
            if (tablero != null) {
                entityManager.remove(tablero);
            }
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se ha elimino correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | PersistenceException e) {
            JOptionPane.showMessageDialog(null, "Error: Este tablero no se pudo eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
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
