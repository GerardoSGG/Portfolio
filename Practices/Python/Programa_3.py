cadena=input("Escriba una cadena")
cadena=cadena.replace(" ", "")
valida= cadena[::-1]
if cadena==valida:
    print("La cadena leida es un palindromo")
else:
    print("La cadena leida no es un palindromo")