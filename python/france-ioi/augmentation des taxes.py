from math import *

taxe = input()
nTaxe = input()
oldPrix = input()

prix = float(int((oldPrix - (taxe /100 * oldPrix))*100))/100
print(prix)
prix += float(int((nTaxe /100 *prix) *100))/100
print(prix)

