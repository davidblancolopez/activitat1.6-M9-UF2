package activitat1.pkg6.m9.uf2;

public class CompteBancari {

    private int compte;
    private boolean contenedorLleno = Boolean.FALSE;

    public synchronized int retirar(int value) {
        
            while (!contenedorLleno) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.err.println("Contenedor: Error en retirar -> " + e.getMessage());
                }
            }

            contenedorLleno = !contenedorLleno;
            compte -= value;
            notifyAll();
            return compte;
        
    }

    public synchronized int ingresar(int value) {
        while (contenedorLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println("Contenedor: Error en ingresar -> " + e.getMessage());
            }
        }
        compte += value;
        contenedorLleno = !contenedorLleno;
        notifyAll();
        return compte;
    }
}
