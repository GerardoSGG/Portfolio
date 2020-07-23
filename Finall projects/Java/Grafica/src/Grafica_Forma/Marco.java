
package Grafica_Forma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Gera
 */
public class Marco extends javax.swing.JFrame {

    //variables para almacenar las cordenadas del punto
    int Puntox[] = new int[100];
    int Puntoy[] = new int[100];
    int Contadorp = 0;
    //variabes para guardar las coordenadas de la recta
    int Rectax[] = new int[100];
    int Rectay[] = new int[100];
    //arreglos que almacenan los puntos de las rectas
    int Rectaxa[] = new int[100];
    int Rectaya[] = new int[100];
    int ContadorR=0,ContadorRa=1,suma=1;
    //variables para guardar las coordenadas del cntro y el radio del circulo
    int Centrox[] = new int[100];
    int Centroy[] = new int[100];
    int Radio[] = new int[100];
    //variable que almacena la pendiente
    int Escala = 1;
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int planol = screenSize.width, planoa = screenSize.height - 100;

    private void Planos() {
        //Boton que grafica los planos x y y
        Escala = Integer.parseInt(JOptionPane.showInputDialog("Escribe la ecala con la que definiras tu plano", Escala));
        int alto = (screenSize.height - 100) - Escala, ancho = 25;//definimos alto como el alto de la pantalla menos 100 para respetar los botones 
        //y le aumentamos la escala para no tocar el plano x

        Graphics g = this.getGraphics();//instanciamos la clase graphics para poder usar los componentes graficos de java

        for (int i = 0; i < screenSize.height - 100; i += 1) {// ciclo que genera el plano y desde la parte superior hasta el tamaño  
            //de la pantalla menos 100 para respetar el espacio de los botones
            g.drawRect(Escala, i, 3, 3);//dibuja un cuadrado  de 3 x 3 pixeles en la posicion 25 de la pantalla y va aumentando hacia abajo 
            g.setColor(Color.black);//le seteamos el color negro a nuestro cuadrado para resaltarlo
        }
        for (int i = Escala; i < (screenSize.width); i += 1) {//ciclo que dibuja el plano x desde 25 hasta el 
            //ancho de la pantalla de izquierda  a derecha 
            g.drawRect(i, screenSize.height - 100, 3, 3);//genera un rectangulo en la posicion i y en la altura 
            //de la pantalla menos 100 para respetar el espacio de los botones
            g.setColor(Color.black);//seteamos el color negro al rectangulo para resaltarlo
        }

        for (ancho = Escala; ancho < screenSize.height - 100 + Escala; ancho += Escala) {//ciclo que dibuja lineas con saltos en funcion de la escala
            //inicia con una linea en la posicion de la altura de la pantala menos 1oo para respetar los botones
            //y aumentando la escala para respetar la linea del eje x
            for (int i = Escala; i < (screenSize.width); i += 3) {//inicia en i y termina en el ancho de la pantalla avanzando un pixel a la vez
                g.drawRect(i, alto, 1, 1);//dibuja un ractangulo en la posicion i,alto alto es el salto de cada linea en funcion de la escala
                g.setColor(Color.gray);//seteamos el color gris para tener una linea mastenue

            }
            alto = alto - Escala;//disminuimos alto por que se grafica de arriba hacia abajo por tanto 
            //alto inicia por ejemplo en 700 la siguiente linea sera en 700 menos la escala
        }

        for (int altop = Escala + Escala; altop < screenSize.width; altop += Escala) {//ciclo que dibuja lineas con saltos en funcion de la escala
            //inicia con una linea en la posicion de la altura de la pantala menos 1oo para respetar los botones
            //y aumentando la escala para respetar la linea del eje x
            for (int i = 0; i < (screenSize.height - 100); i += 3) {//inicia en i y termina en el ancho de la pantalla avanzando un pixel a la vez
                g.drawRect(altop, i, 1, 1);//dibuja un ractangulo en la posicion i,alto alto es el salto de cada linea en funcion de la escala
                g.setColor(Color.gray);//seteamos el color gris para tener una linea mastenue

            }

            //alto inicia por ejemplo en 700 la siguiente linea sera en 700 menos la escala
        }
    }

