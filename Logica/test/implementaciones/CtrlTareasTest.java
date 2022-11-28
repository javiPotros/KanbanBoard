package implementaciones;

import entidades.Tarea;
import excepciones.DAOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class CtrlTareasTest {

    Date fecha;

    public CtrlTareasTest() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2022);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        Date fecha = cal.getTime();
        this.fecha = fecha;
    }

    @Test
    public void testAgregar() {
        Tarea tarea = new Tarea("Título", "", fecha);
        validarCampos(tarea);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarTitulo() {
        //Tarea sin título
        Tarea tarea = new Tarea("", "", fecha);

        //Título con 100 caracteres
//        Tarea tarea = new Tarea("                                                                                                    ",
//                 "",
//                 fecha);
        validarCampos(tarea);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarDescripcion() {
        //Descripción con 100 caracteres
        Tarea tarea = new Tarea("Título",
                "                                                    "
                + "                                                   ", fecha);
        validarCampos(tarea);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarFecha() {
        //Fecha null
//        Tarea tarea = new Tarea("Título", "", null);

        //Fecha con fecha pasada
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2021);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 10);
        Date fecha = cal.getTime();
        Tarea tarea = new Tarea("Título", "", fecha);
        validarCampos(tarea);
    }

//    @Test
//    public void testConsultar() {
//        System.out.println("consultar");
//        Long id = null;
//        CtrlTareas instance = new CtrlTareas();
//        Tarea expResult = null;
//        Tarea result = instance.consultar(id);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testConsultarPorHacer() {
//        System.out.println("consultarPorHacer");
//        CtrlTareas instance = new CtrlTareas();
//        List<Tarea> expResult = null;
//        List<Tarea> result = instance.consultarPorHacer();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testConsultarEnProgeso() {
//        System.out.println("consultarEnProgeso");
//        CtrlTareas instance = new CtrlTareas();
//        List<Tarea> expResult = null;
//        List<Tarea> result = instance.consultarEnProgeso();
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testConsultarRealizado() {
//        System.out.println("consultarRealizado");
//        CtrlTareas instance = new CtrlTareas();
//        List<Tarea> expResult = null;
//        List<Tarea> result = instance.consultarRealizado();
//        assertEquals(expResult, result);
//    }

    private void validarCampos(Tarea tarea) throws DAOException {
        validarTitulo(tarea.getTitulo());
        validarDescripcion(tarea.getDescripcion());
        validarFecha(tarea.getFechaLim());
    }

    private void validarTitulo(String titulo) throws IllegalArgumentException {
        if (titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Introduzca un título");
        } else if (titulo.length() > 100) {
            throw new IllegalArgumentException("El título debe tener máximo 100 caracteres");
        }
    }

    private void validarDescripcion(String descripcion) throws IllegalArgumentException {
        if (descripcion.length() > 100) {
            throw new IllegalArgumentException("La descripción debe de tener máximo 100 caracteres");
        }
    }

    private void validarFecha(Date fecha) throws IllegalArgumentException {
        if (fecha == null) {
            throw new IllegalArgumentException("Introduzca una fecha");
        } else if (fecha.before(new Date())) {
            throw new IllegalArgumentException("La fecha debe de ser posterior a la fecha actual");
        }
    }

}
