
package activitat1.pkg6.m9.uf2;


import java.util.Random;

/**
 *
 * @author Jorge
 */
public class Ingres implements Runnable {

    private final Random aleatorio;
    private final CompteBancari contenedor;
    private final int TIEMPOESPERA = 1500;

    /**
     * Constructor de la clase
     *
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idproductor Identificador del productor
     */
    public Ingres(CompteBancari contenedor, int idproductor) {
        this.contenedor = contenedor;
        aleatorio = new Random();
    }

    @Override
    /**
     * Implementación de la hebra
     */
    public void run() {
        while (Boolean.TRUE) {
            int poner = aleatorio.nextInt(1000);
            int dineroActual = contenedor.ingresar(poner);
            System.out.println("Ingres: " + poner + "\n SALDO ACTUAL: " + dineroActual);
            try {
                Thread.sleep(TIEMPOESPERA);
            } catch (InterruptedException e) {
                System.err.println("Error en run -> " + e.getMessage());
            }
        }
    }
}
