from math import *
from pygame import *
from pygame.locals import *

init()
width = 800
height = 600
screen = display.set_mode([width, height])
pas = 1
inventory = []
life = 100
armor = 0
actualMagazine = 25
allMagazine = 125
gameOver = False
difficulty = 1

class Personnage(sprite.Sprite):
    def __init__(self):
        sprite.Sprite.__init__(self)
        self.image = image.load("perso.png").convert_alpha()
        self.rect = self.image.get_rect(center = (14,14))
        self.rect.x = 512
        self.rect.y = 384
    def headAngle(self):
        if evenement.type == MOUSEMOTION:
            self.rect.move(mouse.get_pos())
            self.angle = degrees(atan2(self.rect.center.x -self.rect.x),(self.rect.center.y - self.center.y))
            self.newimg = transform.rotate(self.image, self.angle)
            self.rect = self.newimg.get_rect(center = (14,14))

personnage = Personnage()

class Viseur(sprite.Sprite):
    def __init__(self):
        sprite.Sprite.__init__(self)
        self.image = image.load("viseur.jpg").convert_alpha()
        self.rect = self.image.get_rect(center = (40,40))
    def followMouse(self):
        if evenement.type == MOUSEMOTION:
            self.rect.move(mouse.get_pos())

viseur = Viseur()

class Terrain(sprite.Sprite):
    def __init__(self):
        sprite.Sprite.__init__(self)
        self.image = image.load("map.jpg").convert_alpha()
        self.rect = self.image.get_rect()
        self.rect.x = 0
        self.rect.y = 0
    def haut(self):
        self.rect.y = self.rect.y - pas
    def bas(self):
        self.rect.y = self.rect.y + pas
    def gauche(self):
        self.rect.x = self.rect.x - pas
    def droite(self):
        self.rect.x = self.rect.x + pas
terrain = Terrain()

allsprites = sprite.RenderPlain((personnage, viseur, terrain))
collideSprites = [personnage]

key.set_repeat(200, 30)
continuer = True
display.flip()
while continuer == True:
    allsprites.draw(screen)
    for evenement in event.get():
        if evenement.type == QUIT:
            gameOver = True
            continuer = False
        elif evenement.type == KEYDOWN:
            if evenement.key == K_ESCAPE:
                gameOver = True
                continuer = False
    while gameOver == False:
        viseur.followMouse()
        personnage.headAngle()
        for evenement in event.get():
            if evenement.type == KEYDOWN:
                if evenement.key == K_UP:
                    if not sprite.collide_rect(collideSprites):
                        terrain.haut()
                        allsprites.draw(screen)
                        display.flip()
                if evenement.key == K_DOWN:
                    if not sprite.collide_rect(collideSprites):
                        terrain.bas()
                        allsprites.draw(screen)
                        display.flip()
                if evenement.key == K_LEFT:
                    if not sprite.collide_rect(collideSprites):
                        terrain.gauche()
                        allsprites.draw(screen)
                        display.flip()
                if evenement.key == K_RIGHT:
                    if not sprite.collide_rect(collideSprites):
                        terrain.droite()
                        allsprites.draw(screen)
                        display.flip()
quit()

