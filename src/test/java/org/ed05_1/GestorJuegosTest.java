package org.ed05_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GestorJuegosTest {

    private GestorJuegos tienda;

    @BeforeEach
    public void setUp() {
        tienda = new GestorJuegos();
    }

    @Test
    public void testCP1_LongitudDistinta() {
        String[] codigos = {"ABC123"};
        int[] unidades = {2, 3};
        int resultado = tienda.registrarLoteJuegos(codigos, unidades);
        assertEquals(-1, resultado, "Debería retornar -1 porque las longitudes de los arrays son distintas.");
    }

    @Test
    public void testCP2_ArraysVacios() {
        String[] codigos = {};
        int[] unidades = {};
        int resultado = tienda.registrarLoteJuegos(codigos, unidades);
        assertEquals(-1, resultado, "Debería retornar -1 porque los arrays están vacíos.");
    }

    @Test
    public void testCP3_CantidadNegativa() {
        String[] codigos = {"ABC123"};
        int[] unidades = {-5};
        int resultado = tienda.registrarLoteJuegos(codigos, unidades);
        assertEquals(-2, resultado, "Debería retornar -2 porque hay una cantidad negativa.");
    }

    @Test
    public void testCP4_ExcedeStock() {
        String[] codigos = {"ABC123", "XYZ987"};
        int[] unidades = {150, 60};
        int resultado = tienda.registrarLoteJuegos(codigos, unidades);
        assertEquals(-3, resultado, "Debería retornar -3 porque la suma excede el stock máximo.");
    }

    @Test
    public void testCP5_InsertaNuevo() {
        String[] codigos = {"ABC123"};
        int[] unidades = {2};
        int resultado = tienda.registrarLoteJuegos(codigos, unidades);
        assertEquals(2, resultado, "Debería retornar 2 al insertar un juego nuevo correctamente.");
    }

    @Test
    public void testCP6_ActualizaExistente() {
        tienda.registrarLoteJuegos(new String[]{"ABC123"}, new int[]{2});
        String[] codigos = {"ABC123"};
        int[] unidades = {3};
        int resultado = tienda.registrarLoteJuegos(codigos, unidades);
        assertEquals(3, resultado, "Debería retornar 3 al actualizar el stock de un juego existente.");
    }
}
