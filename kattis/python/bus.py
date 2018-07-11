cases = int(input())

def busCalc(k):
    return 2**k-1


for i in range(0, cases):
    print (str(busCalc(int(input()))) + "\n")




