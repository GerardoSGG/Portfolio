cadena=input("Escriba un numero")
try:
    cadena=cadena.replace(" ", "")
    valida= cadena[::-1]
    icadena= int(cadena)
    if cadena==valida:
       print("El numero leido es capicua")
    else:
       print("El numero leido no es capicua")
except: 
    print("Escriba solo numeros por favor")