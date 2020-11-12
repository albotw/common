maxPierres = int(input())
nbPierres = 0
i = 1

while nbPierres + i **2 < maxPierres:
    nbPierres += i **2
    i += 1
print(i -1)
print(nbPierres)
