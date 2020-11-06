#include "lc_util.h"
#include <time.h>
#include <stdlib.h>

liste* cons(int t, liste* q) {
	liste* l = malloc(sizeof(liste));
	if (l == NULL) {
		exit(EXIT_FAILURE);
	}

	l->head = t;
	l->tail = q;
	return l;
}

int longueur(liste* l) {
	if (l->tail == NULL) {
		return 1;
	}
	else {
		return 1 + longueur(l->tail);
	}
}

liste* generateRandomList(int n) {
	if (n == 0) {
		return NULL;
	}
	else {
		return cons((int)(rand() / (double)RAND_MAX * (100 - 1)) , generateRandomList(n - 1));
	}
}

liste* generateListeSequentielle(int i, int j) {
	if (i == j) {
		return cons(i, NULL);
	}
	else if (i > j) {
		return cons(j, i);
	}
	else {
		return cons(i, generateListeSequentielle(i + 1, j));
	}
}

liste* append(liste* a, liste* b) {
	if (a == NULL) {
		return b;
	}
	else {
		return cons(a->head, append(a->tail, b));
	}
}

void display(liste* l) {
	if (l == NULL) {
		printf("\n");
	}
	else {
		printf("%i ", l->head);
		display(l->tail);
	}
}

void removeList(liste* l) {
	if (l != NULL) {
		removeList(l->tail);
		free(l);
	}
}

void push_back(liste* l, liste* l_add) {
	if (l->tail == NULL) {
		l->tail = l_add;
	}
	else {
		push_back(l->tail, l_add);
	}
}

liste* push_front(liste* l, liste* l_add) {
	l_add->tail = l;
	return l_add;
}

int pop_front(liste* l) {
	int valeur = l->head;
	liste* a_supp = l->tail;
	l->head = l->tail->head;
	l->tail = l->tail->tail;
	free(a_supp);
	return valeur;
}

void insert(liste* l, liste* element, int index)
{
	if (index != 0)
	{
		insert(l->tail, element, --index);
	}
	else
	{
		element->tail = l->tail;
		l->tail = element;
	}
}
