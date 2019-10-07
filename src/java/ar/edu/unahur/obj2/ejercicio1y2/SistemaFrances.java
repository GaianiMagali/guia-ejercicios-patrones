package ar.edu.unahur.obj2.ejercicio1y2;

public class SistemaFrances extends SistemaDeAmortizacion {

    public SistemaFrances(Prestamo prestamo) {
        super(prestamo);
    }

    @Override
    public double capital(Prestamo prestamo) {
        return super.capital(prestamo) *
                prestamo.getPorcentajeNoUtilizado();
    }
}
