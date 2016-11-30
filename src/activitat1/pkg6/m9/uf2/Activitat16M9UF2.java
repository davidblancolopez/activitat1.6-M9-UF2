
package activitat1.pkg6.m9.uf2;


public class Activitat16M9UF2 {
    private static Contenedor contenedor;
    private static Thread productor;
    private static Thread[] consumidores;
    private static final int CANTIDADCONSUMIDORES = 5;
 /**
  * contenedor es el compte
  * productor es qui ingressa diners
  * consumidor es qui treu diners
  */
    public static void main(String[] args) {
        contenedor = new Contenedor();
        productor = new Thread(new Productor(contenedor, 1));
        consumidores = new Thread[CANTIDADCONSUMIDORES];

        for (int i = 0; i < CANTIDADCONSUMIDORES; i++) {
            consumidores[i] = new Thread(new Consumidor(contenedor, i));
            consumidores[i].start();
        }

        productor.start();
    }

}