/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author mi bodega poncitlan
 */
public class Memox extends javax.swing.JFrame {
   int tamal;
   int [] imagen=new int[12];
    public void Asignar(int tam,int f[]){
    tamal=tam;
    imagen=f;
    }
private ImageIcon icono(String nom){
        ImageIcon img = new ImageIcon(getClass().getResource(nom));
        ImageIcon ico = new ImageIcon(img.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        return ico;
    }
    private void GeneraIco(){
        String noming;
        int im = 1;
        for(int j = 0; j < tamal/2; j++){
            for(int m=1;m<=12;m++){
            if(imagen[m]!=0){
            noming = "/juego/imagenes/"+imagen[m]+".jpg";
            iconos[j] = new ImageIcon();
            iconos[j] = icono(noming);
            j++;
            }
            }
           
        }
    }
    private void BtnMouseReleased(java.awt.event.MouseEvent evt){
        //Ciclo para recorrer 
        for(int j = 0; j < nc*nf; j++){
            if(evt.getSource() == Btn[j]){
                act = j;
            }
        }
        
        if(cont == 0){
            cont++;
            ant = act;
            
        }
        else if(ant==act){
            cont = 0;
        }
            else{
            //act tiene la carta 2
            //ant tiene la carta 1
            
            if(Btn[ant].getPressedIcon().toString().equals(Btn[act].getPressedIcon().toString())){
                Btn[act].setIcon(Btn[act].getPressedIcon());
                Btn[ant].setIcon(Btn[act].getPressedIcon());
                if(Btn[act].isEnabled()) pares++;
                Btn[act].setEnabled(false);
                Btn[ant].setEnabled(false);
                if(pares == tamal/2) JOptionPane.showMessageDialog(null, "Felicidades has ganado!!!"); 
            }
            cont = 0;
        }
    }
    
    
    GridLayout gl = new GridLayout();
    int nf, nc, ant, act, cont = 0, pares = 0;//Variables globales para conteo de pares y de cartas que se presionan
    JButton[] Btn = new JButton[16]; //arreglo de botones
    ImageIcon[] iconos = new ImageIcon[8];
    public Memox() {
        initComponents();    
    }
    
    public void  Metodo (){
    GeneraIco();
        this.setLocationRelativeTo(null);
        switch(tamal){
            
            case 4: {nf = 2; nc = 2; break;}
            case 8: {nf = 4; nc = 2; break;}
            case 16: {nf = 4; nc = 4; break;}
            default: {nf = 2; nc = 2; tamal = 4;break;}
        }
        this.setSize(550, 550);
        Panel1.setSize(nc*100+(110), nf*100+200*nf);
        gl.setColumns(nc);
        gl.setRows(nf);
        gl.setHgap(5);
        gl.setVgap(5);
        Panel1.setLayout(gl);
        //En el ciclo siguiente agregamos los botones al panel con el GridLayout
        ImageIcon ico = icono("/juego/Imagenes/reverso.jpg");
        int im = 0;
        
        for(int j = 0; j <(nf*nc); j++){
            Btn[j]= new JButton();
            Btn[j].setSize(100, 100);
            Btn[j].setIcon(ico);
            
            if(im > tamal/2-1){
                //Btn[j].setPressedIcon(Btn[j-op/2].getPressedIcon());
                Btn[j].setPressedIcon(iconos[j-tamal/2]);
            }
            else{
                //Btn[j].setPressedIcon( icono("/boton/imagenes/"+im+".png"));
                Btn[j].setPressedIcon(iconos[im]);
                im++;
            }
            
            Btn[j].setName("Btn"+j);
            Btn[j].addMouseListener(new java.awt.event.MouseAdapter(){
                public void mouseReleased(java.awt.event.MouseEvent evt){
                    BtnMouseReleased(evt);
                }
            });
            Panel1.add(Btn[j]);
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

        Panel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Memox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Memox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Memox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Memox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Memox().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    // End of variables declaration//GEN-END:variables
}
