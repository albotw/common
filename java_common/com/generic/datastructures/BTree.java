package com.generic.datastructures;

/**
 * Structure dérivée du projet d'info3A à propos de l'algorithme de Dijkstra. Il
 * s'agit d'un arbre stocké dans un tableau structuré ainsi; père à l'index i,
 * fils gauche à l'indice i * 2, fils droit à l'indice i * 2 + 1.
 * 
 */
public class BTree<K extends Number & Comparable<? super K>, V> {
    private Pair<K, V>[] tab;
    private int capacity; // capacité maximum
    private int size; // remplissage actuel

    @SuppressWarnings("unchecked")
    public BTree(Class<K> keyType, Class<V> valueType, int capacity) {
        this.capacity = capacity;
        this.tab = new Pair[capacity];
        this.size = 0;
    }

    /**
     * Cherche l'indice du père a partir de celui du fils.
     * 
     * @param index Index du fils dans le tableau.
     * @return Index du père dans le tableau.
     */
    public K pere(int index) {
        if (index % 2 != 0) {
            index--;
        }
        int v = index / 2;
        if (v > 0 && v <= capacity && tab[v] != null) {
            return tab[index / 2].getKey();
        } else {
            return null;
        }
    }

    /**
     * Cherche l'indice du fils gauche à partir de celui du père.
     * 
     * @param index Index du père dans le tableau
     * @return Index du fils gauche dans le tableau.
     */
    public K filsGauche(int index) {
        int v = 2 * index;
        if (v >= 0 && v < capacity && tab[v] != null) {
            return tab[2 * index].getKey();
        } else {
            return null;
        }
    }

    /**
     * Cherche l'indice du fils droit à partir de celui du père
     * 
     * @param index Index du père dans le tableau
     * @return Index du fils droit dans le tableau.
     */
    public K filsDroit(int index) {
        int v = 2 * index + 1;
        if (v >= 0 && v < capacity && tab[v] != null) {
            return tab[2 * index + 1].getKey();
        } else {
            return null;
        }
    }

    /**
     * Méthode récursive Redescend des noeuds dans l'arbre, utilisée après la
     * suppression de racine.
     * 
     * @param index position actuelle dans le tableau ! certaines valeurs ne sont
     *              pas repositionnées.
     */
    private void downHeap(int index) {
        if (index < size) {
            if (tab[index] != null) {

                if (filsGauche(index).compareTo(tab[index].getKey()) < 0) { // Fils gauche plus petit
                    swap(index, 2 * index);
                    downHeap(2 * index);
                    downHeap(index);

                } else if (filsDroit(index).compareTo(tab[index].getKey()) < 0) { // fils droit plus petit.
                    swap(index, 2 * index + 1);
                    downHeap(2 * index + 1);
                    downHeap(index);

                }
            }
        }
    }

    /**
     * Méthode récursive Remonte des noeuds dans l'arbre, utilisée après insertion.
     * 
     * @param index position actuelle dans le tableau. ! certaines valeurs ne sont
     *              pas repositionnées.
     */
    private void upHeap(int index) {
        if (index < size) {
            if (pere(index).compareTo(tab[index].getKey()) > 0) { // pere supérieur au noeud
                swap(index, index / 2);
                upHeap(index / 2);
                upHeap(index);
            }
        }
    }

    /**
     * échange la position de deux noeuds dans le tableau.
     * 
     * @param index_n1 Index du premier noeud
     * @param index_n2 Index du 2e noeud.
     */
    private void swap(int index_n1, int index_n2) {
        if (index_n1 < size && index_n2 < size) {
            Pair<K, V> temp = tab[index_n2];
            tab[index_n2] = tab[index_n1];
            tab[index_n1] = temp;

        }
    }

    /**
     * Supprime la racine de l'arbre.
     */
    public void removeRoot() {

        // première valeur différente de null à la fin du tableau.
        swap(0, size - 1);
        tab[size - 1] = null;
        downHeap(0);
        size--;
    }

