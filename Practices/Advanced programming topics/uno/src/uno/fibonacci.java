
package uno;

import java.util.Scanner;

class fibonacci {
    public void fibo(){
        Scanner leer= new Scanner(System.in);
        int fibo1=1, fibo2=1,num;
        System.out.println("ESCRIBE UN NUMERO");
        num = leer.nextInt();
                    System.out.println(fibo1+ " ");
                    for (int x=2; x<=num; x++) {
                        System.out.println(fibo2+" ");
                        fibo2= fibo1+fibo2;
                        fibo1=fibo2-fibo1;
    
    }
    }
}
