#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

#ifndef TADCOMPARALISTA_H_INCLUDED
#define TADCOMPARALISTA_H_INCLUDED

#define TRUE 0
#define FALSE 1

#define MAX 3

typedef struct mercadoria {
    char nome[40];
} Mercadoria;

int init(int n);
int insere(Mercadoria m, int n);
int unirLista(int x, int a, int b);
int exibe(int n);

#endif // TADCOMPARALISTA_H_INCLUDED
