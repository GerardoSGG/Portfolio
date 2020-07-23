
package pre.examen;
import java.util.*;
public class PreExamen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer= new Scanner(System.in);
    int n=1,opc=0,nd=0,fac=0,p=0;
    System.out.println("MENU DE OPCIONES");
    System.out.println("LEER LISTA DE NUMEROS DIFERENTES DE 0");
    System.out.println("1- CUANTOS SE LEYEREON");
    System.out.println("2- DETERMINAR LOS NUMEROS PRIMOS");
    System.out.println("3- FACTORIAL DE CADA PRIMO");
    System.out.println("4- FINALIZAR");
    System.out.println("ELIGE UNA DE LAS 4!!! OPCIONES SOLO ESTAS 4!!!!! SON VALIDAS ");
    opc= leer.nextInt();
    
    switch(opc)
    {
        case 1: {
   
         while ( n!= 0)
        {
        System.out.println("escriba un numero");
        n= leer.nextInt();
        if (n !=0)
        {
            nd++;
        }
        }
        System.out.println("se leyeron "+nd+" numeros");
        }
        
        case 2: {
            while (n!=0)
            {
                System.out.println("escriba un numero");
                n=leer.nextInt();
                int a=0;
                for (p=1;p<(n+1);p++){
                    if (n%p==0){a++;}}
                if (a ==2)
                {
                    System.out.println("EL NUMERO "+n+"  ES PRIMO");                                                       
                }
                else{System.out.println("EL NUMERO "+n+" NO  ES PRIMO");}
            }            
        }
        case 3: {
            while (n!=0)
            {
             System.out.println("escriba un numero para calcular su factorial");
             n=leer.nextInt();            
            for (int x=1;x<=n;x++){
                fac= fac*x;
            }
            System.out.println("el factorial del numero "+n+ " es "+fac);
        }
        }
        case 4: {
            System.out.println("FIN");
        }
    }
    }
    
}
