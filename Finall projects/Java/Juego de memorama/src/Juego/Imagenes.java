/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import javax.swing.JOptionPane;

/**
 *
 * @author mi bodega poncitlan
 */
public class Imagenes extends javax.swing.JFrame {

    JF_Tama�o TAMA�O = new JF_Tama�o();
    int [] f=new int[13];
    int NCseleccion = 0;
    int tama;

    /**
     * Creates new form Imagenes
     */
    public void Asigna(int tam){
    tama=tam;
    }
    public Imagenes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox5 = new javax.swing.JCheckBox();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        Im1 = new javax.swing.JRadioButton();
        Im2 = new javax.swing.JRadioButton();
        Im4 = new javax.swing.JRadioButton();
        Im6 = new javax.swing.JRadioButton();
        Im3 = new javax.swing.JRadioButton();
        Im10 = new javax.swing.JRadioButton();
        Im8 = new javax.swing.JRadioButton();
        Im9 = new javax.swing.JRadioButton();
        Im5 = new javax.swing.JRadioButton();
        Im7 = new javax.swing.JRadioButton();
        Im11 = new javax.swing.JRadioButton();
        Im12 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        jCheckBox5.setText("jCheckBox1");

        jRadioButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/5.jpg"))); // NOI18N

        jRadioButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/7.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Im1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/1.jpg"))); // NOI18N
        Im1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im1ActionPerformed(evt);
            }
        });

        Im2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/2.jpg"))); // NOI18N
        Im2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im2ActionPerformed(evt);
            }
        });

        Im4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/4.jpg"))); // NOI18N
        Im4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im4ActionPerformed(evt);
            }
        });

        Im6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/6.jpg"))); // NOI18N
        Im6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im6ActionPerformed(evt);
            }
        });

        Im3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/3.jpg"))); // NOI18N
        Im3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im3ActionPerformed(evt);
            }
        });

        Im10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/10.jpg"))); // NOI18N
        Im10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im10ActionPerformed(evt);
            }
        });

        Im8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/8.jpg"))); // NOI18N
        Im8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im8ActionPerformed(evt);
            }
        });

        Im9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/9.jpg"))); // NOI18N
        Im9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im9ActionPerformed(evt);
            }
        });

        Im5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/5.jpg"))); // NOI18N
        Im5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im5ActionPerformed(evt);
            }
        });

        Im7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/7.jpg"))); // NOI18N
        Im7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im7ActionPerformed(evt);
            }
        });

        Im11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/11.jpg"))); // NOI18N
        Im11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im11ActionPerformed(evt);
            }
        });

        Im12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/Imagenes/12.jpg"))); // NOI18N
        Im12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Im12ActionPerformed(evt);
            }
        });

        jLabel1.setText("SELECCIONA LAS IMAGENES QUE DESEAS USAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Im5)
                    .addComponent(Im9)
                    .addComponent(Im1))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Im2)
                    .addComponent(Im6)
                    .addComponent(Im10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(Im3)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Im11)
                            .addComponent(Im7))
                        .addGap(36, 36, 36)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Im4)
                            .addComponent(Im8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Im12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Im3)
                    .addComponent(Im4)
                    .addComponent(Im2)
                    .addComponent(Im1))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Im6)
                    .addComponent(Im8)
                    .addComponent(Im5)
                    .addComponent(Im7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Im9, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Im10, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(Im11)
                    .addComponent(Im12))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Im1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im1ActionPerformed
        if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[1] = 1;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im1.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
            this.dispose();
     JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im1ActionPerformed

    private void Im2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im2ActionPerformed
        if (NCseleccion != (tama/ 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[2] = 2;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im2.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
            JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");
            this.dispose();
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im2ActionPerformed

    private void Im3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im3ActionPerformed
        if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[3] = 3;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im3.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
            JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");
            this.dispose();
            
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im3ActionPerformed

    private void Im4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im4ActionPerformed
        if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[4] = 4;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im4.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
            JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");
            this.dispose();
            
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im4ActionPerformed

    private void Im5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im5ActionPerformed
       if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[5] = 5;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im5.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
           JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS"); 
           this.dispose();
            
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im5ActionPerformed

    private void Im6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im6ActionPerformed
     if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[6] = 6;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im6.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
         JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");   
         this.dispose();
            
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im6ActionPerformed

    private void Im7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im7ActionPerformed
       if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[7] = 7;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im7.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
           JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS"); 
           this.dispose();
            
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im7ActionPerformed

    private void Im8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im8ActionPerformed
        if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[8] = 8;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im8.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
            JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");
            this.dispose();
            
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im8ActionPerformed

    private void Im9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im9ActionPerformed
    if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[9] = 9;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im9.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
        JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");    
        this.dispose();
            
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im9ActionPerformed

    private void Im10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im10ActionPerformed
     if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[10] = 10;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im10.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
         JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");   
         this.dispose();
            
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im10ActionPerformed

    private void Im11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im11ActionPerformed
    if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[11] = 11;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im11.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
        JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");   
        this.dispose();
           
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im11ActionPerformed

    private void Im12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Im12ActionPerformed
       if (NCseleccion != (tama / 2)) {//si el numero de cartas que van seleccionadas es distinto a el numero de cartas entre dos
            f[12] = 12;//para cambiar el contador y saber que la carta 1 fue seleccionada
            Im12.setEnabled(false);//para que ya no pueda seleccionar de nuevo esa carta y el contador funcione
            NCseleccion++;
        } else {
           JOptionPane.showMessageDialog(null, "IMAGENES SELECCIONADAS");
           this.dispose();
           
        }//si lo anterior es falso entonces ya tenemos las cartas necesarias por lo tanto volvemos al menu
    }//GEN-LAST:event_Im12ActionPerformed

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
            java.util.logging.Logger.getLogger(Imagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Imagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Imagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Imagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Imagenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Im1;
    private javax.swing.JRadioButton Im10;
    private javax.swing.JRadioButton Im11;
    private javax.swing.JRadioButton Im12;
    private javax.swing.JRadioButton Im2;
    private javax.swing.JRadioButton Im3;
    private javax.swing.JRadioButton Im4;
    private javax.swing.JRadioButton Im5;
    private javax.swing.JRadioButton Im6;
    private javax.swing.JRadioButton Im7;
    private javax.swing.JRadioButton Im8;
    private javax.swing.JRadioButton Im9;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton9;
    // End of variables declaration//GEN-END:variables
}
