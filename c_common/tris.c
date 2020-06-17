#include <stdlib.h>
#include <stdio.h>

int* tribulle(int* tab, int size);
void displayArray(int* array, int size);
int* triselection(int* tab, int size);
int* triinsertion(int* tab, int size);
int* trifusion(int* tab, int size);
int* fusion(int* tab1, int size1, int* tab2, int size2);


int* tribulle(int* tab, int size)
{
    int continuer = 1;
    int temp      = 0;
    
    while (continuer == 1)
    {
        continuer = 0;
        for (int i = 0; i < size - 1; i++)
        {
            if (tab[i] > tab[i+1])
            {
                    temp      = tab[i + 1];
                tab[i+1]      = tab[i];
                tab[i]        = temp;
                    continuer = 1;
            }
        }
    }

    return tab;
}

int* triselection(int* tab, int size)
{
    for (int i = 0; i < size; i++)
    {
        int min  = 0;
        int swap = 0;
        for (int j = i; j < size; j++)
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
            tab[i]   = tab[min];
            tab[min] = temp;
        }
        
    }

    return tab;
}


int* triinsertion(int* tab, int size)
{
    int* output = calloc(size, sizeof(int));
    for (int i = 0; i < size; i++)
    {
        int placed = 0;
        int temp   = 0;

        for (int j = 1; j <= size; j++)
        {
            int temp2 = -1;
            if ((tab[i] <= output[j-1] || output[j-1] == 0) && placed == 0)
            {
                       temp   = output[j-1];
                output[j-1]   = tab[i];
                       placed = 1;
            }
            else if (placed == 1)
            {
                       temp2 = output[j-1];
                output[j-1]  = temp;
                       temp  = temp2;
            }
        }
    }
    free(tab);
    return output;
}

/**
 * Pour chaque int dans le tableau d'origine:
 * On parcourt le tableau de sortie
 * en comparant les entiers en position offset -1 par rapport au int du tableau d'origine.
 * 
 * si on trouve sa position et qu'il n'est pas placé
 * on stocke la valeur qu'il va écraser dans une variable temporaire.
 * on écrase la variable dans le tableau de sortie par celle du tableau d'origine
 * on indique qu'il est placé.
 * 
 * si la valeur est déjà placée
 * on échange la variable en j-1 avec la variable temporaire générée
 * au tour de boucle précédent avec celle en j-1.
 * 
*/
int* fusion(int* tab1, int size1, int* tab2, int size2)
{
    int* output = calloc(size1+size2, sizeof(int));
    //FUITE MEMOIRE
    
    int i = 0; 
    int j = 0;
    int k = 0;
    while (i < size1 && j < size2)
    {
        if (tab1[i] < tab2[j])
        {
            output[k] = tab1[i];
            i++;
            k++;
        }
        else
        {
            output[k] = tab2[j];
            j++;
            k++;
        }
    }

    if (i == size1)
    {
        while (k < size1+size2 && j < size2)
        {
            output[k] = tab2[j];
            j++;
            k++;
        }
    }
    else
    {
        while(k < size1 + size2 && i < size1)
        {
            output[k] = tab1[i];
            i++;
            k++;
        }
    }
    return output;
}

int* trifusion(int* tab, int size)
{
   if (size <= 1)
   {
       return tab;
   }
   else
   {
       int split = size / 2;

       int* tab2 = tab+split;

       printf("%d\n", split);
       displayArray(tab, split);
       displayArray(tab2, split);
       
       return fusion(trifusion(tab, split), split, trifusion(tab2, split), split+1);
   }
}


void displayArray(int* array, int size)
{
    for (int i = 0; i < size; i++)
    {
        printf("%d \n", array[i]);
    }
    printf("\n");
}

int main(void)
{
    int* tab = calloc(5, sizeof(int));
    tab[0] = 55;
    tab[1] = 24;
    tab[2] = 78;
    tab[3] = 34;
    tab[4] = 128;

    displayArray(tab, 5);
    tab = trifusion(tab, 5);
    displayArray(tab, 5);
}