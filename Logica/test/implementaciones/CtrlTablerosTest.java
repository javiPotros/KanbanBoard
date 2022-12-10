/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import entidades.Tablero;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joshi
 */
public class CtrlTablerosTest {
    
    public CtrlTablerosTest() {
    }

    @Test
    public void testAgregar() throws Exception {
        System.out.println("agregar");
        Tablero tablero = null;
        CtrlTableros instance = new CtrlTableros();
        instance.agregar(tablero);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarTodos() {
        System.out.println("consultarTodos");
        CtrlTableros instance = new CtrlTableros();
        List<Tablero> expResult = null;
        List<Tablero> result = instance.consultarTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
