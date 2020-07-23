n=int(input("Escriba un numero"))
numero = n
x = 1
y = 0
aux = 0
resultado=1
while numero > x :
    n = n*(numero-x)
    x=x+1
print("El numero factorial de "+str(numero)+" es "+str(n))
n=numero
print("La serie de fibonachi hasta la posicion "+str(n)+" es:")
while y < numero :
    if(y==0):
        print(resultado)
    resultado=aux+resultado
    aux=resultado-aux
    n=resultado*resultado
    print(n)
    y +=1