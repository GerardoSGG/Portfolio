cadena = input("Introduce una cadena por favor: ")
try:
	cadena = int(cadena)
	print("El valor escrito es un entero")
except:
	try:
		cadena = float(cadena)
		print("El valor escrito es de tipo float")
	except:
		print("El valor escrito es una cadena de caracteres")

