package activitat1.pkg6.m9.uf2;

public class CompteBancari {

    private int compte = 0;
    private boolean contenedorLleno = Boolean.FALSE;

    public synchronized void retirar(int value) {
        
            while (!contenedorLleno) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.err.println("Contenedor: Error en retirar -> " + e.getMessage());
                }
            }
            
            if((compte - value) >= 0){

            compte -= value;
            
            System.out.println("Retirada: " + value);
            System.out.println("SALDO ACTUAL:" + compte);
            }
            
            contenedorLleno = !contenedorLleno;
            notifyAll();
            
            System.err.println("No s'ha pogut realitzar la operació: Retirada: " + value);
            System.out.println("SALDO ACTUAL:" + compte);
        
    }

    public synchronized void ingresar(int value) {
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
        
        System.out.println("Ingres: " + value);
        System.out.println("SALDO ACTUAL:" + compte);
    }
}
