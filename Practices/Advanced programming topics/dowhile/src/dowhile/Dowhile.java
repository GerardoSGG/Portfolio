
package dowhile;
import java.util.*;
public class Dowhile {
    public static void main(String[] args) {
    Scanner leer = new Scanner (System.in);
    
    int op, num=0, bandera=0;
    do
    {
        System.out.println("MENU DE OPCIONES");
        System.out.println("1- LEER NUMERO");
        System.out.println("2- DETERMINAR SI ES PAR O NO");
        System.out.println("3- ESCRIBIR SU TABLA");
        System.out.println("4- SALIR");
        System.out.println("ELIGE UNA OPCION");
        op= leer.nextInt();
        switch(op)
        {
            case 1:
            {
            System.out.println("escribe un numero"); 
            num= leer.nextInt();
            bandera=1;
            break;
            }
            case 2:
            {
            if (bandera==1)
            {
                if (num%2==0){
                 System.out.println("el numero"+num+" es par");
                }
                else  System.out.println("el numero"+num+"no es par");
            }
            else { System.out.println("no hay informacion para trabajar");}
            break;
            }
            case 3:
            {
                if (bandera==1)
                {
                    for(int x=1;x<=10;x++)
                    {
                        int res= num*x;
                        System.out.println(x+" "+num+" = "+res);                       
                    }
                }
                else{System.out.println(" NO HAY INFORMACION PARA TRABAJAR");}
                break;
            }
            case 4: {System.out.println("guss bay");}
        }    
    }
    while(op!=4);
    }
    
}
