
package uno;
import java.util.*;
public class Uno {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner leer = new Scanner(System.in);
       
       primos one = new primos();
       fibonacci two = new fibonacci();
       BINARIO three = new BINARIO();
       
       
       int op=0;
       do {
        System.out.println("Menu");
        System.out.println("1-Numeros primos");
        System.out.println("2-Serie de fibonnaci");
        System.out.println("3-Convertir de decimal a binario");
        System.out.println("Elige lo que deseas hacer ");
        op = leer.nextInt();
        
            switch (op){
                
                case 1:
                {
                  one.primo();
                  break;
                }
                case 2:
                {
                    two.fibo();
                    break;
                }
                case 3: 
                {
                  three.binarioo();
                  break;
                }
            }
        
    } while (op!=3);
    
    }
    
}
