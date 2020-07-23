/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forma;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author PC03
 */
public class Cuadro extends javax.swing.JFrame {
    
    String Textura="";
    boolean Datos_V = false;
    // con esta clase podemos saber el tamaño de la pantalla en que se esta trabajando
    Toolkit t = Toolkit.getDefaultToolkit();
    Dimension Resolucion = Toolkit.getDefaultToolkit().getScreenSize();
    //declaramos las variables donde guardremos el tamaño del rectangulo
    int Ancho = 0, Alto = 0;
    boolean Dibujado = false;
    Color Color=null;

    public void Dibujar() {
         Graphics g = this.getGraphics();//instanciamos la clase graphics para poder usar los componentes graficos de java
        super.paint(g);
        // si no hemos dibujado el rectangulo entonces entrara a la condcion para dibujarlo
        if (Dibujado == false) {
            //miesntras los datos no sean validos volvera a preguntarlos
            while (Datos_V == false) {
                //este try cath valida que solo se ingresen numeros
                try {
                    //preguntamos al usuario el ancho del rectangulo y su altura y los guardamos en las variables
                    Ancho = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ancho del rectangulo por favor"));
                    Alto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la altura del rectangulo por favor"));
                    //si los datos proporcionados por el usuario son menores al tamaño de nuestra pantalla lo graficara si no los volvera a pedir
                    if ((Ancho <= Resolucion.width - 50) && (Alto <= Resolucion.height - 200)) {
                       //en caso de ser validos ponemos nuestra bandera en verdadero
                        Datos_V = true;
                    } else {
                        //en caso de que los datos no sean validos mostramos un mensaje al usuario de que sus datos no son validos
                        JOptionPane.showMessageDialog(null, "Usted desea dibujar un rectangulo mas grande que la pantalla ingrese nuevamente las medidas por favor");
                    }
                } catch (NumberFormatException e) {
                    //en caso que el usuario ingrese un dato que no sea un numero mostraremos este mensajee
                    JOptionPane.showMessageDialog(null, "Ingrese solo numeros por favor");
                }
            }
            //calculamos el centro de la pantalla para que el rectangulo quede en el centro de la misma
            // x es igual al ancho de la pantalla sobre dos menos el ancho sobre dos para poder centrarlo puesto que lo dibuja a partir de la esquina superior izquierda
            int Centro_x = (Resolucion.width / 2) - Ancho / 2;
            //y es igual al alto de la pantallla sobre 2 menos el alto sobre dos para poder centrarlo puesto que lo dibuja a partir de la esquina superior izquierda
            int Centro_y = Resolucion.height / 2 - Alto / 2;
            // dibujamos el rectangulo con los datos obtenidos
            g.drawRect(Centro_x, Centro_y, Ancho, Alto);
            JOptionPane.showMessageDialog(null, "Rectangulo dibujado seleccione un color y una textura para rellenarlo");
        }else{JOptionPane.showMessageDialog(null, "Usted ya dibujo su rectangulo escoja un color y una textura para rellenarlo");}
    }
    
    //metodo que llama a la paleta de colores para que le usuario seleccione el color del que desea rellenar su forma
    public void Color(){
    
   JColorChooser ventanaDeColores=new JColorChooser();
   Color=ventanaDeColores.showDialog(null, "Seleccione un Color", Color.gray);
    }

