package practica1.pkg5;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import javax.swing.JColorChooser;

public class Practica5 extends javax.swing.JFrame {

   // String nom = "calibri";
    //int tipo = 0;
    //int tam = 20;
    //Color c; Esta linea se utiliza cuando se mplementa variables globales

    public Practica5() {
        initComponents();
        this.setTitle("Practica 5.   JComboBox");
        this.getContentPane().setBackground(Color.gray);
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);

        //Font fuente = new Font(nom, tipo, tam);
        Font fuente = new Font("calibri", 0, 20);// la linea anterior se activa para usar variables globales
        
        Eti.setFont(fuente);
        Eti.setText(JTF_1.getText());//extrae el texto de la caja de texto
        jTA.setFont(fuente);
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fontNames.length; i++) {

            JCB_Fuente.addItem(fontNames[i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Eti = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTF_1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        JCB_Color = new javax.swing.JComboBox<>();
        JCB_Tam = new javax.swing.JComboBox<>();
        JCH_Neg = new javax.swing.JCheckBox();
        JCH_Curs = new javax.swing.JCheckBox();
        JCB_Fuente = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(1000, 600));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel1.setToolTipText("Aqui veras un ejemplo de color");

        Eti.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Eti.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(Eti)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(Eti)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 5, 5, new java.awt.Color(204, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 204, 0));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setText("Escribe tu texto de prueba en la caja siguiente");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 153), new java.awt.Color(0, 102, 102)));

        JTF_1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        JTF_1.setText("Aqui veras tu texto.....");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(JTF_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(JTF_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selector de color y fuente", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel3.setToolTipText("");

        JCB_Color.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JCB_Color.setMaximumRowCount(4);
        JCB_Color.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SLECCIONE UN COLOR", "Rojo", "Verde", "Azul", "Amarillo", "Otro" }));
        JCB_Color.setToolTipText("Aui puedes selccionar el color de tu etiqueta");
        JCB_Color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_ColorActionPerformed(evt);
            }
        });

        JCB_Tam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JCB_Tam.setMaximumRowCount(4);
        JCB_Tam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione tama�o", "8", "10", "12", "14", "16", "18", "20" }));
        JCB_Tam.setToolTipText("Define tama�o de fuente");
        JCB_Tam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_TamActionPerformed(evt);
            }
        });

        JCH_Neg.setText("NEGRITA");
        JCH_Neg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCH_NegActionPerformed(evt);
            }
        });

        JCH_Curs.setText("CURSIVA");
        JCH_Curs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCH_CursActionPerformed(evt);
            }
        });

        JCB_Fuente.setMaximumRowCount(4);
        JCB_Fuente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una fuente" }));
        JCB_Fuente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_FuenteActionPerformed(evt);
            }
        });

        jButton1.setText("APLICAR ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ESTILO");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JCB_Fuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JCH_Curs)
                            .addComponent(JCB_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JCB_Tam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCH_Neg))
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCB_Tam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JCB_Fuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCH_Curs)
                    .addComponent(JCH_Neg)
                    .addComponent(jLabel2))
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jTA.setColumns(20);
        jTA.setRows(5);
        jTA.setTabSize(20);
        jTA.setText("Escribe aqui el texto...");
        jTA.setToolTipText("Aqui puedes escribir");
        jScrollPane1.setViewportView(jTA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCB_ColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_ColorActionPerformed
        int op = JCB_Color.getSelectedIndex();//extrae el index del jbc
        Eti.setText(JTF_1.getText());
        switch (op) {
            case 1: {
                Eti.setForeground(Color.red);
                //c=Color.red;  habilitar esta linea cuando se use variables globales
            
                break;
            }
            case 2: {
                Eti.setForeground(Color.green);
                //c=Color.green; habilitar esta linea cuando se use variables globales
                break;
            }
            case 3: {
                Eti.setForeground(Color.blue);
                //c=Color.blue;   habilitar esta linea cuando se use variables globales
                break;
            }
            case 4: {
                Eti.setForeground(Color.yellow);
                //c=Color.yellow;
                break;
            }
            case 5: {
                Color c = JColorChooser.showDialog(this, "Seleccione un color", Color.white);
                Eti.setForeground(c);
                break;
            }
        }
        //Eti.setForeground(c); habilitar esta linea cuando se use variables globales para setearle a la etiqueta el color
    }//GEN-LAST:event_JCB_ColorActionPerformed

    private void JCB_TamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_TamActionPerformed
        Eti.setText(JTF_1.getText());
        //switch(JCB_Tam.getSelectedIndex()){
        //  case 1:{
        //Eti.setForeground(Color.red);break;
        //}
        //case 2:{
        //Eti.setForeground(Color.green);break;
        //}
        //case 3:{
        //Eti.setForeground(Color.blue);break;
        //}
        //case 4:{
        //Eti.setForeground(Color.yellow);break;
        //}
        //case 5:{
        //Color c = JColorChooser.showDialog(this, "Seleccione un color", Color.white);
        //Eti.setForeground(c);
        //break;
        //

        String tm = JCB_Tam.getSelectedItem().toString();
        String nom= Eti.getFont().getFontName();
        int tipo = Eti.getFont().getStyle();
        int tam = Integer.parseInt(tm);
        Font fuente = new Font(nom, tipo, tam);
        Eti.setFont(fuente);

    }//GEN-LAST:event_JCB_TamActionPerformed

    private void JCH_CursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCH_CursActionPerformed
       int tipo;
       String tm = JCB_Tam.getSelectedItem().toString();
       int tam = Integer.parseInt(tm);
        String nom= Eti.getFont().getFontName();
        if (JCH_Curs.isSelected()) {
            if (JCH_Neg.isSelected()) {
                tipo = 3;
            } else {
                //tipo=2;
                tipo = Font.ITALIC;
            }

        } else if (JCH_Neg.isSelected()) {
            //tipo=1;
            tipo = Font.BOLD;
        } else {
            tipo = 0;
        }
        Eti.setText(JTF_1.getText());
        Font fuente = new Font(nom, tipo, tam);
        Eti.setFont(fuente);
    }//GEN-LAST:event_JCH_CursActionPerformed

    private void JCB_FuenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_FuenteActionPerformed
        int tipo = Eti.getFont().getStyle();
        String nom= Eti.getFont().getFontName();
        int tam= Eti.getFont().getSize();
        Eti.setText(JTF_1.getText());
        nom = (JCB_Fuente.getSelectedItem().toString());
        Font fuente = new Font(nom, tipo, tam);
        Eti.setFont(fuente);
    }//GEN-LAST:event_JCB_FuenteActionPerformed

    private void JCH_NegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCH_NegActionPerformed
        int tipo;
       String tm = JCB_Tam.getSelectedItem().toString();
       int tam = Integer.parseInt(tm);
        String nom= Eti.getFont().getFontName();
        if (JCH_Curs.isSelected()) {
            if (JCH_Neg.isSelected()) {
                tipo = 3;
            } else {
                //tipo=2;
                tipo = Font.ITALIC;
            }

        } else if (JCH_Neg.isSelected()) {
            //tipo=1;
            tipo = Font.BOLD;
        } else {
            tipo = 0;
        }
        Eti.setText(JTF_1.getText());
        Font fuente = new Font(nom, tipo, tam);
        Eti.setFont(fuente);


    }//GEN-LAST:event_JCH_NegActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int tipo = Eti.getFont().getStyle();
        String nom= Eti.getFont().getFontName();
        int tam= Eti.getFont().getSize();
        Font fuente = new Font(nom, tipo, tam);
        jTA.setFont(fuente);
       // jTA.setForeground(c); habilitar esta linea cuando se use variables globales
        jTA.setFont(Eti.getFont());//para traer la fuente que tenga la etiqueda
        jTA.setForeground(Eti.getForeground());//para traer el color que tenga la etiqueta 
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Practica5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practica5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practica5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practica5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practica5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Eti;
    private javax.swing.JComboBox<String> JCB_Color;
    private javax.swing.JComboBox<String> JCB_Fuente;
    private javax.swing.JComboBox<String> JCB_Tam;
    private javax.swing.JCheckBox JCH_Curs;
    private javax.swing.JCheckBox JCH_Neg;
    private javax.swing.JTextField JTF_1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTA;
    // End of variables declaration//GEN-END:variables
}
