//SANCHEZ GARCIA GERARDO MIGUEL NUMERO DE CONTROL 16630138 JUEGO DE CARTAS REPRESENTACION DE "PILA"
package cartas;

import javax.swing.ImageIcon;
public class MARCO extends javax.swing.JFrame {
    public MARCO() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        CARTA1 = new javax.swing.JLabel();
        INSERTAR = new javax.swing.JButton();
        BORRAR = new javax.swing.JButton();
        carta5 = new javax.swing.JLabel();
        carta4 = new javax.swing.JLabel();
        carta3 = new javax.swing.JLabel();
        carta2 = new javax.swing.JLabel();
        carta1 = new javax.swing.JLabel();
        jScrollBar2 = new javax.swing.JScrollBar();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(51, 0, 204));

        INSERTAR.setText("INSERTAR");
        INSERTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INSERTARActionPerformed(evt);
            }
        });

        BORRAR.setText("BORRAR");
        BORRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BORRARActionPerformed(evt);
            }
        });

        carta5.setText("carta5");

        carta4.setText("carta4");

        carta3.setText("carta3");

        carta2.setText("carta2");

        carta1.setText("carta1");

        jScrollBar2.setAutoscrolls(true);
        jScrollBar2.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                jScrollBar2AdjustmentValueChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(INSERTAR)
                        .addGap(104, 104, 104)
                        .addComponent(BORRAR))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(CARTA1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(carta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(carta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(carta4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(carta3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(jScrollBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(INSERTAR)
                    .addComponent(BORRAR))
                .addGap(18, 18, 18)
                .addComponent(CARTA1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addComponent(jScrollBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 String nombre[] = new String[4];
    String n[] = new String[13];
    int numero;
    int num;
    int cont = 0;
    private void INSERTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INSERTARActionPerformed
        nombre[0] = "CORAZONES";
        nombre[1] = "DIAMANTES";
        nombre[2] = "PIKAS";
        nombre[3] = "TREBOLES";
        n[0] = "AS";
        n[1] = "2";
        n[2] = "3";
        n[3] = "4";
        n[4] = "5";
        n[5] = "6";
        n[6] = "7";
        n[7] = "8";
        n[8] = "9";
        n[9] = "10";
        n[10] = "J";
        n[11] = "Q";
        n[12] = "K";
        cont++;

        switch (cont) {
            case 1: {
                numero = (int) (Math.random() * 3);
                num = (int) (Math.random() * 12);

                carta1.setIcon(new ImageIcon(getClass().getResource("/imagenes/" + nombre[numero] + " " + n[num] + ".png")));
                System.out.println("la carta " + n[num] + " " + nombre[numero] + " ha sido agregada");
                break;
            }
            case 2: {
                numero = (int) (Math.random() * 3);
                num = (int) (Math.random() * 12);

                carta2.setIcon(new ImageIcon(getClass().getResource("/imagenes/" + nombre[numero] + " " + n[num] + ".png")));
                System.out.println("la carta " + n[num] + " " + nombre[numero] + " ha sido agregada");
                break;
            }
            case 3: {
                numero = (int) (Math.random() * 3);
                num = (int) (Math.random() * 12);

                carta3.setIcon(new ImageIcon(getClass().getResource("/imagenes/" + nombre[numero] + " " + n[num] + ".png")));
                System.out.println("la carta " + n[num] + " " + nombre[numero] + " ha sido agregada");
                break;
            }
            case 4: {
                numero = (int) (Math.random() * 3);
                num = (int) (Math.random() * 12);

                carta4.setIcon(new ImageIcon(getClass().getResource("/imagenes/" + nombre[numero] + " " + n[num] + ".png")));
                System.out.println("la carta " + n[num] + " " + nombre[numero] + " ha sido agregada");
                break;
            }
            case 5: {
                numero = (int) (Math.random() * 3);
                num = (int) (Math.random() * 12);

                carta5.setIcon(new ImageIcon(getClass().getResource("/imagenes/" + nombre[numero] + " " + n[num] + ".png")));
                System.out.println("la carta " + n[num] + " " + nombre[numero] + " ha sido agregada");
            }
            break;
        }
    }//GEN-LAST:event_INSERTARActionPerformed

    private void BORRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BORRARActionPerformed
        if (cont > 5) {
            cont = 5;
        }
        switch (cont) {
            case 1: {
                carta1.setIcon(null);
                cont--;
                break;
            }
            case 2: {
                carta2.setIcon(null);
                cont--;
                break;
            }
            case 3: {
                carta3.setIcon(null);
                cont--;
            break;
            }
            case 4: {
                carta4.setIcon(null);
                cont--;
            break;
            }
            case 5: {
                carta5.setIcon(null);
                cont--;
            break;
            }
        }
    }//GEN-LAST:event_BORRARActionPerformed

    private void jScrollBar2AdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_jScrollBar2AdjustmentValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollBar2AdjustmentValueChanged

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
            java.util.logging.Logger.getLogger(MARCO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MARCO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MARCO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MARCO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MARCO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BORRAR;
    private javax.swing.JLabel CARTA1;
    private javax.swing.JButton INSERTAR;
    private javax.swing.JLabel carta1;
    private javax.swing.JLabel carta2;
    private javax.swing.JLabel carta3;
    private javax.swing.JLabel carta4;
    private javax.swing.JLabel carta5;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollBar jScrollBar2;
    // End of variables declaration//GEN-END:variables
}
