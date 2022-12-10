/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementaciones;

import entidades.Usuario;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joshi
 */
public class CtrlUsuariosTest {
    
    public CtrlUsuariosTest() {
    }

    @Test
    public void testAgregar() throws Exception {
        System.out.println("agregar");
        Usuario usuario = null;
        CtrlUsuarios instance = new CtrlUsuarios();
        Usuario expResult = null;
        Usuario result = instance.agregar(usuario);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        long id = 0L;
        CtrlUsuarios instance = new CtrlUsuarios();
        instance.eliminar(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testActualizar() throws Exception {
        System.out.println("actualizar");
        Usuario usuario = null;
        CtrlUsuarios instance = new CtrlUsuarios();
        instance.actualizar(usuario);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultar() {
        System.out.println("consultar");
        Long id = null;
        CtrlUsuarios instance = new CtrlUsuarios();
        Usuario expResult = null;
        Usuario result = instance.consultar(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarPorCorreo() {
        System.out.println("consultarPorCorreo");
        String correo = "";
        CtrlUsuarios instance = new CtrlUsuarios();
        Usuario expResult = null;
        Usuario result = instance.consultarPorCorreo(correo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarPorCorreoYContrasenha() throws Exception {
        System.out.println("consultarPorCorreoYContrasenha");
        String correo = "";
        String contrasenha = "";
        CtrlUsuarios instance = new CtrlUsuarios();
        Usuario expResult = null;
        Usuario result = instance.consultarPorCorreoYContrasenha(correo, contrasenha);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarTodos() {
        System.out.println("consultarTodos");
        CtrlUsuarios instance = new CtrlUsuarios();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.consultarTodos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testConsultarRoles() {
        System.out.println("consultarRoles");
        CtrlUsuarios instance = new CtrlUsuarios();
        List<String> expResult = null;
        List<String> result = instance.consultarRoles();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
