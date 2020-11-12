struct liste{
    int head;
    *liste tail;
}

liste cons(int t, *liste q){
    return liste{t, q};
}

int longueur(liste l){
    if (l.tail == NULL){
        return 0;
    }
    else{
        return 1 + longueur(l.tail);
    }
}

liste append(liste a, liste b){
    if (a == NULL){
        return b;
    }
    else{
        return cons(
            a.head;
            append(a.tail, b);
        )
    }
}

//mode == 0 ==> NEGATIF
//mode == 1 ==> EGAL
//mode == 2 ==> SUPERIEUR
liste filtre(liste l, int mode, int value){
    if (l == NULL){
        return NULL
    }
    else{
        if (l.head < value && mode == 0){
            return cons(l.head, filtre(l.tail));
        }
        else{
            if (l.head == value && mode == 1){
                return cons(l.head, filtre(l.tail));
            }
            else{
                if (l.head > value && mode == 3){
                    return cons(l.head, filtre(l.tail));
                }
                else{
                    return filtre(l.tail, mode);
                }
            }
        }
    }
}

liste quicksort(liste l){
    if (l == NULL || l.tail == NULL){
        return l;
    }
    else{
        int pivot = pivot(l);
        l1 = filtre(l, 0, pivot.head);
        l2 = filtre (l, 1, pivot.head);
        l3 = filtre(l, 3, pivot.head);

        liste ltemp = append(l1, l2);
        return append(ltemp, l3);
    }
}

liste pivot(liste l ){
    int longueur = longueur(l);
    liste ltemp = NULL;
    for (int i = 0; i < longueur / 2; i++){
        ltemp = l.tail;
    }

    return ltemp;
}