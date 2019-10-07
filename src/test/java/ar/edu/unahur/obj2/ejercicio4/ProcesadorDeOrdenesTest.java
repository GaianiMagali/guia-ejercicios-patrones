package ar.edu.unahur.obj2.ejercicio4;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.Assert.*;

public class ProcesadorDeOrdenesTest {

    // Guardo el System.out original antes de modificarlo
    private final PrintStream originalStdOut = System.out;
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();
    VentaLocal ventaLocal;
    VentaOnline ventaOnline;

    @BeforeMethod
    public void beforeTest()
    {
        // Guardo el System.out en consoleContent
        System.setOut(new PrintStream(this.consoleContent));
    }

    //Ventas en el local
    @org.testng.annotations.Test
    public void testProcesarOrdenRegaloL() {
        //ProcesadorDeOrdenes procesadorDeOrdenes = new ProcesadorDeOrdenes();
        //procesadorDeOrdenes.procesarOrden(true);
        ventaLocal = new VentaLocal();
        ventaLocal.procesarOrden(true);

        String consola = this.consoleContent.toString();

        assertTrue(consola.indexOf("Se seleccionar el producto en el local")!=-1);
        assertTrue(consola.indexOf("Se envuelve para regalo el producto")!=-1);
        assertTrue(consola.indexOf("Se Paga el producto con efecto o posnet")!=-1);
        assertTrue(consola.indexOf("Se entrega el producto en el mostrador")!=-1);
    }

    @org.testng.annotations.Test
    public void testProcesarOrdenNoRegaloL() {
        //ProcesadorDeOrdenes procesadorDeOrdenes = new ProcesadorDeOrdenes();
        //procesadorDeOrdenes.procesarOrden(false);
        ventaLocal = new VentaLocal();
        ventaLocal.procesarOrden(false);

        String consola = this.consoleContent.toString();
        assertTrue(consola.indexOf("Se seleccionar el producto en el local")!=-1);
       // assertTrue(consola.indexOf("Se envuelve para regalo el producto")==-1);
        assertTrue(consola.indexOf("Se Paga el producto con efecto o posnet")!=-1);
        assertTrue(consola.indexOf("Se entrega el producto en el mostrador")!=-1);
    }

    @AfterMethod
    public void afterTest()
    {
        // Guardo el System.out original
        System.setOut(this.originalStdOut);

        // Clear the consoleContent.
        this.consoleContent = new ByteArrayOutputStream();
    }

    //Ventas en online
    @org.testng.annotations.Test
    public void testProcesarOrdenRegaloO() {
        //ProcesadorDeOrdenes procesadorDeOrdenes = new ProcesadorDeOrdenes();
        //procesadorDeOrdenes.procesarOrden(true);
        ventaOnline = new VentaOnline();
        ventaOnline.procesarOrden(true);

        String consola = this.consoleContent.toString();

        assertTrue(consola.indexOf("Se agrega el producto al carrito de compras")!=-1);
        assertTrue(consola.indexOf("Se envuelve para regalo el producto")!=-1);
        assertTrue(consola.indexOf("Se Paga el producto por Transferencia bancaria o tarjeta de crédito")!=-1);
        assertTrue(consola.indexOf("Se entrega el producto en la direccion")!=-1);
    }

    @org.testng.annotations.Test
    public void testProcesarOrdenNoRegaloO() {
        //ProcesadorDeOrdenes procesadorDeOrdenes = new ProcesadorDeOrdenes();
        //procesadorDeOrdenes.procesarOrden(false);
        ventaOnline = new VentaOnline();
        ventaOnline.procesarOrden(false);

        String consola = this.consoleContent.toString();
        assertTrue(consola.indexOf("Se agrega el producto al carrito de compras")!=-1);
        //assertTrue(consola.indexOf("Se envuelve para regalo el producto")==-1);
        assertTrue(consola.indexOf("Se Paga el producto por Transferencia bancaria o tarjeta de crédito")!=-1);
        assertTrue(consola.indexOf("Se entrega el producto en la direccion")!=-1);

    }




}