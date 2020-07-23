package dos;

import java.util.*;

class multiplo {

    public void multiplos() {
        int n;
        boolean multiploTres = false;
        Scanner numero = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce el numero: ");
            n = numero.nextInt();
            if (n % 3 == 0) {
                multiploTres = true;
            }
        }
        if (multiploTres == false) {
            System.out.println("No introduciste el multiplo de (3).");
        } else {
            System.out.println("Por lo menos se encuentra un multiplo (3).");
        }
    }
}
