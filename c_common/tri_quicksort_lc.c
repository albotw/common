
#include "lc_util.h"

//mode == 0 ==> valeurs en dessous uniquement
//mode == 1 ==> valeurs égales uniquement
//mode == 2 ==> valeurs supérieurs uniquement
liste* filtre(liste* l, int mode, int value) {
	if (l == NULL) {
		return NULL;
	}
	else {
		if (l->head < value && mode == 0) {
			return cons(l->head, filtre(l->tail, mode, value));
		}
		else {
			if (l->head == value && mode == 1){
				return cons(l->head, filtre(l->tail, mode, value));
			}
			else {
				if (l->head > value && mode == 2) {
					return cons(l->head, filtre(l->tail, mode, value));
				}
				else {
					return filtre(l->tail, mode, value);
				}
			}
		}
	}
}

liste* pivot_internal(liste* l, int n) {
	if (n == 0) {
		return l;
	}
	else {
		return pivot_internal(l->tail, n - 1);
	}
}

liste* pivot(liste* l) {
	int lr = longueur(l);
	return pivot_internal(l, lr / 2);
}

liste* quicksort(liste* l) {
	if (l == NULL || l->tail == NULL) {
		return l;
	}
	else {
		liste* piv = pivot(l);
		liste* l1 = filtre(l, 0, piv->head);
		l1 = quicksort(l1);
		liste* l2 = filtre(l, 1, piv->head);
		l2 = quicksort(l2);
		liste* l3 = filtre(l, 2, piv->head);
		l3 = quicksort(l3);

		liste* ltemp = append(l1, l2);
		return append(ltemp, l3);
	}
}