/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import entidades.Comentario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joshi
 */
public class CtrlComentarioTest {
    
    public CtrlComentarioTest() {
    }

    @Test
    public void testAgregar() throws Exception {
        System.out.println("agregar");
        Comentario comentario = null;
        CtrlComentario instance = new CtrlComentario();
        instance.agregar(comentario);
        fail("The test case is a prototype.");
    }

    @Test
    public void testValidarMensaje() throws Exception {
        System.out.println("validarMensaje");
        String mensaje = "";
        CtrlComentario instance = new CtrlComentario();
        instance.validarMensaje(mensaje);
        fail("The test case is a prototype.");
    }
    
}
