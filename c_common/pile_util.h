
#pragma once

struct pile {
	liste* sommet;
};

typedef struct pile pile;

pile* cons_value(int value_init);

pile* cons_lc(liste* l);

void push_top(pile* p, int value);

int pop_top(pile* p); 

pile* generatePileSequentielle(int debut, int fin);