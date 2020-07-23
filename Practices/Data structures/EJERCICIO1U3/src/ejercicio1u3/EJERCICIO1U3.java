//GERARDO MIGUEL SANCHE GARCIA NUMERO DE CONTROL:16630138 //USO DE PILAS
package ejercicio1u3;

import java.util.*;

public class EJERCICIO1U3 {

    int max = 10, tope = 0;
    String pila[] = new String[max];
    String dato;

    void insertar() {
        Scanner leer = new Scanner(System.in);
        try {
            while (tope < max) {
                

                    System.out.println("ESCRIBA EL DATO QUE DESEA INGRESAR");
                    dato = leer.nextLine();
                    pila[tope] = dato;
                    tope++;
                
            }System.out.println("LA PILA ESTA LLENA");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("LA PILA ESTA LLENA");
        }
    }

    void eliminar() {
        
            if (tope > 0) {
                tope = tope - 1;
                pila[tope]=null;
                
            } else {
                System.out.println("YA NO HAY ELEMENTOS EN LA PILA");
            }
    }

    void consultar() {
        for (int a=(tope-1); a >= 0; a--) {
            System.out.println(pila[a]);
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int b = 0;
        EJERCICIO1U3 e = new EJERCICIO1U3();
        while (b != 4) {
            System.out.println("QUE ES LO QUE DESEA HACER");
            System.out.println("1-INSERTAR UN DATO A LA PILA");
            System.out.println("2-ELIMINAR UN DATO DE LA PILA");
            System.out.println("3-CONSULTAR");
            System.out.println("4-SALIR");
            b = leer.nextInt();
            switch (b) {
                case 1: {
                    e.insertar();
                    break;
                }
                case 2: {
                    e.eliminar();
                    break;
                }
                case 3: {
                    e.consultar();
                    break;
                }
                case 4:{
                    System.out.println("GRACIAS POR USAR ESTE PROGRAMA");}
            }
        }
    }

}
