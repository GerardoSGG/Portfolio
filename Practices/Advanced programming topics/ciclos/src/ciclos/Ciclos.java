/*
Gerardo Miguel Sanchez Garcia
Programa que pide ingresar un numero y validar si es un numero par o un multiplo 
de tres hasta que se ingrese un cero, al ingresar un cero imprime en panatalla 
el total de numeros pares leidos, el total de los multiplos de tres,el total de 
numeros leidos y el promedio de los numeros total leidos.
*/
package ciclos;
import java.util.*;
public class Ciclos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer= new Scanner(System.in);
    float num=1,promedio=0,suma=0;
    int pares=0,m3=0,cant=0;
    
    while(num!=0)
    {
        System.out.println("teclea un numero");
        num= leer.nextFloat();
        if(num!=0){
            if (num%2==0) {pares++;}
            if (num%3==0) {m3++;}
            suma=suma+num;
            cant++;
        }
    }
    System.out.println("cantidad de pares "+pares);
    System.out.println("cantidad de multiplos de 3  "+m3);
    System.out.println("cantidad de numeros leidos "+cant);
    System.out.println("promedio de numeros leidos "+suma/cant);  
    }
    
}
