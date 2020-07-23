import os
import re
from os import remove

op = 0
while(op!=5):
	op = int(input("""Menu de opciones
		1- Insertar datos
		2- Buscar dato
		3- Modificar dato
		4- Borrar dato
		5- Salir
		Opcion : """))
	if op == 1:
		bien = False
		encontrado = False
		if os.path.isfile("archivo.txt"):
			archivo = open("archivo.txt","r")
			while bien == False:
				nombre  = input("Introduce tu nombre : ")
				for i in archivo:
					patron = re.search(nombre,i)
					if str(patron) != "None":
						print("Ese nombre ya existe")
						encontrado = True
						break
					else:
						continue
				if encontrado == False:
					bien = True
			archivo.close()
		else :
			nombre  = input("Introduce tu nombre : ")
		domicilio = input("Introduce tu Domicilio : ")
		telefono = input("Introduce tu Telefono : ")
		if os.path.isfile("archivo.txt"):
			archivo = open("archivo.txt","a")
		else:
			archivo = open("archivo.txt","w")

		archivo.write("Nombre : " + nombre + "\n")
		archivo.write("Domicilio : " + domicilio + "\n")
		archivo.write("Telefono : " + telefono + "\n")
		archivo.close()
	elif op == 2:
		if os.path.isfile("archivo.txt"):
			vueltas = 2
			encontrado = False
			busca = input("Introduce el nombre a buscar : ")
			archivo = open("archivo.txt","r")
			for i in archivo:
				if len(i) > 1 :
					if encontrado==True and vueltas > 0:
						print(i)
						vueltas -= 1
					patron = re.search(busca,i)
					if str(patron) != "None":
						print("Dato encontrado")
						print(i)
						encontrado = True
			if encontrado == False:
				print("Dato no encontrado")
			archivo.close()
		else:
			print("El archivo de datos no ha sido creado, primero creelo por favor")
	elif op == 3:
		datos = []
		vueltas = 2
		encontrado = False
		modifica = False
		lon = 0
		busca = input("Introduce el nombre a buscar : ")
		archivo = open("archivo.txt","r")
		for i in archivo:
			if len(i) > 1:
				patron = re.search(busca,i)
				if encontrado==True and vueltas > 0:
					if vueltas == 2:
						Domicilio = input("Introduce el nuevo Domicilio : ")
						datos.append("Domicilio : " +Domicilio + "\n")
					if vueltas == 1:
						Telefono = input("Introduce el nuevo Telefono : ")
						datos.append("Telefono : " +Telefono + "\n")
					vueltas -= 1
					if vueltas == 0:
						encontrado = False
				if str(patron) != "None":
					print("Dato encontrado, ingresa los nuevos datos a guardar")
					datos.append(i)
					encontrado = True
					modifica = True
				else :
					if encontrado == False:
						datos.append(i)
				lon += 1
		archivo.close()
		if modifica == False:
			print("Dato no encontrado")
		else:
			remove("archivo.txt")
			archivo = open("archivo.txt","w")
			for i in range(0,lon):
				archivo.write(datos[i] + "\n")
			archivo.close()
	elif op == 4:
		datos = [] 
		vueltas = 2
		encontrado = False
		lon = 0
		busca = input("Introduce el nombre a buscar : ")
		archivo = open("archivo.txt","r")
		for i in archivo:
			if len(i) > 1:
				patron = re.search(busca,i)
				if encontrado==True and vueltas > 0:
					vueltas -= 1
					continue
				if str(patron) != "None":
					print("Dato encontrado, borrando del archivo")
					encontrado = True
				else :
					lon += 1
					datos.append(i)
		archivo.close()
		if encontrado == False:
			print("Dato no encontrado")
		else:
			remove("archivo.txt")
			archivo = open("archivo.txt","w")
			for i in range(0,lon):
				archivo.write(datos[i] + "\n")
			archivo.close()
	elif op == 5:
		print("Bye")
	else:
		print("Elige una opcion valida")
