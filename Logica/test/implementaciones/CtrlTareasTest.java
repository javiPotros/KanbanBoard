/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import entidades.Tarea;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joshi
 */
public class CtrlTareasTest {
    
    public CtrlTareasTest() {
    }

    @Test
    public void testAgregar() throws Exception {
        System.out.println("agregar");
        Tarea tarea = null;
        CtrlTareas instance = new CtrlTareas();
        instance.agregar(tarea);
        fail("The test case is a prototype.");
    }

    @Test
    public void testActualizar() throws Exception {
        System.out.println("actualizar");
        Tarea tarea = null;
        CtrlTareas instance = new CtrlTareas();
        instance.actualizar(tarea);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        Long id = null;
        CtrlTareas instance = new CtrlTareas();
        instance.eliminar(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultar() {
        System.out.println("consultar");
        Long id = null;
        CtrlTareas instance = new CtrlTareas();
        Tarea expResult = null;
        Tarea result = instance.consultar(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarPorHacer() {
        System.out.println("consultarPorHacer");
        CtrlTareas instance = new CtrlTareas();
        List<Tarea> expResult = null;
        List<Tarea> result = instance.consultarPorHacer();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarEnProgeso() {
        System.out.println("consultarEnProgeso");
        CtrlTareas instance = new CtrlTareas();
        List<Tarea> expResult = null;
        List<Tarea> result = instance.consultarEnProgeso();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarRealizado() {
        System.out.println("consultarRealizado");
        CtrlTareas instance = new CtrlTareas();
        List<Tarea> expResult = null;
        List<Tarea> result = instance.consultarRealizado();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
