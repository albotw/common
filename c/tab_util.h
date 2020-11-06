#pragma once
#include <stdio.h>
#include <stdlib.h>

typedef struct {
	void* tab;
	unsigned size;
	char type;
}array;

//type == 'I' ~> int
//type == 'F' ~> float
//type == 'U' ~> unsigned (int)
//type == 'C' ~> char
//type == 'D' ~> double
//type == 'L' ~> long
//type == 'S' ~> short

array* createArray(int size, char type);

void tri_bulle(array* a);
//! Ne fonctionne que sur des entiers.

void tri_selection(array* a);
//! ne fonctionne que sur des entiers.

void tri_insertion(array* a);
//! ne fonctionne que sur des entiers.

void fusion(int* tab1, int size1, int* tab2, int size2);

void tri_fusion(int* tab, int size);

array* generateRandomArray(int size, int min, int max);
//! genere un tableau d'entiers aleatoires entre min et max

void displayArray(array* a);

void removeArray(array* a);

void insertOnArray(array* a, int value, int index);

int searchOnArray(array* a, void* value);