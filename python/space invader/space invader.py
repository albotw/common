from pygame import *
from pygame.locals import *

init()

width = 640
height = 480
screen = display.set_mode([width, height])

pas = 5


class Spaceship (sprite.Sprite):
    def __init__(self):
        sprite.Sprite.__init__(self)
        self.image = image.load("spaceship.png").convert_alpha()
        self.rect = self.image.get_rect()
        self.rect.centerx = 45
        self.rect.centery = 45
        self.image = transform.smoothscale(self.image, (90,90))
        self.rect.y = 350
        self.rect.x = 240
    def gauche(self):
        if self.rect.x >= 120:
            self.rect.x = self.rect.x - pas
    def droite(self):
        if self.rect.x <= 360:
            self.rect.x = self.rect.x + pas
spaceship = Spaceship()

class Laser(sprite.Sprite):
        def __init__(self):
                sprite.Sprite.__init__(self)
                self.image = image.load("laser.png").convert_alpha()
                self.rect = self.image.get_rect()
                self.rect.x = spaceship.rect.x
                self.rect.y = spaceship.rect.y
laser = Laser()
laser_shot = False

key.set_repeat(200, 30)
allsprites = sprite.RenderPlain((spaceship))
stop = False
T_laser = []
while stop == False:
    if laser_shot == True:
        T_laser.append([laser.rect.x, laser.rect.y])
        for element in T_laser:
            allsprites.add(laser)
            if laser.rect.y >= -50:
                    laser.rect.y = laser.rect.y - pas
                    screen.fill((0,0,0))
                    allsprites.draw(screen)
                    display.flip()
            elif laser.rect.y == -50:
                T_laser.remove[1]
    for evenement in event.get():
        if evenement.type == QUIT:
            stop = True
    if evenement.type == KEYDOWN:
        if evenement.key == K_ESCAPE:
            stop = True
        if evenement.key == K_LEFT:
            spaceship.gauche()
            screen.fill((0,0,0))
            allsprites.draw(screen)
            display.flip()
        if evenement.key == K_RIGHT:
            spaceship.droite()
            screen.fill((0,0,0))
            allsprites.draw(screen)
            display.flip()
        if evenement.key == K_SPACE:
            laser = Laser()
            laser_shot = True
            screen.fill((0,0,0))
            allsprites.draw(screen)
            display.flip()
        time.delay(10)
quit()
