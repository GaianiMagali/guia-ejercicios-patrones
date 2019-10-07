package ar.edu.unahur.obj2.ejercicio4;

public abstract class ProcesadorDeOrdenes {

    public void procesarOrden(boolean regalo) {
        seleccionarProducto();
        pagarProducto();
        if (regalo) {
            envolverParaRegalo();
        }
        entregar();
    }

    protected abstract void seleccionarProducto();

    protected void envolverParaRegalo() {
        System.out.println("Se envuelve para regalo el producto");
    }

    protected abstract void pagarProducto();

    protected abstract void entregar();
}
