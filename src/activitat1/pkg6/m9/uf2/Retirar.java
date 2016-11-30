
package activitat1.pkg6.m9.uf2;

import java.util.Random;

/**
 *
 * @author ALUMNEDAM
 */
public class Retirar implements Runnable {

    private final CompteBancari contenedor;
    private final Random aleatorio;

    /**
     * Constructor de la clase
     *
     * @param contenedor Contenedor común a los consumidores y el productor
     * @param idconsumidor Identificador del consumidor
     */
    public Retirar(CompteBancari contenedor, int idconsumidor) {
        this.contenedor = contenedor;
        aleatorio = new Random();
    }

    @Override
    /**
     * Implementación de la hebra
     */
    public void run() {
        while (Boolean.TRUE) {
            
            int quitar = aleatorio.nextInt(1000);
            int dineroActual = contenedor.retirar(quitar);
            System.out.println("Retirada: "+ quitar
                    + "\n SALDO ACTUAL: " + dineroActual);
        }
    }
}