package holamundo;

import javax.swing.JOptionPane;

public class HolaMundo {

    public static void main(String[] args) {
        System.out.println("HOLA MUNDO");
        JOptionPane.showMessageDialog(null, "HOLA MUNDO");//MOSTRAR UN MENSAJE
        String ax = JOptionPane.showInputDialog("INGRESE UN NUMERO");//capturar un dato y guardarlo en una variable
        JOptionPane.showMessageDialog(null, "EL NUMERO INGRESADO ES: " + ax);
        int n = Integer.parseInt(ax);
        JOptionPane.showMessageDialog(null, "EL NUMERO MULTIPLICADO POR DOS ES: " + (2 * n));
        
        IHola H= new IHola();
        H.setVisible(true);//mostrar etiqueta del frame
    }

}
