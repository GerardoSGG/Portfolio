
package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
       //Establecer variable para efectuar conexion a BD
    Connection conectar=null;
    //Regresa null si no logra conectar
    //Caso contrario regresa URL de la BD
    public Connection conexion(){
        //Intenta establecer un punto de conexion con BD
        try{
            Class.forName("com.mysql.jdbc.Driver");//instanciamos el conecttor a la base de datos
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/escuela","root","");//indicamos la direccion donde se establecera la conexion
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return conectar;//nos devuelve el valor de conectar
    } 
}
