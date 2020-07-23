package uno;

import java.util.*;

class primos {

    public void primo() {
        Scanner leer = new Scanner(System.in);
        int n, p;
        System.out.println("escriba un numero");
        n = leer.nextInt();
        int a = 0;
        for (p = 1; p < (n + 1); p++) {
            if (n % p == 0) {
                a++;
            }
        }
        if (a == 2) {
            System.out.println("el " + n + " es un numero primo");
        } else {
            System.out.println("el " + n + " no es un numero primo");
        }

    }
}
