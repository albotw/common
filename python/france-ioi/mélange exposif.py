mesuresTotal = int(input())
tempMin = int(input())
tempMax = int(input())
i = 0
for i in range(mesuresTotal):
    temp = int(input())
    if tempMin <= temp <= tempMax:
        print("Rien à signaler")
        i += 1
    else:
        print("Alerte !!")
        break
