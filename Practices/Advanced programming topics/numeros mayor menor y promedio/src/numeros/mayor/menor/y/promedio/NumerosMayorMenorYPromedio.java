
package numeros.mayor.menor.y.promedio;
import java.util.*;
public class NumerosMayorMenorYPromedio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer= new Scanner(System.in);
    int n1,n2=0,suma=0,promedio,m=999;
    System.out.println("cuantos numeros deseas comparar");
    int cuantos = leer.nextInt();
        for(int x=1;x<=cuantos;x++)
    {
        System.out.println("escribe un numero");
        n1= leer.nextInt();
        suma=suma +n1;
        if(n1>n2) { n2 = n1;}
        if(n1<m) {m= n1;}
    }   
    promedio= suma/cuantos;
    System.out.println("el promedio de la lista es "+promedio);
    System.out.println("el menor de la lista es "+m);    
    System.out.println("el mayor de la lista es "+n2);
    
    }
    
}
