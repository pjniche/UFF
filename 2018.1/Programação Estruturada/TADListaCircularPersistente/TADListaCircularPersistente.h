#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

#ifndef TADLISTACIRCULARPERSISTENTE_H_INCLUDED
#define TADLISTACIRCULARPERSISTENTE_H_INCLUDED

#define TRUE 1
#define FALSE 0

typedef struct mercadoria {
    char nome[40];
    int quantidade;
    double preco;
} Mercadoria;

int lcp_cria();//Cria o primeiro Node e abre o arquivo de dados para leitura.
int lcp_insere(Mercadoria m);//Carrega itens para a lita.
int lcp_remove();//Remove o item corrente.
int lcp_anterior();//Torna corrente o item anterior.
int lcp_corrente(Mercadoria *m);//Obtem a mercadoria corrente.
int lcp_proximo();//Torna corrente o proximo item.
int lcp_finaliza();
int lcp_exibeListaCircular();

#endif // TADLISTACIRCULARPERSISTENTE_H_INCLUDED
