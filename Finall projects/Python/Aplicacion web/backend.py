#importacion de flask
from flask import Flask, render_template, request,redirect,  url_for,flash #templeate para poder llamar las plantillas de html
#importamos mysql para poder realizar la conexion a la base de datos
from flask_mysqldb import MySQL

Backend = Flask (__name__)
#parametros del servidor y la base de datos
Backend.config['MYSQL_HOST']= 'localhost'
Backend.config['MYSQL_USER']= 'root'#usuario
Backend.config['MYSQL_PASSWORD']= ''#contraseña del usuario
Backend.config['MYSQL_DB']= 'contactos'#nombre de la base de datos
Backend.secret_key='asd'

#pasamos los parametros para realizar la conexion
mysql = MySQL(Backend)

#se establece lo que se retorna cada que el usuario ingresa a la pagina principal
@Backend.route('/')
def principal():
    #establece la conexion con la base de datos
    cur = mysql.connection.cursor()
    #lanza una consulta general DE LA TABLA DATOS
    cur.execute('SELECT * FROM datos')
    #guarda los datos obtenidos en la consulta en la variable datos_r
    datos_r=cur.fetchall()
    print(datos_r)
    return render_template('formulario_agregar.html',datos_re=datos_r)

#establece lo que se retorna al ingresar a añadir contacto
@Backend.route('/add_contact' ,methods=['POST'])#para poder traer datos
def add_contact():
    if request.method == 'POST':
        nombre_r= request.form['nombre']#guardamos el dato recibid en la variable nombre_r
        telefono_r= request.form['telefono']#guardamos el dato recibido 
        email_r= request.form['email']#guardamos el dato recibido
        fecha_r= request.form['fecha']#guardamos el dato recibido
        cur = mysql.connection.cursor()
        cur.execute('INSERT INTO datos (nombre, telefono, correo, fecha) VALUES (%s, %s, %s, %s)',
        (nombre_r,telefono_r,email_r,fecha_r))
        mysql.connection.commit()
        flash('Contacto guardado exitosamente')
        return redirect(url_for('principal'))#nos retorna a la pagina principal


#establece lo que se retorna al ingresar a editar contacto
@Backend.route('/edit_contact/<id>')
def edit_contact(id):
    cur = mysql.connection.cursor()
    #Realizamos una consulta particular a partir del id
    cur.execute('SELECT * FROM datos WHERE id = '+id)
    data=cur.fetchall()
    #enviamos los datos obtenidos y abrimos la pagina con el formulario apra editar
    return render_template('editar.html',datos_re=data[0])


#establece lo que se retorna al ingresar a borrar contacto
@Backend.route('/delete_contact/<string:id>')
def delete_contact(id):
    cur = mysql.connection.cursor()
    #enviamos la consulta para  borrar el dato que coincida con el id recibido
    cur.execute('DELETE FROM datos WHERE id = {0}'.format(id))
    mysql.connection.commit()
    flash('Dato eliminado')
    #regresamos a la pagina principal
    return redirect(url_for('principal'))

#establece lo que se retorna al ingresar a editar contacto
@Backend.route('/con_general')
def con_general():
   #establece la conexion con la base de datos
    cur = mysql.connection.cursor()
    #lanza una consulta general DE LA TABLA DATOS
    cur.execute('SELECT * FROM datos')
    #guarda los datos obtenidos en la consulta en la variable datos_r
    datos_r=cur.fetchall()
    #nos direcciona a la pagina donde se muestra la consulta general
    return render_template('consulta_general.html',datos_re=datos_r)

@Backend.route('/refresca/<id>',methods=['POST'])
def refresca_contact(id):
    if request.method == 'POST':
        nombre_r = request.form['nombre']
        telefono_r = request.form['telefono']
        email_r = request.form['email']
        fecha_r = request.form['fecha']
        cur = mysql.connection.cursor()
        cur.execute( """
                    UPDATE datos 
                    SET nombre = %s,
                        telefono = %s,
                        correo = %s,
                        fecha = %s
                    WHERE id = %s
                    """,(nombre_r,telefono_r,email_r,fecha_r,id) )
        mysql.connection.commit()
        flash('Datos actualizados')
        return redirect(url_for('con_general'))
        
#valida que se cuente con una pagina principal
if __name__ == '__main__':
    Backend.run(port = 3000, debug = True)
        
    
