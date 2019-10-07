package ar.edu.unahur.obj2.ejercicio4;

public class VentaOnline extends ProcesadorDeOrdenes {

    @Override
    protected void seleccionarProducto() {
        System.out.println("Se agrega el producto al carrito de compras");
    }

    @Override
    protected void pagarProducto() {
        System.out.println("Se Paga el producto por Transferencia bancaria o tarjeta de crédito");
    }

    @Override
    protected void entregar() {
        System.out.println("Se entrega el producto en la direccion");
    }
}
