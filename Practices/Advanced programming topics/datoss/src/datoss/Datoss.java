/*
Gerardo Miguel Sanchez Garcia
Programa que lee los datos de una persona y posteriormente los imprime 
en pantalla
*/
package datoss;
import java.util.*;
public class Datoss {
    
    public static void main(String[] args) {
    Scanner leer = new Scanner (System.in);
    String nombre;
    String edad;
    String sexo;
    String peso;
    String estatura;
  
    System.out.println("escribe tu nombre");
    nombre= leer.nextLine();
   
    System.out.println("escribe tu edad");
    edad = leer.nextLine();
   
    System.out.println("escribe tu sexo");
    sexo = leer.nextLine();
   
    System.out.println("escribe tu peso");
    peso = leer.nextLine();
    
    System.out.println("escribe tu estatura en metros");
    estatura = leer.nextLine();
    
    System.out.println("NOMBRE "+nombre);
    System.out.println("EDAD "+edad+" AÑOS");
    System.out.println("SEXO "+sexo);
    System.out.println("PESO "+peso+ " KILOS");
    System.out.println("ESTATURA "+estatura+ " METROS");   
    }
    
}
