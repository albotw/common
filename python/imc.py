import math

poids = 0
taille = 0
imc = 0
poids = int(input("Quel est ton poids ?"))
taille = int(input("Quelle est ta taille ?"))
taille = pow(taille, 2)
imc = poids/taille
print ("ton imc est de ", imc)
