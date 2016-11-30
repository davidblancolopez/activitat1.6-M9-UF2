
package activitat1.pkg6.m9.uf2;


public class Contenedor {

    private int contenido;
    private boolean contenedorLleno = Boolean.FALSE;

    public synchronized int get() {
        while (!contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en get -> " + e.getMessage());
            }
        }
        contenedorLleno = !contenedorLleno;
        notify();
        return contenido;
    }

    public synchronized void put(int value) {
        while (contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en put -> " + e.getMessage());
            }
        }
        contenido = value;
        contenedorLleno = !contenedorLleno;
        notify();
    }
}
