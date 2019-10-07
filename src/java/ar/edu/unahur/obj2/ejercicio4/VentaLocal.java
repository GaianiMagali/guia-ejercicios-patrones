package ar.edu.unahur.obj2.ejercicio4;

public class VentaLocal extends ProcesadorDeOrdenes {

    @Override
    protected void seleccionarProducto() {
        System.out.println("Se seleccionar el producto en el local");
    }

    @Override
    protected void pagarProducto() {
        System.out.println("Se Paga el producto con efecto o posnet");
    }

    @Override
    protected void entregar() {
        System.out.println("Se entrega el producto en el mostrador");
    }
}
