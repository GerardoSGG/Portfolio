package paises;
import java.util.*;
public class Paises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner leer= new Scanner(System.in);
    double mexico=120000000,rusia=150000000,años=2016,habitantes;
    
    while (mexico<=rusia){
        mexico= mexico*1.04;
        rusia= rusia * 1.02;
        años= años+1;  
    }
    habitantes=mexico-rusia;
    System.out.println("EN EL "+años+" MEXICO REBASARA A RUSIA CON "+habitantes+ " HABITANTES");
    }
    
}
