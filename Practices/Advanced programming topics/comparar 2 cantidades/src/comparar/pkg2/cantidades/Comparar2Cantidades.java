/*
Gerardo Miguel Sanchez Garcia
Programa que compara dos cantidades y determina cual es mayor
*/
package comparar.pkg2.cantidades;
import java.util.*;
public class Comparar2Cantidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer= new Scanner(System.in);
    int n1,n2;
    System.out.println("escribe un numero");
    n1= leer.nextInt();
    System.out.println("escribe otro numero");
    n2= leer.nextInt();  
    
    if (n1>n2){System.out.println("el numero mayor es "+n1);}
    else {System.out.println("el numero mayor es "+n2);}
    }
    
}
