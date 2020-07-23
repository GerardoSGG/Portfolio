package listas;

/**
 *
 * @author mi bodega poncitlan
 */
public class lista {

    protected nodo primero;

    public lista() {
        primero = null;
    }

    public lista insertarCabezaLista(int entrada) {
        nodo nuevo;
        nuevo = new nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
        return this;
    }

    public void visualizar() {
        nodo n;
        int k = 0;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + "  ");
            n = n.enlace;
            k++;
            System.out.print((k % 15 != 0 ? " " : "\n"));
        }
    }
}
