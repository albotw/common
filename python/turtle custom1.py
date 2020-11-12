from turtle import *

i = 0
a = 1
speed(400)
bgcolor('black')
hideturtle()
while i <= 40:
    
    if a == 1:
        color('blue')
        a = 2
    elif a == 2:
        color('red')
        a = 3
    elif a == 3:
        color('green')
        a = 4
    elif a == 4:
        color('yellow')
        a = 1
        
    left(90)
    forward(100)
    left(90)
    forward(100)
    left(90)
    forward(100)
    left(90)
    forward(100) 
    right(9)
    
    i += 1

mainloop()
    
