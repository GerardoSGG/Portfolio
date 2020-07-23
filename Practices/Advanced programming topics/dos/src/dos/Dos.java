package dos;
import java.util.*;
public class Dos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner leer = new Scanner(System.in);
        tablas one = new tablas();
        multiplo two = new multiplo();
        cadena three = new cadena();

        int op = 0;

        do {

            System.out.println("Mi menu");
            System.out.println("1-Tablas de multiplicar ");
            System.out.println("2-Multiplos del 3");
            System.out.println("3-Aplicame el examen porfavor");
            System.out.println("Elige una opcion");

            op = leer.nextInt();

            switch (op) {
                case 1: {
                    one.tabla();
                    break;
                }
                case 2: {
                    two.multiplos();
                    break;
                }
                case 3:
                    three.cadenaa();
                    break;
                    

            }
            

        } while (op != 2);
       
           
    }
    
}
