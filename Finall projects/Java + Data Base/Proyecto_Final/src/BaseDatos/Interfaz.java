package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javafx.beans.binding.Bindings.or;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Interfaz extends javax.swing.JFrame {

    DefaultTableModel modelo;//Se declara un modelo para poder insertar la tabla con sus respectivas propiedades 
    Conexion verificar = new Conexion();//instanciamos la clase conexion
    Connection conexion = null;//declaramos una variable de tipo conexion con un valor nulo
    String a[][] = {};
    String encabezado[] = {"ID", "N° Control", "Nombre", "Especialidad", "Plan"};//establecemps el encabezado de cada columna
    int consultame=0;
    //Banderas
    boolean Vnc=false;//bandera para verificar el dato numero de control
    boolean Vnom=false;//bandera para verificar el dato nombre
    boolean Vesp=false;//bandera para verificar el dato especialidad
    boolean Vplan=false;//bandera para verificar el dato plan
    
    boolean Buscar=false;//bandera para verificar la accion buscar
    boolean Insertar=false;//bandera para verificar la accion insertar
    boolean Modificar=false;//bandera para verificar la accion modificar
    boolean Eliminar=false;//bandera para verifivar la accion eliminar
    
     boolean bandera=true,bandera2=true;//bandera que controla por el campo a buscar
    String buscar,eliminar;
     
    void Verificar_NC(){//metodo para verificar numero de control
    if (JTF_NC.getText().matches("[1,2,3,4,5,6,7,8,9,0]{8}") && !JTF_NC.getText().isEmpty()) {//valida que solo se ingresen 8 digitos
            Vnc = true;//si se cumple la condicion poner la bandera en true
        }else{JOptionPane.showMessageDialog(null, "Dato incorrecto en el campo numerod de control recuerde utilizar solo 8 digitos");}//si no se cumple imprimir un mensaje de que el datos es incorrecto 
    }
    
    void Verificar_Nom(){//metodo para verificar nombre
    if (JTF_Nom.getText().matches("[A-Z a-z ñ]*") && !JTF_Nom.getText().isEmpty()) {//valida que sean solo letras
            Vnom = true;//si se cumple poner la bandera en true
        }else{ JOptionPane.showMessageDialog(null, "Dato incorrecto en el campo nombre recuerde utilizar solo letras");}//si no se cumple imprimir un mensaje con un consejo 
    }
    
    void Verificar_Esp(){//metodo para verificar el campo especialidad
    if (JTF_Esp.getText().matches("[A-Z a-z ñ]*") && !JTF_Esp.getText().isEmpty()) {//valida que solo se ingresen solo letras
            Vesp = true;//si se cumple la condicion poner la bandera en true
        }else{JOptionPane.showMessageDialog(null, "Dato incorrecto en el campo especialida recuerde utilizar solo letras");}//si no se cumple imprimir un mensaje de que el datos es incorrecto 
    }
    
    void Verificar_Plan(){//metodo para verificar el plan
    if (JTF_Plan.getText().matches("[1,2,3,4,5,6,7,8,9,0]{4}") && !JTF_Plan.getText().isEmpty()) {//valida que solo se ingresen solo letras
            Vplan = true;//si se cumple la condicion poner la bandera en true
        }else{JOptionPane.showMessageDialog(null, "Dato incorrecto en el campo plan recuerde utilizar 4 digitos");}//si no se cumple imprimir un mensaje de que el datos es incorrecto 
    }
    
    public Interfaz() {
        initComponents();//inicia los componentes del frame
        modelo = (DefaultTableModel) JT_Tabla.getModel();//extraemos el modelo de la tabla
        modelo = new DefaultTableModel(a, encabezado);//le seteamos el nueevo encabezado a nuestra tabla
        JT_Tabla.setModel(modelo);//Le seteamos el nuevo modelo a nuestra tabla
        this.setLocationRelativeTo(null);//Centramos el frame en la pantalla
        this.setTitle("Base de Datos");//insertamos un titulo a nuestro frame
    }
    
     //Metodo que realiza una consulta en la base de datos, que dependiendo de los parametros que reciba, sera de una manera especifica de a cuerdo a lo que se requiera
    boolean consulta(String eb, int tipo, boolean busca) {
        //Se instancia una nueva tabla cada vez que se consulten los datos para poder hacerlo de manera correcta
        modelo = (DefaultTableModel) JT_Tabla.getModel();
        modelo = new DefaultTableModel(a, encabezado);
        JT_Tabla.setModel(modelo);
        //Contener el num de registro consulta
        int nr = 0;
        //Generar mi consulta
        String cons = eb;
        String[] arr = new String[5];
        boolean esta = false;
        //Se intenta hacer la consulta de los datos en la base de datos, si es exitosa muestra los datos de manera que se requiera, de lo contrario muestra el error,
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(cons);
            //Si existen datos se mostraran, de lo contrario se mostrara un mensaje con el error
            if(consultame==0){
            if (rs.next()) {
                //Como se verifico la existencia de datos, el puntero apunta a un segundo dato, asi que regresamos el puntero al primer dato de la consulta
                rs.beforeFirst();
                esta = true;
                //Mientras que existan datos
                while ((rs.next()) && (!busca)) {
                    arr[0] = rs.getString(1);
                    arr[1] = rs.getString(2);
                    arr[2] = rs.getString(3);
                    arr[3] = rs.getString(4);
                    arr[4] = rs.getString(5);
                    //Si tipo es igual a cero, hace una consulta general
                    if (tipo == 0) {
                        modelo.addRow(arr);
                        //de lo contrario, hace una consulta particular de un dato
                    } else {
                        //Mostramos unicamente el dato buscado en la tabla
                        modelo.addRow(arr);
                        //Mostramos los datos en los campos de texto
                        JTF_NC.setText(arr[1]);
                        JTF_Nom.setText(arr[2]);
                        JTF_Esp.setText(arr[3]);
                        JTF_Plan.setText(arr[4]);
                    }
                }
            //Si no existe el dato que se busco, se notificara al usuario con un mensaje
            } else {
                if(Menu.getSelectedIndex()!=2){
                JOptionPane.showMessageDialog(null, "No existe el dato");
                consultame++;
                }
                if(con==true)
                consulta("SELECT * FROM `alumno` ", 0, false);
            }}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return esta;
    }
 
    //Boton que hace la funcion de verificar la conexion a la base de datos y muestra un mensaje si existe dicha conexion o no
    private void btn_conectaActionPerformed(java.awt.event.ActionEvent evt) {                                            
        conexion = verificar.conexion();
        if (conexion != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("No conectado");
        }
    }                                           
    boolean con=false;
    //Boton que hace una consulta general de los datos y los agrega a la tabla
    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        con=true;
        consulta(" SELECT * FROM `alumno` ", 0, false);
    }            

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JT_Tabla = new javax.swing.JTable();
        BTN_Salir = new javax.swing.JButton();
        BTN_CGeneral = new javax.swing.JButton();
        Menu = new javax.swing.JComboBox<>();
        BTN_VConexion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTF_NC = new javax.swing.JTextField();
        JTF_Nom = new javax.swing.JTextField();
        JTF_Plan = new javax.swing.JTextField();
        JTF_Esp = new javax.swing.JTextField();
        BTN_Ejecutar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JT_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(JT_Tabla);

        BTN_Salir.setText("Salir");
        BTN_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SalirActionPerformed(evt);
            }
        });

        BTN_CGeneral.setText("Consulta General");
        BTN_CGeneral.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 255), new java.awt.Color(0, 204, 204), new java.awt.Color(0, 204, 204), new java.awt.Color(51, 0, 102)));
        BTN_CGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CGeneralActionPerformed(evt);
            }
        });

        Menu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Menu", "Buscar", "Insertar", "Modificar", "Eliminar" }));
        Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuActionPerformed(evt);
            }
        });

        BTN_VConexion.setText("Verificar Conexion");
        BTN_VConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VConexionActionPerformed(evt);
            }
        });

        jLabel1.setText("Numero de control");

        jLabel2.setText("Nombre");

        jLabel3.setText("Especialidad");

        jLabel4.setText("Plan");

        JTF_Plan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTF_PlanActionPerformed(evt);
            }
        });

        BTN_Ejecutar.setText("Ejecutar");
        BTN_Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTN_VConexion)
                        .addGap(38, 38, 38)
                        .addComponent(BTN_CGeneral)
                        .addGap(44, 44, 44)
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(BTN_Salir)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(JTF_NC)
                                    .addComponent(JTF_Nom, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTF_Esp)
                                    .addComponent(JTF_Plan))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_Ejecutar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(JTF_NC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Ejecutar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTF_Esp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(JTF_Plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Salir)
                    .addComponent(BTN_CGeneral)
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_VConexion))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTF_PlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTF_PlanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTF_PlanActionPerformed

    private void BTN_VConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VConexionActionPerformed
        conexion = verificar.conexion();

        if (conexion != null) {//Verificamos si conexion es distinto de null
            System.out.println("Conectado");//imprime conectado si se realiza la conexion
        } else {//si es igual a null entonces
            System.out.println("No conectado");//imprime no conectado en caso de que nopueda hacer la conexion
        }
    }//GEN-LAST:event_BTN_VConexionActionPerformed
