#Importation des bibliotheques necessaires
from pygame import *
from pygame.locals import *
import sys

init()
width = 800
height = 600
screen = display.set_mode([width, height], RESIZABLE)

#importation des textures-----------------------
fond = image.load("wallpaper.png").convert()
screen.blit(fond, (0,0))

terrain = image.load("terrain3.png")
terrain_x = -10
terrain_y = 0
screen.blit(terrain, (terrain_x,terrain_y))

#/importation des textures-----------------------

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
        self.rect.x += 10
    def gauche(self):
        self.image = image.load("1.png").convert_alpha()
        self.rect.x -= 10
    def jump (self):
        if self.rect.y == 420:
            for i in range (0, 20):
                self.rect.y -= 2
                i += 1
            i = 0
        if self.rect.y < 420:
            self.rect.y += 2
        print ("pesr_rect ++")

display.flip()
i = 0
movingObject = "perso"
leftPressed = False
rightPressed = False
upPressed = False
start_zl = 250
end_zl = 550
personnage = Personnage()
allsprites = sprite.RenderPlain((personnage))

#Main
continuer = 1
while continuer == 1:
    for evenement in event.get():
                if evenement.type == QUIT:
                        continuer = 0
                elif evenement.type == KEYUP:
                    if evenement.key == K_UP:
                        upPressed = False
                elif evenement.type == KEYDOWN:
                        if evenement.key == K_ESCAPE:
                                continuer = 0
                                
                        if evenement.key ==  K_RIGHT:
                            rightPressed = True
                            if movingObject == "perso":
                                if personnage.rect.x < end_zl:
                                    personnage.droite()
                                else:
                                    movingObject = "terrain"
                                    leftPressed = False
                            if movingObject == "terrain":
                                if terrain_x <= 0 and terrain_x > -1690 and leftPressed == False:
                                    terrain_x = terrain_x - 10
                                else:
                                    movingObject = "perso"


                        if evenement.key ==  K_LEFT:
                            leftPressed = True
                            if movingObject == "perso":
                                if personnage.rect.x > start_zl:
                                    personnage.gauche()
                                else:
                                    movingObject = "terrain"
                                    rightPressed = False
                            if movingObject == "terrain":
                                if terrain_x < 0 and terrain_x >= -1690 and rightPressed == False:
                                    terrain_x = terrain_x + 10
                                else:
                                    movingObject = "perso"

                        if evenement.key == K_UP:
                            personnage.jump()

    

    #RENDU -----------------------------------------------
    screen.blit(fond, (0,0))
    screen.blit(terrain, (terrain_x,terrain_y))
    allsprites.draw(screen)
    display.flip()
    #FIN RENDU -------------------------------------------

    #DEBUG -----------------------------------------------
    print (movingObject, personnage.rect.x, personnage.rect.y, terrain_x)
quit()
