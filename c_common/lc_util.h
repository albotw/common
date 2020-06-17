#pragma once
#include <time.h>
#include <stdlib.h>

typedef struct liste{
	int head;
	struct liste* tail;
};

typedef struct liste liste;

liste* cons(int t, liste* q);				//construit un chainon de liste

int longueur(liste* l);						//calcule la longueur d'une liste

liste* generateRandomList(int n);			//g�n�re une liste de taille n compos�e de nombres al�atoires

liste* generateListeSequentielle(int i, int j);		//g�n�re une liste contenant les valeurs de i � j

liste* append(liste* a, liste* b);			//construit une liste � la suite de l'autre

void display(liste* l);						//affiche toutes les valeurs d'une liste

void removeList(liste* l);					//supprime une liste en partant du dernier �l�ment

liste* push_front(liste* l, liste* l_add);	//ajoute une liste en t�te d'une autre

int pop_front(liste* l);					//retourne la valeur de la 1ere case de la liste puis supprime la liste

void push_back(liste* l, liste* l_add);		//accroche une liste a la fin d'une autre

void insert(liste* l, liste* element, int index);			//ins�re un �l�ment de liste � l'index indiqu�
//! ERREUR: Ne pas rajouter d'�l�ment d�ja existant dans la liste