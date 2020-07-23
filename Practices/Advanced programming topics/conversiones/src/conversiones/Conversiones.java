package conversiones;

import java.util.*;

public class Conversiones {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion, num,N,hexadecimal;

        System.out.println("Elige una opcion");
        System.out.println("1- Decimal a binario.");
        System.out.println("2- Decimal a octal.");
        System.out.println("3- Decimal a Hexadecimal");
        System.out.println("4- Salir");
        opcion = leer.nextInt();
        switch (opcion) {
            case 1: {
                System.out.println("Escibre el numero que deseas convertir.");
                num = leer.nextInt();
                System.out.println("Resultado: ");
                while (num != 0) {
                    num = num / 2;
                    int resultado = num % 2;
                    System.out.print(resultado);

                }
                System.out.println("");
                break;

            }
            case 2: {
                System.out.println("Escibre el numero que deseas convertir.");
                num = leer.nextInt();
                System.out.println("Resultado: ");
                while (num != 0) {
                    num = num / 8;
                    int resultado = num % 8;
                    System.out.print(resultado);

                }
                System.out.println("");
                break;
            }
            case 3: {
                System.out.println("Escibre el numero que deseas convertir.");
                N = leer.nextInt();
               while (N != 0) {
                if(N < 16){
            if(N == 10) {System.out.print("A");}
            if(N == 11) {System.out.print("B");}
            if(N == 12) {System.out.print("C");}
            if(N == 13) {System.out.print("D");}
            if(N == 14) {System.out.print("E");}
            if(N == 15) {System.out.print("F");}
            if(N < 10) {System.out.print(N);}
        } 
        else{
 
            System.out.print(N%16);
        }
                break;
               }
    }
}
            }
        }
