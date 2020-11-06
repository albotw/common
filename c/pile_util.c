#include "lc_util.h"
#include "pile_util.h"


pile* cons_value(int value_init) {
	pile* p = malloc(sizeof(pile*));
	if (p == NULL) {
		exit(EXIT_FAILURE);
	}
	p->sommet = cons(value_init, NULL);
	return p;
}

pile* cons_lc(liste* l) {
	pile* p = malloc(sizeof(pile*));
	if (p == NULL) {
		exit(EXIT_FAILURE);
	}
	p->sommet = l;
	return p;
}

void push_top(pile* p, int value) {
	push_front(p->sommet, cons(value, NULL));
}


int pop_top(pile* p) {
	return pop_front(p->sommet);
}

pile* generatePileSequentielle(int debut, int fin) {
	liste* l = generateListeSequentielle(debut, fin);
	return cons(l, NULL);
}

pile* generateRandomPile(int n) {

}