import os
nombre = input('Escribe tu nombre')
nControl =input('Escribe tu numero de control')
carrera = input('Escribe tu carrera') 
if os.path.isfile("miarchivo.txt"):
	f=open("miarchivo.txt","a")
else:
	f=open("miarchivo.txt","w")
f.write("Hola mundo \n")
f.write("25")
f.write(nombre)
f=open("miarchivo.txt","r")
for r in f:
	print (r)


	
