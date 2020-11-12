#Importation des bibliotheques necessaires
from pygame import *
from pygame.locals import *
import sys

init()
width = 800
height = 600
screen = display.set_mode([width, height], RESIZABLE)

fond = image.load("wallpaper.png").convert()
screen.blit(fond, (0,0))

#Musique
mixer.music.load("music.wav")
mixer.music.play()
key.set_repeat(450, 20)
#/musique

class Personnage(sprite.Sprite):
    def __init__(self):
        sprite.Sprite.__init__(self)
        self.image = image.load("2.png").convert_alpha()
        self.rect = self.image.get_rect()
        self.rect.x = 400
        self.rect.y = 420
    def droite(self):
        self.image = image.load("2.png").convert_alpha()
        if self.rect.x < end_zl:
            self.rect.x = self.rect.x + 10
    def gauche(self):
        self.image = image.load("1.png").convert_alpha()
        if self.rect.x > start_zl:
            self.rect.x = self.rect.x - 10


class Terrain(sprite.Sprite):
    def __init__(self):
        sprite.Sprite.__init__(self)
        self.image = image.load("terrain3.png")
        self.rect = self.image.get_rect()
        self.rect.x = -10
        self.rect.y = 0
    def droite(self):
        if self.rect.x > 0 and self.rect.x < -1690:
            self.rect.x = self.rect.x + 10
    def gauche(self):
        if self.rect.x < 0 and self.rect.x > -1690:
            self.rect.x = self.rect.x - 10

display.flip()

movingObject = "terrain"
leftPressed = False
rightPressed = False
upPressed = False
start_zl = 250
end_zl = 550
terrain = Terrain()
personnage = Personnage()
allsprites = sprite.RenderPlain((personnage, terrain))
#Main
continuer = 1
while continuer == 1:
    for evenement in event.get():
                if evenement.type == QUIT:
                        continuer = 0
                elif evenement.type == KEYDOWN:
                        if evenement.key == K_F1:
                                display.set_mode([width, height], FULLSCREEN)
                        if evenement.key == K_ESCAPE:
                                continuer = 0

                        if evenement.key ==  K_RIGHT:
                            if movingObject == "perso":
                                personnage.droite()
                                screen.blit(fond, (0,0))
                                allsprites.draw(screen)
                                display.flip()
                            elif movingObject == "terrain":
                                terrain.gauche()
                                screen.blit(fond, (0,0))
                                allsprites.draw(screen)
                                display.flip()

                        if evenement.key ==  K_LEFT:
                            if movingObject == "perso":
                                personnage.gauche()
                                screen.blit(fond, (0,0))
                                allsprites.draw(screen)
                                display.flip()
                            elif movingObject == "terrain":
                                terrain.droite()
                                screen.blit(fond, (0,0))
                                allsprites.draw(screen)
                                display.flip()
quit()