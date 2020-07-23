
package dos;
import java.util.*;
class tablas {
    public void tabla(){
    Scanner leer = new Scanner(System.in);
        int n;
        int bandera=0;
        System.out.print("Introduce el numero del que deseas tener su tabla : ");
        n = leer.nextInt();
        bandera =1;
        System.out.println("Tabla del " + n+ "Numero ");
        for(int i = 1; i<=10; i++){
             System.out.println(n + " * " + i + " = " + n*i);
    }
    }
}