    /**
     * @return Retourne le contenu de la racine (cast nécessaire)
     */
    public V getRoot() {
        if (tab[0] != null) {
            return tab[0].getValue();
        } else {
            return null;
        }
    }

    /**
     * Insère un objet dans l'arbre
     * 
     * @param obj
     * @param key
     */
    public void addObject(V obj, K key) {
        Pair<K, V> n = new Pair<K, V>(key, obj);
        if (size < capacity) {
            tab[size] = n;
        }
        // System.out.println(size);
        upHeap(size);
        size++;
    }

    /**
     * Vide l'arbre.
     */
    public void clear() {
        for (int i = 0; i < capacity - 1; i++) {
            tab[i] = null;
        }
        this.size = 0;
    }

    /**
     * Met a jour la clé d'une feuille et la replace à sa position.
     * 
     * @param oldKey Ancienne valeur pour la clé
     * @param newKey Nouvelle valeur pour la clé
     */
    public void updateKeyFromKey(K oldKey, K newKey) {
        int index = getIndexFromKey(oldKey);
        tab[index].setKey(newKey);
        if (pere(index).compareTo(newKey) >= 0) {
            upHeap(index);
        } else if (filsGauche(index).compareTo(newKey) < 0 || filsDroit(index).compareTo(newKey) < 0) {
            downHeap(index);
        }
    }

    /**
     * Met a jour la clé d'une feuille et la replace à sa position
     * 
     * @param val    Objet dont on doit modifier la clé
     * @param newKey nouvelle clé
     */
    public void updateKeyFromValue(V val, K newKey) {
        int index = getIndexFromValue(val);
        // System.out.println(index);
        if (index != -1) {
            tab[index].setKey(newKey);
            if (pere(index).compareTo(newKey) > 0) {
                upHeap(index);
            }
            if (filsGauche(index).compareTo(newKey) < 0 || filsDroit(index).compareTo(newKey) < 0) {
                downHeap(index);
            }
        }
    }

    /**
     * retourne la position dans le tableau d'un noeud a partir de sa clé
     * 
     * @param key clé correspodant au noeud recherché
     * @return position dans le tableau. ! optimisation par recherche dichotomique.
     */
    public int getIndexFromKey(K key) {
        int output = -1;
        for (int i = 0; i < size; i++) {
            if (tab[i] != null) {
                if (tab[i].getKey() == key) {
                    output = i;
                }
            }
        }
        return output;
    }

    /**
     * retourne la position dans le tableau d'un noeud a partir de sa valeur.
     * 
     * @param val Valeur du noeud
     * @return Position dans le tableau. ! optimisation difficile.
     */
    public int getIndexFromValue(V val) {
        int output = -1;
        for (int i = 0; i < size; i++) {
            if (tab[i].getValue() == val) {
                output = i;
            }

        }
        return output;
    }

    /**
     * supprime un noeud à partir de la valeur de celui ci.
     * 
     * @param val valeur du noeud a supprimer.
     */
    public void removeFromValue(V val) {
        int index = getIndexFromValue(val);
        tab[index] = tab[size];
        tab[size] = null;
        size--;
        downHeap(index);
    }

    /**
     * @return la taille de l'arbre.
     */
    public int getSize() {
        return size;
    }

    /**
     * récupère la valeur d"un noeud.
     * 
     * @param index position du noeud dans le tableau.
     * @return valeur du noeud.
     */
    public V getValueAt(int index) {
        if (tab[index] != null) {
            return tab[index].getValue();
        } else {
            return null;
        }
    }

    /**
     * récupère la clé d'un noeud
     * 
     * @param index position du noeud dans le tableau.
     * @return clé du noeud.
     */
    public K getKeyAt(int index) {
        return tab[index].getKey();
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            if (tab[i] != null) {
                s += "" + i + " || " + tab[i].toString() + "\n";
            }
        }
        return s;
    }
}