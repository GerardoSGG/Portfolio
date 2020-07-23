package examen4;

import java.util.*;

public class Examen4 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion, num = 0, m3, x;
        do {
            System.out.println("1- Leer un numero positivo");
            System.out.println("2- Comprobar si el numero es multiplo de 3");
            System.out.println("3- Calcular la serie de FIBONACCI");
            System.out.println("4- Salir");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("Escribe un numero");
                    num = leer.nextInt();
                    if (num < 0) {
                        System.out.println("Error,introduce un numero positivo");
                    } else {
                        System.out.println("EL numero " + num + " es positivo");
                    }
                    break;
                }
                case 2: {
                    if (num % 3 == 0) {
                        System.out.println("El numero " + num + " es multiplo de 3");
                    } else {
                        System.out.println("El numero " + num + " no es multiplo de 3");

                    }
                    break;
                }
                case 3: {
                    int fibo1=1, fibo2=1;
                    System.out.println(fibo1+ " ");
                    for (x=2; x<=num; x++) {
                        System.out.println(fibo2+" ");
                        fibo2= fibo1+fibo2;
                        fibo1=fibo2-fibo1;
                        
                    }
                    System.out.println("");
                    break;
                }
            }
        } while (opcion != 4);

    }

}
