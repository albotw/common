#include "tri_fusion_lc.h"

liste* fusion(liste* a, liste* b) {
	if (a == NULL) {
		return b;
	}
	else {
		if (b == NULL) {
			return a;
		}
		else {
			if (a->head < b->head) {
				return cons(a->head, fusion(a->tail, b));
			}
			else {
				return cons(b->head, fusion(a, b->tail));
			}
		}
	}
}

liste* moitie_internal(liste* l, int length) {
	if (length == 0 || l == NULL) {
		return NULL;
	}
	else {
		int head = pop_front(l);
		liste* queue = moitie_internal(l, length - 1);
		return cons(head, queue);
	}
}

liste* moitie(liste* l) {
	int length = longueur(l);
	return moitie_internal(l, length / 2);
}

liste* triFusion(liste* l) {
	if (l == NULL || l->tail == NULL) {
		return l;
	}
	else {
		liste* l1 = triFusion(moitie(l));
		liste* l2 = triFusion(l);
		return fusion(l1, l2);
	}
}