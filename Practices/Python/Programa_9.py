import os
import re

op = 0
datos = []
while(op!=5):
	op = int(input("""Menu de opciones
		1- Insertar datos
		2- Buscar dato
		3- Modificar dato
		4- Borrar dato
		5- Salir
		Opcion a seleccionar : """))
	if op == 1:
		agrega = []
		agrega.append(input("Introduce tu nombre : "))
		agrega.append(input("Introduce tu domicilio : "))
		agrega.append(input("Introduce tu telefono : "))
		agrega.append(input("Introduce tu correo electronico : "))
		redes = []
		red = "yo"
		print("Escribe tus redes sociales, para dejar de ingresar una nueva, introduce un cero")
		while red != "0":
			red = str(input("Escribe una red social : "))
			if red != "0" :
				redes.append(red)
		agrega.append(redes)
		datos.append(agrega)
	elif op == 2:
		if len(datos) > 0 :
			fueEncontrado = False
			busca = input("Escribe el nombre del dato a buscar : ")
			for i in datos:
				if i[0] == busca:
					print("Dato encontrado")
					print("Nombre : ",i[0])
					print("Domicilio : ",i[1])
					print("Telefono : ",i[2])
					print("Correo electronico : ",i[3])
					print("Redes sociales : ")
					for a in i[4]:
						print (a)
					fueEncontrado = True
					break
			if fueEncontrado == False:
				print("Dato no encontrado")
		else :
			print("No hay datos guardados")
	elif op == 3:
		if len(datos) > 0 :
			indice = 0
			fueEncontrado = False
			busca = input("Introduce el nombre del dato a buscar : ")
			for i in datos:
				if i[0] == busca:
					print("Dato encontrado")
					print("Nombre : ",i[0])
					print("Domicilio : ",i[1])
					print("Telefono : ",i[2])
					print("Correo electronico : ",i[3])
					print("Redes sociales : ")
					for a in i[4]:
						print (a)
					fueEncontrado = True
					while True:
						confirma = int(input("Desea modificar dicho dato? 1-Si 2-No : "))
						if confirma == 1:
							nuevo = []
							nuevo.append(i[0])
							nuevo.append(input("Introduce tu domicilio : "))
							nuevo.append(input("Introduce tu telefono : "))
							nuevo.append(input("Introduce tu correo electronico : "))
							redes = []
							red = "yo"
							print("Introduce tus redes sociales, para dejar de ingresar una nueva, introduce un cero")
							while red != "0":
								red = str(input("Introduce una red social : "))
								if red != "0" :
									redes.append(red)
							nuevo.append(redes)
							datos.pop(indice)
							datos.append(nuevo)
							print("Dato modificado correctamente")
							break
						elif confirma == 2:
							print("El dato no fue modificado")
							break
						else :
							print("Elige una de las dos opciones validas")
					break
				indice += 1
			if fueEncontrado == False:
				print("Dato no encontrado")
		else :
			print("No hay datos guardados, primero debes de ingresar alguno")
	elif op == 4:
		if len(datos) > 0 :
			indice = 0
			fueEncontrado = False
			busca = input("Introduce el nombre del dato a buscar : ")
			for i in datos:
				if i[0] == busca:
					print("Dato encontrado")
					print("Nombre : ",i[0])
					print("Domicilio : ",i[1])
					print("Telefono : ",i[2])
					print("Correo electronico : ",i[3])
					print("Redes sociales : ")
					for a in i[4]:
						print (a)
					fueEncontrado = True
					while True:
						confirma = int(input("Desea eliminar dicho dato? 1-Si 2-No : "))
						if confirma == 1:
							datos.pop(indice)
							print("Dato eliminado correctamente")
							break
						elif confirma == 2:
							print("El dato no fue eliminado")
							break
						else :
							print("Elige una de las dos opciones validas")
					break
				indice += 1
			if fueEncontrado == False:
				print("Dato no encontrado")
		else :
			print("No hay datos guardados")
	elif op == 5:
		print("Hasta pronto")
	else:
		print("Elige una opcion valida")