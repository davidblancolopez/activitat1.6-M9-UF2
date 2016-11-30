
package activitat1.pkg6.m9.uf2;


public class Activitat16M9UF2 {
    private static CompteBancari compte;
    private static Thread ingres;
    private static Thread[] retirada;
    private static final int CANTIDADRETIRADES = 5;
    //private static final int CANTIDADPRODUCTORES = 5;
 /**
  * contenedor es el compte
  * productor es qui ingressa diners
  * consumidor es qui treu diners
  */
    public static void main(String[] args) {
        compte = new CompteBancari();
        ingres = new Thread(new Ingres(compte, 1));
        retirada = new Thread[CANTIDADRETIRADES];
        

        for (int i = 0; i < CANTIDADRETIRADES; i++) {
            retirada[i] = new Thread(new Retirar(compte, i));
            retirada[i].start();
        }
        
        ingres.start();
    }

}