    //metodo que grafica un punto
    private void Punto() {
        Graphics g = this.getGraphics();//instanciamos la clase graphics para poder usar los componentes graficos de java
        
        boolean bandera = false;
        while (bandera == false) {
            try {
                Puntox[Contadorp] = (Integer.parseInt(JOptionPane.showInputDialog("Escribe la coordena x del punto", Puntox[Contadorp])))*Escala+Escala;
                Puntoy[Contadorp] = (Integer.parseInt(JOptionPane.showInputDialog("Escribe la coordena y del punto", Puntoy[Contadorp])))*Escala;
                System.out.println(Puntox[Contadorp] + "sdfsdfsdf" + Puntoy[Contadorp]);
                bandera = true;
                g.fillOval(Puntox[Contadorp],(screenSize.height - 100) -Puntoy[Contadorp], 5, 5);               
                FontMetrics fm = g.getFontMetrics();//para escribir el nombre de la linea
            String texto = "Punto ";//guardamos la palabra recta en la variable texto
            g.setColor(Color.orange);//le seteamos el color a las letras
            g.drawString(texto + " "+(Contadorp+1), Puntox[Contadorp], (screenSize.height - 100) -Puntoy[Contadorp]);//generamos un texto con el texto y la concatenacion de la variable suma                                          
            //en als coordenadas finales de la recta
            //final escribir texto
                Contadorp++;
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escriba solo numeros por favor");
            }
        }
    }
    //grafia recta
    private void Lee(){
        ContadorR=0;
        boolean bandera=false;
        while(bandera==false){
    try {
                Rectax[ContadorR] = (Integer.parseInt(JOptionPane.showInputDialog("Escribe la coordena x del punto inicial de la recta", Rectax[Contadorp])))*Escala+Escala;
                Rectay[ContadorR] = (Integer.parseInt(JOptionPane.showInputDialog("Escribe la coordena y del punto inicial de la recta", Rectay[ContadorR])))*Escala;
                Rectaxa[ContadorRa]=Rectax[ContadorR];
                Rectaya[ContadorRa]=Rectay[ContadorR];
                ContadorR++;
                ContadorRa++;
                //leemos los valores
                Rectax[ContadorR] = (Integer.parseInt(JOptionPane.showInputDialog("Escribe la coordena x del punto final de la recta", Rectax[Contadorp])))*Escala+Escala;
                Rectay[ContadorR] = (Integer.parseInt(JOptionPane.showInputDialog("Escribe la coordena y del punto final de la recta", Rectay[ContadorR])))*Escala;
                //multiplicamos para trabajar en base a la escala
                
                Rectaxa[ContadorRa]=Rectax[ContadorR];
                Rectaya[ContadorRa]=Rectay[ContadorR];
                ContadorR++;
                ContadorRa++;
               bandera=true;
    }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escriba solo numeros por favor");
            }
        }
    }
    
    private void Recta(){
        Graphics g = this.getGraphics();//instanciamos la clase graphics para poder usar los componentes graficos de java                                                
        int y = planoa - Rectay[0];// puesto que toma el inicio de "y" desde la parte superior de a pantalla disminumios al eje y la ordenada de y del punto 1
        
// a>b hacer linea recta de izquierda a derecha
        if (Rectay[0] == Rectay[1]) {
            while (Rectax[0] <= Rectax[1]) {
                g.drawRect(Rectax[0], y, 1, 1);
                Rectax[0] += 1;
            }
            FontMetrics fm = g.getFontMetrics();//para escribir el nombre de la linea
            String texto = "Recta ";//guardamos la palabra recta en la variable texto
            g.setColor(Color.red);//le seteamos el color a las letras
            g.drawString(texto + suma, Rectax[1], planoa - Rectay[1]);//generamos un texto con el texto y la concatenacion de la variable suma                                          
            //en als coordenadas finales de la recta
            //final escribir texto
            suma++;
        }
        // a<b hacer linea de izquierda a derecha
        if (Rectay[0] == Rectay[1]) {
            while (Rectax[1] <= Rectax[0]) {
                g.drawRect(Rectax[1], y, 1, 1);
                Rectax[1] = Rectax[1] + 1;
                
            }
            FontMetrics fm = g.getFontMetrics();//para escribir el nombre de la linea
            String texto = "Recta ";//guardamos la palabra recta en la variable texto
            g.setColor(Color.red);//le seteamos el color a las letras
            g.drawString(texto + suma, Rectax[0], planoa - Rectay[0]);//generamos un texto con el texto y la concatenacion de la variable suma                                          
            //en als coordenadas finales de la recta
            //final escribir texto
            suma++;

        }
        // si a<b hacer linea de abajo hacia arriba
        if (Rectax[0] == Rectax[1]) {
            while (Rectay[0] <= Rectay[1]) {//ciclo para dibujar pixel a pixel el punto
                g.drawRect(Rectax[0], y, 1, 1);//dibujar punto en la coordenada cx1 y
                Rectay[0] += 1;//aumentamos cy1 para cambiar la coordenada y
                y = planoa - Rectay[0];//establecemos y= a la medida de la pantalla menos cien menos cy1 para cambiar la coordenada
            }
FontMetrics fm = g.getFontMetrics();//para escribir el nombre de la linea
            String texto = "Recta ";//guardamos la palabra recta en la variable texto
            g.setColor(Color.red);//le seteamos el color a las letras
            g.drawString(texto + suma, Rectax[1], planoa - Rectay[1]);//generamos un texto con el texto y la concatenacion de la variable suma                                          
            //en als coordenadas finales de la recta
            //final escribir texto
            suma++;
        }
        // si a>b hacer line de arriba hacia abajo
        if (Rectax[0] == Rectax[1]) {
            while (Rectay[1] <= Rectay[0]) {//ciclo para dibujar pixel a pixel el punto 
                g.drawRect(Rectax[0], y, 1, 1);//dibujar punto en la coordenada cx1,y
                Rectay[1] += 1;//aumentamos cy2 para cambiar la ubicacion de la coordenada y
                y = planoa - Rectay[1];
            }
            
FontMetrics fm = g.getFontMetrics();//para escribir el nombre de la linea
            String texto = "Recta ";//guardamos la palabra recta en la variable texto
            g.setColor(Color.red);//le seteamos el color a las letras
            g.drawString(texto + suma, Rectax[1], planoa - Rectay[1]);//generamos un texto con el texto y la concatenacion de la variable suma                                          
            //en als coordenadas finales de la recta
            //final escribir texto
            suma++;

        }
        if (Rectax[0] != Rectax[1] && Rectay[0] != Rectay[1]) {//si x y x2 son distintas y y y y2 son distintas entonces entra al ciclo
            if (Rectax[0] < Rectax[1]) {//si cx1 es menor a cx2 entonces
                double m = (double) (Rectay[1] - Rectay[0]) / (Rectax[1] - Rectax[0]);//calculamos la pendiente de la recta
                double b = 0.0;//declaramos b
                b = (double) ((m * Rectax[0]) - Rectay[0]);//calculamos el valor de b
                double B = b * -1;//como la ecuacion de la recta es y=m*x+b al momento de cruzar la igualdad se hace menos b para esto se multiplica por menos uno
                double ye;//declaramos la variable ye donde guardaremos la coordenada y calculada
                ye = m * Rectax[0] + B;//calculamos ye con los valores que tenemos de m cx1 y el que calculamos de b
                Math.round(ye);//redondeamos el resultado puesto que solo hay pixeles completos
                String k;//declaramos la variable k para poder guardar en ella el valor de ye y despues convertir en entero
                int py;//declaramos py para en ella guardar el entero que guardaremos en k

                while (Rectax[0] <= Rectax[1]) {//mientras cx1 sea menor a cx2 dos hacer el ciclo
                    ye = m * Rectax[0] + B;//calculamos ye con los valores de m y elvalor que vamos obteniendo de cx1 y B
                    Math.round(ye);//redondeamos el resultado por que solo hay pixeles completos
                    k = String.valueOf(ye);//guardamos el resultado en k como un estring
                    py = (int) Double.parseDouble(k);//convertimos el string a entero
                    g.drawRect(Rectax[0], planoa - py, 1, 1);   //graficamos el pucnto en cx1 y el alto de la pantallla menos 100 menos el valor obtenido en py puesto que 
                    //grafica de arriba hacia abajo y nosotros tenemos nuestro plano de abajo hacia arriba
                    Rectax[0] += 1;//aumentamos cx1 para avanzar un pixel en x
                }
                
                FontMetrics fm = g.getFontMetrics();//para escribir el nombre de la linea
            String texto = "Recta ";//guardamos la palabra recta en la variable texto
            g.setColor(Color.red);//le seteamos el color a las letras
            g.drawString(texto + (suma), Rectax[1], planoa - Rectay[1]);//generamos un texto con el texto y la concatenacion de la variable suma                                          
            //en als coordenadas finales de la recta
            //final escribir texto
            suma++;
            } else {//si no es asi solo invertimos las cx1 por cx2 para cambiar el punto que tomamos de referencia
                double m = (double) (Rectay[0] - Rectay[1]) / (Rectax[0] - Rectax[1]);
                double b = 0.0;
                b = (double) ((m * Rectax[1]) - Rectay[1]);
                double B = b * -1;
                double ye;
                ye = m * Rectax[1] + B;
                Math.round(ye);
                String k;
                int py;
                while (Rectax[1] <= Rectax[0]) {
                    ye = m * Rectax[1] + B;
                    Math.round(ye);
                    k = String.valueOf(ye);
                    py = (int) Double.parseDouble(k);
                    g.drawRect(Rectax[1], planoa - py, 1, 1);
                    Rectax[1] += 1;
                
                }
                FontMetrics fm = g.getFontMetrics();//para escribir el nombre de la linea
            String texto = "Recta ";//guardamos la palabra recta en la variable texto
            g.setColor(Color.red);//le seteamos el color a las letras
            g.drawString(texto + suma, Rectax[0], planoa - Rectay[0]);//generamos un texto con el texto y la concatenacion de la variable suma                                          
            //en las coordenadas finales de la recta
            //final escribir texto
            suma++;
        }             
        }

    }
    
    private void TrasladaL(){
     int x,y;
     //leemos los valores a mover en x y y
     x = Integer.parseInt(JOptionPane.showInputDialog("Cuantos puntos en x desea mover la linea "));
     y = Integer.parseInt(JOptionPane.showInputDialog("Cuantos puntos en y desea mover la linea "));
        //sumamos a las corrdenadas que guardamos en nuestro arreglo el valor a mover 
        Rectax[0]= Rectaxa[1]+(x*Escala);
        Rectay[0]= Rectaya[1]+(y*Escala);
        Rectax[1]=Rectaxa[2]+(x*Escala);
        Rectay[1]=Rectaya[2]+(y*Escala);
        //llamamos al metodo recta para graficar la recta con los nuevos valores
        Recta();
    }
    public Marco() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        System.out.println("Tu resolución es de " + screenSize.width + "x" + screenSize.height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JB_Recta = new javax.swing.JButton();
        JB_Punto = new javax.swing.JButton();
        JB_Planos = new javax.swing.JButton();
        JB_Trasladar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JB_Recta.setText("GRAFICAR RECTA");
        JB_Recta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_RectaActionPerformed(evt);
            }
        });

        JB_Punto.setText("GRAFICAR PUNTO");
        JB_Punto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_PuntoActionPerformed(evt);
            }
        });

        JB_Planos.setText("Planos");
        JB_Planos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_PlanosActionPerformed(evt);
            }
        });

        JB_Trasladar.setText("Trasladar");
        JB_Trasladar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_TrasladarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(JB_Planos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(JB_Trasladar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JB_Punto)
                .addGap(18, 18, 18)
                .addComponent(JB_Recta)
                .addGap(369, 369, 369))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(533, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Punto)
                    .addComponent(JB_Recta)
                    .addComponent(JB_Planos)
                    .addComponent(JB_Trasladar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_PuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_PuntoActionPerformed
    Punto();
    }//GEN-LAST:event_JB_PuntoActionPerformed

    private void JB_PlanosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_PlanosActionPerformed
        Planos();
    }//GEN-LAST:event_JB_PlanosActionPerformed

    private void JB_RectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_RectaActionPerformed
        Lee();
        Recta();
    }//GEN-LAST:event_JB_RectaActionPerformed

    private void JB_TrasladarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_TrasladarActionPerformed
       TrasladaL();
    }//GEN-LAST:event_JB_TrasladarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Marco.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Marco().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Planos;
    private javax.swing.JButton JB_Punto;
    private javax.swing.JButton JB_Recta;
    private javax.swing.JButton JB_Trasladar;
    // End of variables declaration//GEN-END:variables
}
