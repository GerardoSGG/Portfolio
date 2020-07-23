//SANCHEZ GARCIA GERARDO MIGUEL NUMERO DE CONTROL: 16630138 USO DE COLAS
package colas;

import javax.swing.JOptionPane;

public class COLAS {

    public static void main(String[] args) {
        int opcion = 0, elemento = 0;
        cola c = new cola();
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1-INSERTAR UN ELEMENTO A LA COLA\n"
                        + "2-QUITAR UN ELEMENTO DE LA COLA\n"
                        + "3-¿LA COLA ESTA VACIA?\n"
                        + "4-ELEMENTO UBICADO AL INICIO DE LA COLA\n"
                        + "5-TAMAÑO DE LA COLA?\n"
                        + "6-SALIR", "MENU DE OPCIONES DE UNA COLA", JOptionPane.QUESTION_MESSAGE));
                switch (opcion) {
                    case 1: {
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null, "INGRESA EL ELEMENTO A INSERTAR", "INSERTANDO EN LA COLA", JOptionPane.QUESTION_MESSAGE));
                        c.insertar(elemento);
                        break;
                    }
                    case 2: {
                        if (!c.colavacia()) {
                            JOptionPane.showMessageDialog(null, "EL ELEMENTO ATENDIDO ES" + c.quitar(),
                                    "QUITANDO ELEMENTOS DE LA COLA", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "LA COLA ESTA VACIA" ,
                                    "COLA VACIA", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    }
                    case 3: {
                        if (c.colavacia()) {
                            JOptionPane.showMessageDialog(null, "LA COLA ESTA VACIA",
                                    "COLA VACIA", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "LA COLA NO ESTA VACIA",
                                    "COLA NO VACIA", JOptionPane.INFORMATION_MESSAGE);
                        }

                        break;
                    }
                    case 4: {
                        if (!c.colavacia()) {
                            JOptionPane.showMessageDialog(null, "ELEMENTO UBICADO AL INCIO DE COLA" + c.iniciocola(),
                                    "ELEMENTO", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "LA COLA ESTA VACIA",
                                    "COLA VACIA", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    case 5: {
                        JOptionPane.showMessageDialog(null, "EL TAMAÑO DE LA COLA ES " + c.tamañocola(),
                                "COLA VACIA", JOptionPane.INFORMATION_MESSAGE);

                        break;
                    }
                    case 6: {
                        JOptionPane.showMessageDialog(null, "APLICACION FINALIZADA",
                                "FIN", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    default:
                        JOptionPane.showMessageDialog(null, "OPCION INCORRECTA",
                                "CUIDADO", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERROR" + e.getMessage());
            }
        } while (opcion != 6);
    }

}
