#include "tri_quicksort_lc.h"
#include "tri_fusion_lc.h"
#include "lc_util.h"
#include "dynamicMemoryManager.h"
#include "tab_util.h"
#include <stdlib.h>
#include <stdio.h>

liste* l_main; 
void test_dMM();
void test_generic();
void test_listes();
void test_tab();

int main() {
	srand(time(NULL));
	
	test_tab();
	return 0;
}

void test_tab()
{
	array* a = generateRandomArray(10, 0, 10);
	displayArray(a);
	insertOnArray(a, 40, 5);
	displayArray(a);
	tri_insertion(a);
	displayArray(a);
}

void test_dMM()
{
	initDMM();
	for (int i = 0; i < 5000000; i++)
	{
		void* ptr = _malloc(10000 * sizeof(char));
		_free(ptr);
	}
}

void test_generic() {
	printf("Hello World!\n");

	int nombre = 0;
	unsigned int nombre2 = 2;
	const signed int constante = 3;
	double nombreFlottant = 3.12;

	nombre2 += constante;
	printf("%d\n", nombre2);

	double numeroFlottant = 0.0;
	printf("Entrez un nombre r�el\n");
	scanf_s("%lf", &numeroFlottant);

	int numero = 0;
	do {
		printf("Entrez un nombre entre 1 et 10\n");
		scanf_s("%d", &numero);
	} while (numero < 1 || numero > 10);
}

void test_listes()
{
	l_main = generateRandomList(10);
	display(l_main);

	printf("longueur: %d\n", longueur(l_main));

	liste* temp1 = cons(50, NULL);
	l_main = push_front(l_main, temp1);
	display(l_main);

	liste* temp2 = cons(99, NULL);
	insert(l_main, temp2, 4);
	display(l_main);

	liste* temp3 = cons(420, NULL);
	push_back(l_main, temp3);
	display(l_main);

	printf("1ere valeur: %d\n", pop_front(l_main));
	display(l_main);


	l_main = quicksort(l_main);
	//l = triFusion(l);
	display(l_main);
	removeList(l_main);
}