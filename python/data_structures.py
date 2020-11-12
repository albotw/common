from collections import namedtuple
from random import randint
Paire = namedtuple('Paire', ['hd', 'tl'])   #maillon de liste chainée.

def head(l):    #accède a la tête
    return l.hd

def tail(l):    #accède à la queue
    return l.tl

def cons(t, q): #constuit une liste chainée
    return Paire(t,q)

def iaj(i, j):  #constuit une liste chainée pour chaque nombre entre i et j. Suppose que i <= j
    if (i == j):
        return cons(i, None)
    elif(i > j):
        return cons(j, i)
    else:
        return cons(i, iaj(i+1, j))

def fact(n):    #fonction fac orielle standard
    if (n < 2):
        return 1
    else:
        return n * fact(n-1)

def map(f, l):  #pour constuire une liste chainée à partir de résultats d'une fonction
    if (l == None):
        return None
    else:
        return cons(
            f(head(l)),  #on applique la fonction sur la tête de la liste
            map(f, tail(l)) #on appelle récursivement la fonction avec le reste de la liste
        )

def longueur(l):    #retourne la longueur d'une liste chainée
    if (l == None):
        return 0
    else:
        return 1 + longueur(tail(l))        

print(map(fact, iaj(1, 4)))  # retourne [1, 2, 6, 24]

print(map((lambda x: 10 * x), iaj(1, 3)))  #retourne [10, 20, 30]

def generateListe(n):
    if n == 0:
        return None
    else:
        return cons(randint(0, 1000), generateListe(n-1))

def generateTab(n):
    tab = []
    for i in range(0, n):
        tab.append(randint(0, 1000))
    return tab
#========================================================================================================

def filter(pred, l):    #pour filtrer les éléments d'une liste par une fonction lambda
    if l == None:
        return None
    elif (pred(head(l))):   
        return cons(
            head(l),         
            filter(pred, tail(l))
        )
    else:
        return filter(pred, tail(l))

print(filter( (lambda x: 1 == x%2), iaj(0, 10)))   #retourne [1, 3, 5, 7, 9]

def append (a, b):  #pour fusionner deux listes a et b
    if (a == None):
        return b
    else:
        return cons(
            head(a),
            append(tail(a), b)
        )

def quicksort(l):
    if (l == None or tail(l) == None):
        return l
    else:
        pivot_ = pivot(l)
        l1 = filter((lambda x: x < head(pivot_)), l)
        l2 = filter((lambda x: x == head(pivot_)), l)
        l3 = filter((lambda x: x > head(pivot_)), l)

        ltemp = append(quicksort(l1), quicksort(l2))
        return append(ltemp, quicksort(l3))


def pivot(l):
    long = longueur(l)
    for i in range(0, long):
        ltemp = tail(l)
    return ltemp

print()
print(quicksort(generateListe(10)))
#===========================================================================================================
def fusion(a, b):   #fusionne deux listes triées en ordre croissant
    if (a == None):
        return b
    elif (b == None):
        return a
    elif (head(a) < head(b)):
        return cons(
            head(a),
            fusion(tail(a), b)
        )
    else:
        return cons(
            head(b),
            fusion(a, tail(b))
        )

def moitie(l):  #retourne la moitié d'une liste
    if (l == None or tail(l) == None):
        return l
    else:
        return cons(
            head(l),
            moitie(tail(tail(l)))
        )

def triFusion(l):
    if (l == None or tail(l) == None):
        return l
    else:
        return fusion(
            triFusion(moitie(l)),
            triFusion(moitie(tail(l)))
        )
print()
print(triFusion(generateListe(10)))
#===========================================================================================================



def listeChiffre(b, n, l):  #décompose un nombre en une liste de ses chiffres dans la base b
    if (n == 0):
        return l
    else:
        return listeChiffre(b, n // b, cons( n % b, l))

def build(b, n, l): #recompose une liste de chiffres en numéro dans la base b
    if (l == None):
        return l
    else:
        return build(b, n * b + head(l), tail(l))

#===========================================================================================================

def triBulle(tab):
    for i in range(0, len(tab)):
        for j in range(0, len(tab) - i - 1):
            if tab[j] > tab[j+1]:
                temp = tab[j+1]
                tab[j+1] = tab[j]
                tab[j] = temp
    return tab

print(triBulle(generateTab(10)))


def euclide(a, b):
    if (b == 0):
        return (1, 0, a)
    else:
        (u2, v2, g) = euclide(b, a%b)
        return (v2, u2 - (a // b) * v2, g)

print(euclide(128, 100))

def divRusse(a, b):
    q = 0
    r = a
    while (r >= b):
        continuer = True
        k = 0
        while (continuer):
            if (((2**k) * b) <= r and r < (2**(k+1)) * b):
                q += 2**k
                r -= (2**k) * b
                continuer = False
            k += 1
    return (q, r)

print(divRusse(12, 4))