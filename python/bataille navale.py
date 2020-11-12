#-*- coding uft-8 -*-

# Créé par TROU, le 03/12/2015 en Python 3.2
from random import randint
a = randint(1,20)
b = randint(1,20)
rekt = False

print("à vous de jouer")
while rekt == False:
    
    x = int(input())
    y = int(input())
    
    if x == a and y == b:
        rekt = True
        print("BOOM HEADSHOT")
    elif x == a or y == b:
        print ("en vue")
    else:
        print ("a l'eau")
