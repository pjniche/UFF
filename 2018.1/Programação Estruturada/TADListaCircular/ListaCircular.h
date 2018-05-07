#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <math.h>

#ifndef LISTACIRCULAR_H_INCLUDED
#define LISTACIRCULAR_H_INCLUDED

#define TRUE 1
#define FALSE 0


// vamos fazer uma lista circular de
// super herois
typedef struct hero {
    char nome[40];
    int poder; // 1 a 5
} Hero;

int inicializa(void);
int finaliza(void);
int entrar(Hero h);// adiciona apos elemento corrente
// e torna o que entrou o novo corrente
// como exercicio o aluno deve entrar mantendo a
// lista circular ordenada

int retirar(Hero *h);// retira o elemento corrente e posiciona
// o ponteiro corrente para o proximo elemento
// ou NULL se nao tiver mais ninguem

int proximo(void);// posiciona o corrente no proximo elemento da lista


#endif // LISTACIRCULAR_H_INCLUDED
