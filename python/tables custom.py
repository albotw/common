import time

i = 0
facteur = 0

facteur = int(input())
while i < 10 :
    print(i + 1,'*',facteur,'=',(i+1)*facteur)
    i += 1
time.sleep(10)