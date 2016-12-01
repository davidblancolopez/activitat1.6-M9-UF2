package activitat1.pkg6.m9.uf2;

public class Activitat16M9UF2 {

    private static CompteBancari compte;
    private static Thread[] ingres;         //Modificado para ser array de threads
    private static Thread[] retirada;

//    private static Thread ingres;         
//    private static Thread retirada;

    private static final int CANTIDADRETIRADES = 5;
    private static final int CANTIDADINGRESOS = 5;

    /**
     * contenedor es el compte productor es qui ingressa diners consumidor es
     * qui treu diners
     */
    public static void main(String[] args) {
        compte = new CompteBancari();
        
//        ingres = new Thread(new Ingres(compte, 1));
//        retirada = new Thread(new Retirar(compte, 1));

        ingres = new Thread[CANTIDADINGRESOS];
        retirada = new Thread[CANTIDADRETIRADES];
        for (int i = 0; i < CANTIDADRETIRADES; i++) {
            retirada[i] = new Thread(new Retirar(compte, i));
            retirada[i].start();
        }
        for (int j = 0; j < CANTIDADINGRESOS; j++) {
            ingres[j] = new Thread(new Ingres(compte, j));
            ingres[j].start();
        }
//Prueba con solo 1 ingresar i 1 retirada.
//        retirada.start();
//        ingres.start();
    }

}
