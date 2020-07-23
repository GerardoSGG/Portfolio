/*
Gerardo Miguel Sanchez Garcia
Programa que pide ingresar una cantidad de numeros y compara con el numero mayor 
previamente ingresado y al final imprime en pantalla el numero mayor ingresado
*/
package comparar.varios.numeros;
import java.util.*;
public class CompararVariosNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer= new Scanner(System.in);
    int n1,n2=0;
    System.out.println("cuantos numeros desea comparar");
    int cuantos = leer.nextInt();
    for(int x=1;x<=cuantos;x++)
    {
        System.out.println("escribe un numero");
        n1= leer.nextInt();
        if(n1>n2) { n2 = n1;}
    }    
    System.out.println("el mayor de la lista es "+n2);
    }
    
}
