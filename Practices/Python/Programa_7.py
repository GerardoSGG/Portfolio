numero=int(input("Escriba un numero"))
def rombo(n):
    result1=[" "*(n-i)+"*"*(i+i-1) for i in range(1,n+1)]
    return "\n".join(result1+list(reversed(result1[:-1])))
print(rombo(numero))