void insertar() {
        String cons = "INSERT INTO `alumno`(ID, NC, NOM, ESP, PLAN) VALUES (NULL ,'" + JTF_NC.getText().toUpperCase() + "','" + JTF_Nom.getText().toUpperCase() + "' , '" + JTF_Esp.getText().toUpperCase() + "', '" + JTF_Plan.getText().toUpperCase() + "');";
        //Se intenta hacer la insercion de los datos en la Base de Datos, si es exitosa se mostraran los datos, de lo contrario se muestra el error
        try {
      if((!consulta(" SELECT * FROM `alumno` WHERE NC=" + JTF_NC.getText().toUpperCase(), 1, false))&&(Vnc==true)){//Verifica que el numero de ocntrol no se repita
            Statement st = conexion.createStatement();
            st.execute(cons);
            consulta("SELECT * FROM `alumno` ", 0, false);
            }else{
            JOptionPane.showMessageDialog(null, "YA EXISTE ESTE NUMERO DE CONTROL EN LA BASE DE DATOS");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private void BTN_CGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CGeneralActionPerformed
        consultame=0;
        conexion = verificar.conexion();//establece la conexion
        con=true;
        consulta(" SELECT * FROM `alumno` ", 0, false);    
    }//GEN-LAST:event_BTN_CGeneralActionPerformed

    private void MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuActionPerformed
        conexion = verificar.conexion();
        consultame=0;
        try{
        if((Menu.getSelectedItem().toString()).equals("Menu")){JOptionPane.showMessageDialog(null, "Seleccione una opcion a ejecutar ");}        
        if((Menu.getSelectedItem().toString()).equals("Buscar")){//si el item seleccionado es buscar poner la variable buscar en ttrue y las demas en false
        bandera=true;
         Buscar=true;
         Insertar=false;
         Modificar=false;
         Eliminar=false;
        while(bandera){ //mientras no seleccione un campo correcto
            try{
        buscar= JOptionPane.showInputDialog("Por cual dato desea buscar");//preguntamos al usuario por cual campo deseamos buscar
        if(buscar!=null){
        if(!buscar.matches("[Numero de control]*[Nombre]*[Especialidad]*[Plan]*")){//validamos que el campo este bien escrito
        JOptionPane.showMessageDialog(null, "EL campo a buscar esta mal escrito ingreselo nuevamente recuerde que debe ser igual al de la descripcion");
        }else{bandera=false;//si el dato es correcto poner la bandera en null para detener el ciclo
        JOptionPane.showMessageDialog(null, "EL campo es valido por favor llene el campo que selecciono con el dato a buscar y despues de click en ejecutar");
        }}else{
        bandera=false;
        buscar=" ";
        JOptionPane.showMessageDialog(null, "Selecciona una opcion");
        }} catch (Exception e) {
        }        
        }
         
        }
        //si el item seleccionado es inserta poner la variable insertar en true y las demas en false 
        if((Menu.getSelectedItem().toString()).equals("Insertar")){
         Buscar=false;
         Insertar=true;
         Modificar=false;
         Eliminar=false;
        }
        //si el item seleccionado es Modificar poner la variable Modificar en true y las demas en false
        if((Menu.getSelectedItem().toString()).equals("Modificar")){
         Buscar=false;
         Insertar=false;
         Modificar=true;
         Eliminar=false;
        }
        //si el item seleccionado es Eliminar poner la variable Eliminar en true y las demas en false
        if((Menu.getSelectedItem().toString()).equals("Eliminar")){
         bandera2=true;
         Buscar=false;
         Insertar=false;
         Modificar=false;
         Eliminar=true;
         while(bandera2){ //mientras no seleccione un campo correcto
            try{
         eliminar= JOptionPane.showInputDialog("Por cual dato desea buscar el dato a eliminar");//preguntamos al usuario por cual campo deseamos buscar
        if(eliminar!=null){
        if(!eliminar.matches("[Numero de control]*[Nombre]*[Especialidad]*[Plan]*")){//validamos que el campo este bien escrito
        JOptionPane.showMessageDialog(null, "EL campo a buscar esta mal escrito ingreselo nuevamente recuerde que debe ser igual al de la descripcion");
        }else{bandera2=false;//si el dato es correcto poner la bandera en null para detener el ciclo
        JOptionPane.showMessageDialog(null, "EL campo es valido por favor llene el campo que selecciono con el dato a buscar y despues de click en ejecutar");
        }}else{
        bandera2=false;
        eliminar=" ";
        JOptionPane.showMessageDialog(null, "Selecciona una opcion");
        }} catch (Exception e) {
        }        
        }
        }
        }catch(Exception e){JOptionPane.showMessageDialog(null, "Seleccione primero una opcion a ejecutar");}   
    }//GEN-LAST:event_MenuActionPerformed

    private void BTN_EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EjecutarActionPerformed
      conexion = verificar.conexion();//establece la conexion
      consultame=0;  
//opcion para busar
        if(Buscar==true){
        if(buscar.equals("Numero de control")){
        //Primero se verifica que el dato sean solo numeros, si es correcto, hara la consulta, de lo contrario se mostrara el error
        String aux = JTF_NC.getText();
        Verificar_NC();
        if (Vnc==true) {
            consulta(" SELECT * FROM `alumno` WHERE NC=" + JTF_NC.getText().toUpperCase(), 1, false);
        } else if (con==true ){           
            consulta("SELECT * FROM alumno", 0, false);
        }
        }
        
        if(buscar.equals("Nombre")){
        //Se verifica el dato con el metodo
        Verificar_Nom();
        if (Vnom==true) {
            consulta(" SELECT * FROM `alumno` WHERE nom LIKE '" + JTF_Nom.getText().toUpperCase()+"'", 1, false);
        } else if (con==true ){           
            consulta("SELECT * FROM alumno", 0, false);
        }
        }
       
        if(buscar.equals("Especialidad")){
        //Se verifica el dato con el metodo
        Verificar_Esp();
        if (Vesp==true) {//si la valdiacion es correcta entonces
         consulta(" SELECT * FROM `alumno` WHERE esp LIKE '" + JTF_Esp.getText().toUpperCase()+"'", 1, false);//busca el dato   
        } else if (con==true ){           
            consulta("SELECT * FROM alumno", 0, false);//si no hace una consulta general
        }
        }
        if(buscar.equals("Plan")){//si busacar es igual a plan        
        Verificar_Plan();//validar el dato del campo plan
        if (Vplan==true) {//si la validacion es correcta
            consulta(" SELECT * FROM `alumno` WHERE plan=" + JTF_Plan.getText().toUpperCase(), 1, false);//buscar el dato en la tabla
        } else{ if (con==true ){           
            consulta("SELECT * FROM alumno", 0, false);}
        }
        }  
       }
        //termina opcion para buscar
       //inicia opcion para insertar
       if(Insertar==true){
       Verificar_NC();
       Verificar_Nom();
       Verificar_Esp();
       Verificar_Plan();
           if (Vnc==true && Vnom==true && Vesp==true && Vplan==true ) {
            insertar();
        } else {
            JOptionPane.showMessageDialog(null, "Error, revisa que los datos sean correctos");
        }
       }
       //termina opcion para insertat
       //comienza opcion para modificar
       if(Modificar==true){
       //Se hace la llamada del metodo que verifica que los datos sean correctos, si es asi, prosigue con la modificacion del dato
        Verificar_NC();
        Verificar_Nom();
        Verificar_Plan();
        Verificar_Esp();
        if (Vnc==true && Vnom==true && Vesp==true && Vplan==true) {
            //Se intenta hacer la consulta del dato a moficiar, si existe, se hace la modificacion con los datos que se encuentren en los campos de texto
            try {
                if (consulta("SELECT * FROM alumno WHERE nc='" + JTF_NC.getText() + "'", 1, true)) {
                    PreparedStatement cons = conexion.prepareStatement("UPDATE alumno SET nom='" + JTF_Nom.getText().toUpperCase() + "',esp='" + JTF_Esp.getText().toUpperCase() + "',plan='" + JTF_Plan.getText().toUpperCase() + "' WHERE nc='" + JTF_NC.getText() + "'");
                    cons.executeUpdate();
                    consulta("SELECT * FROM alumno", 0, false);
                    JOptionPane.showMessageDialog(null, "Dato modificado correctamente");
                } else  if (con==true){
                    consulta("SELECT * FROM alumno", 0, false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
            }
        } else{
            JOptionPane.showMessageDialog(null, "Error, revisa los datos");
            JOptionPane.showMessageDialog(null, "Si hay campos vacios se recomienda  hacer una busqueda del dato que desea modificar seleccione buscar y ejecutar");
        }
       }
       //terminar modificar
        if(Eliminar==true){
        if(eliminar.equals("Numero de control")){
        Verificar_NC();
            if(Vnc==false){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de control de quien desea borrar sus datos posteriormente de click en ejecutar");
            }//Se verifica que el dato a eliminar exista en la BD si es asi, se borraran los campos correspondientes, si no existe se notifica con un mensaje
        boolean Existe = false;
        //Se intenta hacer la consulta en la base de datos para eliminar el dato requerido
        try {
            if (consulta("SELECT * FROM alumno WHERE nc='" + JTF_NC.getText() + "'", 1, true)) {
                PreparedStatement cons = conexion.prepareStatement("DELETE FROM alumno WHERE nc='" + JTF_NC.getText() + "'");
                cons.executeUpdate();
                consulta("SELECT * FROM alumno", 0, false);
                Existe= true;
            } else if (con==true ){
                consulta("SELECT * FROM alumno", 0, false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
        //Si se encontro el dato y se elimino correctamente, se pondran en blanco los campos de texto y se mostrara un mensaje de que el dato fue borrado correctamente
        if (Existe == true) {
            JTF_NC.setText("");
            JTF_Nom.setText("");
            JTF_Esp.setText("");
            JTF_Plan.setText("");
            JOptionPane.showMessageDialog(null, "Dato borrado correctamente");

        }
        }
        
        if(eliminar.equals("Nombre")){
        Verificar_Nom();
            if(Vnom==false){
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de quien desea borrar sus datos posteriormente de click en ejecutar");
            }//Se verifica que el dato a eliminar exista en la BD si es asi, se borraran los campos correspondientes, si no existe se notifica con un mensaje
        boolean Existe = false;
        //Se intenta hacer la consulta en la base de datos para eliminar el dato requerido
        try {
            if (consulta(" SELECT * FROM `alumno` WHERE nom LIKE '" + JTF_Nom.getText().toUpperCase()+"'", 1, false)) {
                System.out.println("si es igual");
                PreparedStatement cons = conexion.prepareStatement("DELETE FROM alumno WHERE nom='" + JTF_Nom.getText() + "'");
                cons.executeUpdate();
                consulta("SELECT * FROM alumno", 0, false);
                Existe= true;
            } else if (con==true ){
                consulta("SELECT * FROM alumno", 0, false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
        //Si se encontro el dato y se elimino correctamente, se pondran en blanco los campos de texto y se mostrara un mensaje de que el dato fue borrado correctamente
        if (Existe == true) {
            JTF_NC.setText("");
            JTF_Nom.setText("");
            JTF_Esp.setText("");
            JTF_Plan.setText("");
            JOptionPane.showMessageDialog(null, "Dato borrado correctamente");

        }
        }
       
        if(eliminar.equals("Especialidad")){
        Verificar_Esp();
            if(Vesp==false){
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de quien desea borrar sus datos posteriormente de click en ejecutar");
            }//Se verifica que el dato a eliminar exista en la BD si es asi, se borraran los campos correspondientes, si no existe se notifica con un mensaje
        boolean Existe = false;
        //Se intenta hacer la consulta en la base de datos para eliminar el dato requerido
        try {
            if (consulta(" SELECT * FROM `alumno` WHERE esp LIKE '" + JTF_Esp.getText().toUpperCase()+"'", 1, false)) {
                PreparedStatement cons = conexion.prepareStatement("DELETE FROM alumno WHERE esp='" + JTF_Esp.getText() + "'");
                cons.executeUpdate();
                consulta("SELECT * FROM alumno", 0, false);
                Existe= true;
            } else if (con==true ){
                consulta("SELECT * FROM alumno", 0, false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
        //Si se encontro el dato y se elimino correctamente, se pondran en blanco los campos de texto y se mostrara un mensaje de que el dato fue borrado correctamente
        if (Existe == true) {
            JTF_NC.setText("");
            JTF_Nom.setText("");
            JTF_Esp.setText("");
            JTF_Plan.setText("");
            JOptionPane.showMessageDialog(null, "Dato borrado correctamente");

        }
        }
        
        if(eliminar.equals("Plan")){//si busacar es igual a plan        
        Verificar_Plan();
            if(Vplan==false){
            JOptionPane.showMessageDialog(null, "Ingrese el numero de control de quien desea borrar sus datos posteriormente de click en ejecutar");
            }//Se verifica que el dato a eliminar exista en la BD si es asi, se borraran los campos correspondientes, si no existe se notifica con un mensaje
        boolean Existe = false;
        //Se intenta hacer la consulta en la base de datos para eliminar el dato requerido
        try {
            if (consulta("SELECT * FROM alumno WHERE plan='" + JTF_Plan.getText() + "'", 1, true)) {
                PreparedStatement cons = conexion.prepareStatement("DELETE FROM alumno WHERE plan='" + JTF_Plan.getText() + "'");
                cons.executeUpdate();
                consulta("SELECT * FROM alumno", 0, false);
                Existe= true;
            } else if (con==true ){
                consulta("SELECT * FROM alumno", 0, false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
        //Si se encontro el dato y se elimino correctamente, se pondran en blanco los campos de texto y se mostrara un mensaje de que el dato fue borrado correctamente
        if (Existe == true) {
            JTF_NC.setText("");
            JTF_Nom.setText("");
            JTF_Esp.setText("");
            JTF_Plan.setText("");
            JOptionPane.showMessageDialog(null, "Dato borrado correctamente");

        }
        }
        
        }
    }//GEN-LAST:event_BTN_EjecutarActionPerformed

    private void BTN_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SalirActionPerformed
    System.exit(0);
    }//GEN-LAST:event_BTN_SalirActionPerformed

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
    private javax.swing.JButton BTN_CGeneral;
    private javax.swing.JButton BTN_Ejecutar;
    private javax.swing.JButton BTN_Salir;
    private javax.swing.JButton BTN_VConexion;
    private javax.swing.JTextField JTF_Esp;
    private javax.swing.JTextField JTF_NC;
    private javax.swing.JTextField JTF_Nom;
    private javax.swing.JTextField JTF_Plan;
    private javax.swing.JTable JT_Tabla;
    private javax.swing.JComboBox<String> Menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
