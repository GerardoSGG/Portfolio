import os
import re

op = 0
datos = {}
posicion = 0
while(op!=5):
	op = int(input("""Menu de opciones
		1- Insertar datos
		2- Buscar dato
		3- Modificar dato
		4- Borrar dato
		5- Salir
		Opcion : """))
	if op == 1:
		nuevo = []
		nombre = input("Introduce tu nombre : ")
		nuevo.append(input("Introduce tu domicilio : "))
		nuevo.append(input("Introduce tu telefono : "))
		nuevo.append(input("Introduce tu correo electronico : "))
		redes = []
		red = "mi red"
		print("Introduce tus redes sociales, para dejar de ingresar una nueva, introduce un cero")
		while red != "0":
			red = str(input("Introduce una red social : "))
			if red != "0" :
				redes.append(red)
		nuevo.append(redes)
		datos[nombre] = nuevo
	elif op == 2:
		if len(datos) > 0 :
			encontrado = False
			busca = input("Introduce el nombre del dato a buscar : ")
			for i in datos:
				if i == busca:
					lista = datos[i]
					print("Dato encontrado")
					print("Nombre : ",i)
					print("Domicilio : ",lista[0])
					print("Telefono : ",lista[1])
					print("Correo electronico : ",lista[2])
					#print("Redes sociales : ")
					sociales = lista[3]
					for a in sociales:
						print ("Redes sociales : ",a )
					encontrado = True
					break
			if encontrado == False:
				print("Dato no encontrado")
		else :
			print("No hay datos guardados, primero debes de ingresar alguno")
	elif op == 3:
		if len(datos) > 0 :
			indice = 0
			encontrado = False
			busca = input("Introduce el nombre del dato a buscar : ")
			for i in datos:
				if i == busca:
					lista = datos[i]
					print("Dato encontrado")
					print("Nombre : ",i)
					print("Domicilio : ",lista[0])
					print("Telefono : ",lista[1])
					print("Correo electronico : ",lista[2])
					print("Redes sociales : ")
					sociales = lista[3]
					for a in sociales:
						print ("Redes sociales : ",a )
					encontrado = True
					while True:
						confirma = int(input("Desea modificar dicho dato? 1-Si 2-No : "))
						if confirma == 1:
							nuevo = []
							nombre = i
							nuevo.append(input("Introduce tu domicilio : "))
							nuevo.append(input("Introduce tu telefono : "))
							nuevo.append(input("Introduce tu correo electronico : "))
							redes = []
							red = "Mi red"
							print("Introduce tus redes sociales, para dejar de ingresar una nueva, introduce un cero")
							while red != "0":
								red = str(input("Introduce una red social : "))
								if red != "0" :
									redes.append(red)
							nuevo.append(redes)
							datos.pop(i)
							datos[nombre] = nuevo
							print("Dato modificado correctamente")
							break
						elif confirma == 2:
							print("El dato no fue modificado")
							break
						else :
							print("Elige una de las dos opciones validas")
					break
				indice += 1
			if encontrado == False:
				print("Dato no encontrado")
		else :
			print("No hay datos guardados, primero debes de ingresar alguno")
	elif op == 4:
		if len(datos) > 0 :
			indice = 0
			encontrado = False
			busca = input("Introduce el nombre del dato a buscar : ")
			for i in datos:
				if i == busca:
					lista = datos[i]
					print("Dato encontrado")
					print("Nombre : ",i)
					print("Domicilio : ",lista[0])
					print("Telefono : ",lista[1])
					print("Correo electronico : ",lista[2])
					sociales = lista[3]
					for a in sociales:
						print ("Redes sociales : ",a )
					encontrado = True
					while True:
						confirma = int(input("Desea eliminar dicho dato? 1-Si 2-No : "))
						if confirma == 1:
							datos.pop(i)
							print("Dato eliminado correctamente")
							break
						elif confirma == 2:
							print("El dato no fue eliminado")
							break
						else :
							print("Elige una de las dos opciones validas")
					break
				indice += 1
			if encontrado == False:
				print("Dato no encontrado")
		else :
			print("No hay datos guardados, primero debes de ingresar alguno")
	elif op == 5:
		print("Hasta pronto")
	else:
		print("Elige una opcion valida")
