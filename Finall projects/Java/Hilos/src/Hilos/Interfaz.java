/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Gerardo Miguel Sanchez Garcia
 */
public class Interfaz extends javax.swing.JFrame {

    GridLayout gl = new GridLayout();//instaciamos la clase Gridlayoud en la variable gl
    int j = 0;//j es un contador que llevara el control de los componentes para ser agregados
    JLabel[] Eti = new JLabel[10];//definimos un arreglo de etiquetas para despues agregar una a una a el grid layout
    JButton[] Iniciar = new JButton[10];//definimos un arreglo de botones iniciar para despues agregar uno a uno al gridlayout
    JButton[] Parar = new JButton[10];//definimos un arreglo de botones Parar para despues agregar uno a uno al gridlayout
    JButton[] Reiniciar = new JButton[10];//definimos un arreglo de botones Reiniciar para despues agregar uno a uno al gridlayout

    public Interfaz() {
        initComponents();//inicia los componentes del frame
        this.setLocationRelativeTo(null);//centra el frame en la pantalla

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        JB_Agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        JB_Agregar.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        JB_Agregar.setText("AGREGAR HILO");
        JB_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(JB_Agregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(JB_Agregar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void JB_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AgregarActionPerformed
        if (j <= 9) {
            gl.setColumns(4);//seteamos el numero de columnas de nuestro grid
            gl.setRows(0);//seteamos el numero de filas de nuestro grid igual a cero para que cada que agrguemos botones salte a la linea siguiente
            gl.setHgap(5);//dejamos un espacio de cinco entre cada boton
            gl.setVgap(5);//dejamos un espacio de cinco entre cada boton
            Panel.setLayout(gl);//agragamos al panel el grid layout previamente instanciado en gl

            Eti[j] = new JLabel("00");//creamos una etiqueta en el arreglo de etiquetas
            Eti[j].setSize(20, 10);//definimos el tamaño de la etiqueta
            Eti[j].setName("Eti" + j); //seteamos el nombre de la etiqueta
            Panel.add(Eti[j]);//añadimos la etiqueta al panel

            Iniciar[j] = new JButton("Iniciar");//creamos un boton iniciar en la posicion j de el arreglo de botones
            Iniciar[j].setSize(20, 10);//definimos el tamaño de el boton
            Iniciar[j].setName("Iniciar" + j);//le definimos el nombre a  nuestro botno
            Iniciar[j].addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseReleased(java.awt.event.MouseEvent evt) {

                    if (evt.getSource().equals(Iniciar[0])) {//VALIDAMOS SI EL BOTON 0 FUE PULSADO
                            Hilo1 h = new Hilo1();//instanciamos el hilo igual que una clase dado que es una clase thread
                            h.start();//iniciamos el hilo
                            h.setName("Hilo 1");//para setear el nombre que queremos darle a nuestro hilo y despues poder controlarlo con ese nombre
                            Iniciar[0].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta
                            
                    }

                    if (evt.getSource().equals(Iniciar[1])) {//VALIDAMOS SI EL BOTON 1 FUE PULSADO
                           Hilo2 a = new Hilo2();//instanciamos el hilo igual que una clase
                            a.start();//iniciamos el hilo
                            a.setName("Hilo 2");//para setear el nombre que queremos darle a nuestro hilo
                            Iniciar[1].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta
                    }

                    if (evt.getSource().equals(Iniciar[2])) {//VALIDAMOS SI EL BOTON 2 FUE PULSADO
                           Hilo3 b = new Hilo3();//instanciamos el hilo igual que una clase
                            b.start();//iniciamos el hilo
                            b.setName("Hilo 3");//para setear el nombre que queremos darle a nuestro hilo
                            Iniciar[2].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta 
                    }
                    if (evt.getSource().equals(Iniciar[3])) {//VALIDAMOS SI EL BOTON 3 FUE PULSADO
                           Hilo4 c = new Hilo4();//instanciamos el hilo igual que una clase
                            c.start();//iniciamos el hilo
                            c.setName("Hilo 4");//para setear el nombre que queremos darle a nuestro hilo
                        Iniciar[3].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta
                    }
                    if (evt.getSource().equals(Iniciar[4])) {//VALIDAMOS SI EL BOTON 4 FUE PULSADO
                            Hilo5 d = new Hilo5();//instanciamos el hilo igual que una clase
                            d.start();//iniciamos el hilo
                            d.setName("Hilo 5");//para setear el nombre que queremos darle a nuestro hilo
                            Iniciar[4].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta
                    }
                    if (evt.getSource().equals(Iniciar[5])) {//VALIDAMOS SI EL BOTON 5 FUE PULSADO
                            Hilo6 e = new Hilo6();//instanciamos el hilo igual que una clase
                            e.start();//iniciamos el hilo
                            e.setName("Hilo 6");//para setear el nombre que queremos darle a nuestro hilo
                            Iniciar[5].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta
                    }
                    if (evt.getSource().equals(Iniciar[6])) {//VALIDAMOS SI EL BOTON 6 FUE PULSADO
                            Hilo7 f = new Hilo7();//instanciamos el hilo igual que una clase
                            f.start();//iniciamos el hilo
                            f.setName("Hilo 7");//para setear el nombre que queremos darle a nuestro hilo
                            Iniciar[6].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta
                    }
                    if (evt.getSource().equals(Iniciar[7])) {//VALIDAMOS SI EL BOTON 7 FUE PULSADO
                            Hilo8 g = new Hilo8();//instanciamos el hilo igual que una clase
                            g.start();//iniciamos el hilo
                            g.setName("Hilo 8");//para setear el nombre que queremos darle a nuestro hilo
                            Iniciar[7].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta
                    }
                    if (evt.getSource().equals(Iniciar[8])) {//VALIDAMOS SI EL BOTON 8 FUE PULSADO
                             Hilo9 i = new Hilo9();//instanciamos el hilo igual que una clase
                            i.start();//iniciamos el hilo
                            i.setName("Hilo 9");//para setear el nombre que queremos darle a nuestro hilo
                            Iniciar[8].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta
                    }
                    if (evt.getSource().equals(Iniciar[9])) {//VALIDAMOS SI EL BOTON 9 FUE PULSADO
                           Hilo10 a = new Hilo10();//instanciamos el hilo igual que una clase
                            a.start();//iniciamos el hilo
                            a.setName("Hilo 10");//para setear el nombre que queremos darle a nuestro hilo
                           Iniciar[9].setVisible(false);//ocultamos el boton para no poder iniciar otro hilo en esta etiqueta                      
                    }

                }
            });//agregamos un listener para saber cuando se presione el boton y poder ejecutar las acciones
            Panel.add(Iniciar[j]);//añadimos el boton al panel

            Parar[j] = new JButton("Parar");//creamos un boton en la posicion j de nuestro arreglo de botones parar
            Parar[j].setSize(20, 10);//definimos el tamaño de el boton
            Parar[j].setName("Parar" + j);//le seteamos el nombre al boton
            Parar[j].addMouseListener(new java.awt.event.MouseAdapter() {

                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    for(int ñ=0;ñ<10;ñ++){
                      int aux=ñ+1;//guardamos en una variable aux ñ+1 dado que para strings no es lo mismo 0+1 que 1 al momento de validar por eso no se usa directamente ñ+1
                    if (evt.getSource().equals(Parar[ñ])) {//VALIDAMOS SI EL BOTON 0 FUE PULSADO
                        Thread[] ah = new Thread[12];                            //declaramos un arreglo de tipo thread 
                        Thread.enumerate(ah);                                    //usamos el arreglo para almacenar los hilos que tenemos corriendo
                        for (int l = 0; l < ah.length; l++) {                            //usamos el ciclo para hacer el barrido de el arreglo 
                            if (ah[l] != null) {                                     //para no imprimir las posiciones de le arreglo que sencuentreen en null osea que estan vacios para evitar que truene el programa
                                if (ah[l].getName().equals("Hilo "+aux)) {               //si el nombre de el hilo es igual al que queremos detener entonces:
                                    ah[l].suspend();                                       //detiene el hilo
                                }
                            }
                        }
                    }
                    }                    
                }
            });//agregamos un listener para ejecurtar acciones la ser presionado el boton
            Panel.add(Parar[j]);//añadimos el boton al panel

            Reiniciar[j] = new JButton("Reiniciar");//creamos un bon en la posicion j de nuestro arreglod e botones reiniciar
            Reiniciar[j].setSize(20, 10);//definimos el tamaño de el boton
            Reiniciar[j].setName("Reiniciar" + j);//le seteamos el nombre a el boton
            Reiniciar[j].addMouseListener(new java.awt.event.MouseAdapter() {//añadimos un listener para poder ejecutar las acciones al ser presionado
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    for(int k=0;k<10;k++){
                    int b=k+1;//aqui guardamos el valor de k mas uno dado que 0+1 no es igual a 1 en una cadena
                    if (evt.getSource().equals(Reiniciar[k])) {//VALIDAMOS SI EL BOTON 0 FUE PULSADO
                        Thread[] ah = new Thread[12];                            //declaramos un arreglo de tipo thread 
                        //System.out.println(Thread.currentThread());            //imprime el nombre del hilo que se esta corriendo actualmente
                        Thread.enumerate(ah);                                    //usamos el arreglo para almacenar los hilos que tenemos corriendo
                        for (int j = 0; j < ah.length; j++) {                            //usamos el ciclo para hacer el barrido de el arreglo 
                            if (ah[j] != null) {                                     //para no imprimir las posiciones de le arreglo que sencuentreen en null osea que estan vacios para evitar que truene el programa
                                if (ah[j].getName().equals("Hilo "+b)) {               //si el nombre de el hilo es igual al que queremos detener entonces:
                                    ah[j].resume();                                       //detiene el hilo
                                }
                            }
                        }
                    }
                    }
                }
            });
            Panel.add(Reiniciar[j]);
            j++;
            Panel.updateUI();
            System.out.println(j);
        } else {
            System.out.println("Alcanzo el numero maximo de hilos");
        }
    }//GEN-LAST:event_JB_AgregarActionPerformed

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_Agregar;
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables
    private class Hilo1 extends Thread {                     //creamos un hilo con el nombre cuenta

        @Override                                             //para poder sobre escribir el run de el hilo 
        public void run() {//dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[0].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

    private class Hilo2 extends Thread {                     //creamos un hilo con el nombre cuenta                                             //para poder sobre escribir el run de el hilo 

        @Override
        public void run() { //dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[1].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

    private class Hilo3 extends Thread {//creamos una clase hilo                                              

        @Override//para poder sobre escribir el run de el hilo                                      
        public void run() {//dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[2].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

    private class Hilo4 extends Thread {//creamos una clase hilo                                              

        @Override//para poder sobre escribir el run de el hilo                                      
        public void run() {//dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[3].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

    private class Hilo5 extends Thread {//creamos una clase hilo                                              

        @Override//para poder sobre escribir el run de el hilo                                      
        public void run() {//dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[4].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

    private class Hilo6 extends Thread {//creamos una clase hilo                                              

        @Override//para poder sobre escribir el run de el hilo                                      
        public void run() {//dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[5].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

    private class Hilo7 extends Thread {//creamos una clase hilo                                              

        @Override//para poder sobre escribir el run de el hilo                                      
        public void run() {//dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[6].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

    private class Hilo8 extends Thread {//creamos una clase hilo                                              

        @Override//para poder sobre escribir el run de el hilo                                      
        public void run() {//dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[7].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

    private class Hilo9 extends Thread {//creamos una clase hilo                                              

        @Override//para poder sobre escribir el run de el hilo                                      
        public void run() {//dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[8].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

    private class Hilo10 extends Thread {//creamos una clase hilo                                              

        @Override//para poder sobre escribir el run de el hilo                                      
        public void run() {//dentro de el run ponemos lo que queremos ejecutar al correr ele hilo
            int c = 0;                                        //declara mos una variable con el nombre c para usarla como contador
            while (true) {                                    //implementamos un ciclo
                if (c < 100) {
                    Eti[9].setText("CONTADOR " + c++);              //le seteamos a la etiqueta el contador y la leyenda contador para saber cuantas veces se implementa el hilo y aumentamos c en 1
                    try {
                        Thread.sleep(100);                       //para retrasar el hilo las milesismas de segundo inciadas 
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Hilo2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    c = 0;
                }
            }
        }
    }

}
