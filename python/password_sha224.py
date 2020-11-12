# coding: utf8
from tkinter import *
from tkinter.messagebox import *
from tkinter import StringVar
import hashlib

root_password = "2850a499e44028011068b371551678d13d8c4d337385fc7e983e0666"

def Verification():
    password_str = password.get()
    password_str = bytes(password_str, 'utf8')
    password_sign = hashlib.new('sha224', password_str).hexdigest()
    if password_sign == root_password:
        showinfo('Resultat','Mot de passe valide \nAu Revoir!')
        MaFenetre.destroy()
    else:
        # le mot de passe est incorrect : on affiche une boîte de dialogue
        showwarning('Résultat','Mot de passe incorrect.\nVeuillez recommencer !')
        password.set('')
        
# Création de la fenêtre principale (main window)
Mafenetre = Tk()
Mafenetre.title('Identification requise')

# Création d'un widget Label (texte 'Mot de passe')
Label1 = Label(Mafenetre, text = 'Mot de passe ')
Label1.pack(side = LEFT, padx = 5, pady = 5)

# Création d'un widget Entry (champ de saisie)
password = StringVar()
Champ = Entry(Mafenetre, textvariable= password, show='*', bg ='bisque', fg='maroon')
Champ.focus_set()
Champ.pack(side = LEFT, padx = 5, pady = 5)

# Création d'un widget Button (bouton Valider)
Bouton = Button(Mafenetre, text ='Valider', command = Verification)
Bouton.pack(side = LEFT, padx = 5, pady = 5)
Mafenetre.mainloop()
    
