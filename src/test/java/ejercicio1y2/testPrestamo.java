package ejercicio1y2;

import ar.edu.unahur.obj2.ejercicio1y2.Prestamo;
import ar.edu.unahur.obj2.ejercicio1y2.SistemaAleman;
import ar.edu.unahur.obj2.ejercicio1y2.SistemaFrances;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class testPrestamo {
    Prestamo prestamo;
    SistemaAleman sistemaAleman;
    SistemaFrances sistemaFrances;

    @BeforeMethod
    public void setUp() {
        prestamo = new Prestamo(5000.50f,500.60f,10,"10/9/2019");
        sistemaAleman = new SistemaAleman(prestamo);
        sistemaFrances = new SistemaFrances(prestamo);
    }

    @Test
    public void testSistemaAleman() {
        assertEquals(sistemaAleman.duracion(prestamo),360);
        assertEquals(sistemaAleman.capital(prestamo),1.6221061944E11);
    }
    
    @Test
    public void testSistemaFrances() {
        assertEquals(sistemaFrances.duracion(prestamo),180);

    }
}
