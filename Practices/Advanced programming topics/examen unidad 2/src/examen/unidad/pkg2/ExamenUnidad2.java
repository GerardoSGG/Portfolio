
package examen.unidad.pkg2;
import java.util.*;
public class ExamenUnidad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer= new Scanner(System.in);
    String nombre;

    int ce,ht,j=48;
    System.out.println("ESCRIBA LA CANTIDAD DE EMPLEADOS");
    ce= leer.nextInt();
    for(int x=1;x<=ce;x++)
    {
    float pph;
    double ps=0;
    System.out.println("ESCRIBA NOMBRE DEL EMPLEADO");
    nombre= leer.next();
    System.out.println("ESCRIBA LA CANTIDAD DE HORAS QUE TRABAJO");
    ht= leer.nextInt();
    System.out.println("ESCRIBA CUANTO GANA POR HORA ESTE EMPLEADO");
    pph= leer.nextFloat();
                if (ht<=48)
                {
                 ps= ht*pph;                                                      
                }
                if (48<ht && ht<=52)
                {
                 ps=(48*pph)+ ((ht-48)*(pph*1.35));                                                      
                }
                if (52<ht)
                {
                 ps=(48*pph)+ ((ht-48)*(pph*1.35)) + ((ht-52)*(pph*1.5));                                                      
                } 
                System.out.println("EL SEÑOR(A) "+nombre);
                System.out.println("TRABAJO "+ht+" HORAS");
                System.out.println("GANO EN TOTAL A LA SEMANA "+ps);
                
    }
    
    
    }
    
}
