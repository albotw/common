#include "tab_util.h"

void removeArray(array* a)
{
	free(a->tab);
	free(a);
}



array* createArray(int size, char type)
{
	array* output = calloc(1, sizeof(array));
	output->type = type;
	output->size = size;

	switch (type)
	{
	case 'I':
		output->tab = (int*)(calloc(size, sizeof(int)));
		break;
	case 'F':
		output->tab = (float*)(calloc(size, sizeof(float)));
		break;
	case 'U':
		output->tab = (unsigned*)(calloc(size, sizeof(unsigned)));
		break;
	case 'C':
		output->tab = (char*)(calloc(size, sizeof(char)));
		break;
	case 'D':
		output->tab = (double*)(calloc(size, sizeof(double)));
		break;
	case 'L':
		output->tab = (long*)(calloc(size, sizeof(long)));
		break;
	case 'S':
		output->tab = (short*)(calloc(size, sizeof(short)));
		break;
	}

	return output;
}

void tri_bulle(array* a)
{
	int* tab = (int*)(a->tab);
	int continuer = 1;
	while (continuer == 1)
	{
		continuer = 0;
		for (int i = 0; i < a->size-1; i++)
		{
			if (tab[i] > tab[i + 1])
			{
				int tmp = tab[i + 1];
				tab[i + 1] = tab[i];
				tab[i] = tmp;
				continuer = 1;
			}
		}
	}

	return tab;
}
/*
On parcourt le tableau tant qu'il y a des valeurs a échanger. à chaque passage, on échange
les valeurs cote a cote qui ne sont pas croissantes
*/

void tri_selection(array* a)
{
	int* tab = (int*)(a->tab);
	for (int i = 0; i < a->size; i++)
	{
		int min = 0;
		int swap = 0;
		for (int j = i + 1; j < a->size - 1; i++)
		{
			if (tab[j] < tab[min])
			{
				min = j;
				swap = 1;
			}
		}

		if (swap == 1)
		{
			int temp = tab[i];
			tab[i] = tab[min];
			tab[min] = tab[i];
		}
	}
}
/*
Tri classique: on trouve le min et on le place au début du tableau puis on recommence avec les
autres valeurs restantes
*/

void tri_insertion(array* a)
{
	int* newTab = calloc(a->size, sizeof(int));
	int* tab = (int*)a->tab;

	for (int i = 0; i < a->size; i++)
	{
		int placed = 0;
		int temp = 0;
		for (int j = 1; j <= a->size; j++)
		{
			int temp2 = -1;

			if ((tab[i] <= newTab[j - 1] || newTab[j - 1] == 0) && placed == 0)
			{
				temp = newTab[j - 1];
				newTab[j - 1] = tab[i];
				placed = 1;
			}
			else if (placed == 1)
			{
				temp2 = newTab[j - 1];
				newTab[j - 1] = temp;
				temp = temp2;
			}
		}
	}

	free(a->tab);
	a->tab = newTab;
}
/*
On crée un nouveau tableau pour contenir les valeurs triées.
pour chaque valeur du tableau d'origine, on parcourt le nouveau tableau et on l'insère
dans l'ordre croissant.
*/

array* generateRandomArray(int size, int min, int max)
{
	array* output = createArray(size, 'I');

	int* temp = (int*)(output->tab);
	max++;
	for (int i = 0; i < size; i++)
	{
		temp[i] = (rand() % (max - min)) + min;
	}

	return output;
}

void displayArray(array* a)
{
	for (int i = 0; i < a->size; i++)
	{
		switch (a->type)
		{
			case 'I':
			{
				int* temp = (int*)(a->tab);
				printf("%d ", temp[i]);
				break;
			}

			case 'F':
			{
				float* temp = (float*)(a->tab);
				printf("%f ", temp[i]);
				break;
			}

			case 'U':
			{
				unsigned* temp = (unsigned*)(a->tab);
				printf("%u ", temp[i]);
				break;
			}

			case 'C':
			{
				char* temp = (char*)(a->tab);
				printf("%c ", temp[i]);
				break;
			}

			case 'D':
			{
				double* temp = (double*)(a->tab);
				printf("%lg ", temp[i]);
				break;
			}

			case 'L':
			{
				long* temp = (long*)(a->tab);
				printf("%li ", temp[i]);
				break;
			}

			case 'S':
			{
				short* temp = (short*)(a->tab);
				printf("%hi ", temp[i]);
				break;
			}
		}
	}
	printf("\n");
}

void insertOnArray(array* a, int value, int index)
{
	index--;

	//a mettre dans le switch de types.
	int* tab = (int*)a->tab;
	int* newTab = calloc(a->size + 1, sizeof(int));
	int temp = -1;
	int temp2 = -1;
	//---------------------------------

	int placed = 0;
	for (int i = 1; i <= a->size; i++)
	{
		if (index != 0)
		{
			index--;
			newTab[i - 1] = tab[i - 1];
		}
		else
		{
			if (placed == 0)
			{
				temp = tab[i - 1];
				newTab[i - 1] = value;
				placed = 1;
			}
			else if (placed == 1)
			{
				temp2 = tab[i - 1];
				newTab[i - 1] = temp;
				temp = temp2;
			}
		}
	}

	free(a->tab);
	a->tab = newTab;
	a->size++;
}