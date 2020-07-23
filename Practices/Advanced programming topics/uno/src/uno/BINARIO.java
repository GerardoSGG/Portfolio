/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uno;

import java.util.Scanner;

 class BINARIO {
     public void binarioo(){
    int num, exp, dig;
        double bin;
        Scanner con = new Scanner(System.in);
        do {
            System.out.print("Introduce un numero decimal: ");
            num = con.nextInt();
        } while (num < 0);
        exp = 0;
        bin = 0;
        while (num != 0) {
            dig = num % 2;
            bin = bin + dig * Math.pow(10, exp);
            exp++;
            num = num / 2;
        }
        System.out.printf("binario %.0f %n", bin);
     }
    
}
