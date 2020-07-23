//SANCHEZ GARCIA GERARDO MIGUEL NUMERO DE CONTROL: 16630138 USO DE LISTAS
package listas;

import java.util.*;

public class Listas {
    public static void main(String[] args) {
        Random r;
        int d;
        lista lista;
        int k;
        r = new Random();
        lista = new lista();
        k = Math.abs(r.nextInt() % 55);
        for (; k > 0; k--) {
            d = r.nextInt() % 99;
            lista.insertarCabezaLista(d);
        }System.out.println("Elementos de la lista generados al azar");  lista.visualizar();  
    }

}
