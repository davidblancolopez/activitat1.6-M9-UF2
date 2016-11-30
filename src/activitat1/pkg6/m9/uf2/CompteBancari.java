
package activitat1.pkg6.m9.uf2;


public class CompteBancari {

    private int compte;
    private boolean contenedorLleno = Boolean.FALSE;

    public synchronized int get(int value) {
        while (!contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        
        contenedorLleno = !contenedorLleno;
        compte -= value;
        notifyAll();
        return compte;
    }

    public synchronized void put(int value) {
        while (contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        compte += value;
        contenedorLleno = !contenedorLleno;
        notifyAll();
    }
}
