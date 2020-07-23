/*
Gerardo Miguel Sanchez Garcia
Programa que pide ingresar un numero de programas y despues eleva el dos a la 
potencia del numero ingresado para determinar asi la cantidad de errores que se 
podrian cometer al elaborarlos
*/
package errores;
import java.util.*;
public class Errores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer = new Scanner (System.in);
    int p;
    int x;
    int errores;
    
    System.out.println("escribe el numero de programas");
    p= leer.nextInt();
    errores=1;
    
    for(x=2;x<=p;x++)
    {
    errores=errores*2;
    }    
    System.out.println("para tus "+p+" programas, se cometeran "+errores+" errores");
    }
    
}
