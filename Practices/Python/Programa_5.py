n1=int(input("Escriba el primer numero"))
n2=int(input("Escriba el segundo numero"))
n3=int(input("Escriba el tercer numero"))

if n1==n2 & n2==n3:
    print("Los tres numeros son iguales")
else:
    if n1==n2 :
        print("El primero y el segundo numero son iguales")
        if n3<n1 :
            print("El tercer numero es menor al primero y el segundo")
        else :
            print("El tercer numero es mayor al primero y el segundo")
    elif n2==n3 :
        print("El segundo y el tercer numero son iguales")
        if n1<n2 :
            print("El primer numero es menor al segundo y al tercero")
        else :
            print ("El primer numero es mayor al segundo y al tercero")
    elif n1==n3 :
        print("El primero y el tercer numero son iguales")
        if n2<n1 :
            print("El segundo numero es menor al primero y el tercero")
        else :
            print ("El segundo numero es mayor al primero y al tercero")
    elif n1>n2 & n1>n3 :
        print("El primer numero es el mayor")
        if n2>n3 :
            print("El segundo es el numero de en medias")
            print("El tercero es el numero menor")
        else:
            print("El tercero es el numero de en medias")
            print("El segundo es el numero menor")   
    elif n2>n1 & n2>n3 :
        print("El segundo numero es el mayor")
        if n1>n3 :
            print("El primer numero es el numero de en medias")
            print("El tercero es el numero menor")
        else:
            print("El tercero es el numero de en medias")
            print("El primer numero es el numero menor")

if n3>n1 :
    if n3>n2 :
        print("El tercer numero es el mayor")
        if n1>n2 :
            print("El primer numero es el numero de en medias")
            print("El segundo es el numero menor")
        else:
            print("El segundo es el numero de en medias")
            print("El primer numero es el numero menor")