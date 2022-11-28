/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import entidades.Tarea;
import entidades.Usuario;
import excepciones.DAOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego
 */
public class TareaDAOTest {

    Date fecha;

    public TareaDAOTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 30);
        Date fecha = cal.getTime();
        this.fecha = fecha;
    }

//    @Test
//    public void testAgregar() {
//        System.out.println("agregar");
//        Tarea tarea = new Tarea("TareaTest", "DescripcionTest", fecha, new Usuario(1L), 0);
//        TareaDAO instance = new TareaDAO();
//        instance.agregar(tarea);
//    }
    @Test(expected = DAOException.class)
    public void testAgregarException() {
        System.out.println("agregar Exception");
        Tarea tarea = new Tarea();
        TareaDAO instance = new TareaDAO();
        instance.agregar(tarea);
    }

//    @Test
//    public void testActualizar() {
//        System.out.println("actualizar");
//        Tarea tarea = new Tarea(12L, "TareaTest", "DescripcionTest", fecha, new Usuario(1L), 0);
//        TareaDAO instance = new TareaDAO();
//        instance.actualizar(tarea);
//    }
    @Test(expected = Exception.class)
    public void testActualizarException() {
        System.out.println("actualizar Exception");
        Tarea tarea = new Tarea();
        TareaDAO instance = new TareaDAO();
        instance.actualizar(tarea);
    }

//    @Test
//    public void testEliminar() {
//        System.out.println("eliminar");
//        long id = 13L;
//        TareaDAO instance = new TareaDAO();
//        instance.eliminar(id);
//    }
    
    @Test(expected = Exception.class)
    public void testEliminarException() {
        System.out.println("eliminar Exception");
        long id = -1;
        TareaDAO instance = new TareaDAO();
        instance.eliminar(id);
    }

    @Test
    public void testConsultar() {
        System.out.println("consultar");
        long id = 1L;
        TareaDAO instance = new TareaDAO();
        Tarea expResult = new Tarea(1L);
        Tarea result = instance.consultar(id);
        assertEquals(expResult, result);
    }

    @Test(expected = Exception.class)
    public void testConsultarException() {
        System.out.println("consultar Exception");
        long id = -1L;
        TareaDAO instance = new TareaDAO();
        instance.consultar(id);
    }


    @Test
    public void testConsultarTodos() {
        System.out.println("consultarTodos");
        TareaDAO instance = new TareaDAO();
        List<Tarea> tareasConsultadas = instance.consultarTodos();
        assertNotNull(tareasConsultadas);
    }
    

    @Test
    public void testConsultarPorHacer() {
        System.out.println("consultarPorHacer");
        TareaDAO instance = new TareaDAO();
        List<Tarea> tareasConsultadas = instance.consultarPorHacer();
        assertNotNull(tareasConsultadas);
    }

    @Test
    public void testConsultarEnProgreso() {
        System.out.println("consultarEnProgreso");
        TareaDAO instance = new TareaDAO();
        List<Tarea> tareasConsultadas = instance.consultarEnProgreso();
        assertNotNull(tareasConsultadas);
    }

    @Test
    public void testConsultarRealizado() {
        System.out.println("consultarRealizado");
        TareaDAO instance = new TareaDAO();
        List<Tarea> tareasConsultadas = instance.consultarRealizado();
        assertNotNull(tareasConsultadas);
    }
}