    public void Rellenar(){
        //verificamos que se hayan seleccionadoe el color y la textura
        if(Color!=null&&!Textura.equals("")){
            
         Graphics g = this.getGraphics();//instanciamos la clase graphics para poder usar los componentes graficos de java
         g.setColor(Color);//seteamos el color  
         //hacemos un ciclo con saltos en x ancho de 7 y alto de 7 para recorrer la fila de los multiplos del siete
         //iniciamos en el punto donde comenzamos graficar la figura mas tres pixeles para respetar el margen
         for (int x =((Resolucion.height / 2) - Alto / 2)+3 ; x < (((Resolucion.height / 2) - Alto / 2)-3)+Alto; x+=7) {//ciclo que dibuja lineas con saltos en funcion de la escala
            
            for (int i =((Resolucion.width / 2) - Ancho / 2)+3 ; i < (((Resolucion.width / 2) - Ancho / 2)-3)+Ancho; i += 7) {//inicia en i y termina en el ancho de la pantalla avanzando un pixel a la vez
            //si el numero de la coordenada alto es impar dibujamos un circulo o un ovalo dependiendo la ccordenada sera impar por que es un multiplo de siete
                if(x%2==0&&i%2!=0){
               if(Textura.equals("Rectangulo")){
                 g.fillRect(i,x, 7, 7);
                 g.setColor(Color);//seteamos el color  
               }
               if(Textura.equals("Circulo")){
                 g.fillOval(i,x, 7, 7);
                 g.setColor(Color);//seteamos el color  
               }
             }
            }
        }
         //hacemos otro ciclo para recorrer ahora las columnas de los multiplos del 14
         //iniciamos en el punto donde comenzamos graficar la figura mas tres pixeles para respetar el margen
    for (int x =((Resolucion.height / 2) - Alto / 2)+3 ; x < (((Resolucion.height / 2) - Alto / 2)-3)+Alto; x+=7) {//ciclo que dibuja lineas con saltos en funcion de la escala
        System.out.println(x); 
            for (int i =((Resolucion.width / 2) - Ancho / 2)+3 ; i < (((Resolucion.width / 2) - Ancho / 2)-3)+Ancho; i += 14) {//inicia en i y termina en el ancho de la pantalla avanzando un pixel a la vez
             //si el ancho es un numero par dibujamos un circulo o un rectangulo segun corresponda la coordenada sera par por que es un multiplo del numero catorce
                if(x%2!=0&&i%2==0){
                if(Textura.equals("Rectangulo")){
                 g.fillRect(i,x, 7, 7);
                 g.setColor(Color);//seteamos el color  
               }
               if(Textura.equals("Circulo")){
                 g.fillOval(i,x, 7, 7);
                 g.setColor(Color);//seteamos el color  
               }
             }
            }
        }
        }else{
        JOptionPane.showMessageDialog(null, "Seleccione primero el color y la textura con la que desea rellenar el rectangulo");
        }
    }
    public Cuadro() {
        //Maximizamos el tamaño del marco al tamaño de toda la pantalla para poder adaptarlo a la resolucion y el tamaño no sea un problema
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        BOTONES.setVisible(false);
        JB_Cuadrado.setVisible(false);
        JB_Circulo.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JB_Dibujar = new javax.swing.JButton();
        JB_Rellenar = new javax.swing.JButton();
        JB_Color = new javax.swing.JButton();
        JB_Textura = new javax.swing.JButton();
        JB_Circulo = new javax.swing.JButton();
        JB_Cuadrado = new javax.swing.JButton();
        BOTONES = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JB_Dibujar.setText("Dibujar");
        JB_Dibujar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_DibujarActionPerformed(evt);
            }
        });

        JB_Rellenar.setText("Rellenar");
        JB_Rellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_RellenarActionPerformed(evt);
            }
        });

        JB_Color.setText("Color");
        JB_Color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ColorActionPerformed(evt);
            }
        });

        JB_Textura.setText("Textura");
        JB_Textura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_TexturaActionPerformed(evt);
            }
        });

        JB_Circulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forma/Circulo.png"))); // NOI18N
        JB_Circulo.setText("TEXTURA 1");
        JB_Circulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CirculoActionPerformed(evt);
            }
        });

        JB_Cuadrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forma/Cuadrado.png"))); // NOI18N
        JB_Cuadrado.setText("TEXTURA 2");
        JB_Cuadrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CuadradoActionPerformed(evt);
            }
        });

        BOTONES.setText("Seleccione la textura");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(JB_Dibujar)
                .addGap(138, 138, 138)
                .addComponent(JB_Color)
                .addGap(78, 78, 78)
                .addComponent(JB_Textura)
                .addGap(44, 44, 44)
                .addComponent(JB_Rellenar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(JB_Circulo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(BOTONES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_Cuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_Cuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_Circulo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BOTONES))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 283, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JB_Dibujar)
                    .addComponent(JB_Rellenar)
                    .addComponent(JB_Color)
                    .addComponent(JB_Textura))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_RellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_RellenarActionPerformed
    Rellenar();
    }//GEN-LAST:event_JB_RellenarActionPerformed

    private void JB_ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ColorActionPerformed
    Color();   
    }//GEN-LAST:event_JB_ColorActionPerformed

    private void JB_DibujarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_DibujarActionPerformed
        Dibujar();
    }//GEN-LAST:event_JB_DibujarActionPerformed

    private void JB_TexturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_TexturaActionPerformed

     BOTONES.setVisible(true);
     JB_Cuadrado.setVisible(true);
     JB_Circulo.setVisible(true);
    }//GEN-LAST:event_JB_TexturaActionPerformed

    private void JB_CirculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CirculoActionPerformed
    BOTONES.setVisible(false);
        JB_Cuadrado.setVisible(false);
        JB_Circulo.setVisible(false);
        Textura="Circulo";
        JOptionPane.showMessageDialog(null, "Selecciono la textura de circulos");
        Dibujar();
    }//GEN-LAST:event_JB_CirculoActionPerformed

    private void JB_CuadradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CuadradoActionPerformed
    BOTONES.setVisible(false);
        JB_Cuadrado.setVisible(false);
        JB_Circulo.setVisible(false);
        Textura="Rectangulo";
        JOptionPane.showMessageDialog(null, "Selecciono la textura de cuadrados");
        Dibujar();
    }//GEN-LAST:event_JB_CuadradoActionPerformed

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
            java.util.logging.Logger.getLogger(Cuadro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cuadro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cuadro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cuadro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cuadro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BOTONES;
    private javax.swing.JButton JB_Circulo;
    private javax.swing.JButton JB_Color;
    private javax.swing.JButton JB_Cuadrado;
    private javax.swing.JButton JB_Dibujar;
    private javax.swing.JButton JB_Rellenar;
    private javax.swing.JButton JB_Textura;
    // End of variables declaration//GEN-END:variables
}
