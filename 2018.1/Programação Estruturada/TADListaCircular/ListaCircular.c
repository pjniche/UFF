#include "ListaCircular.h"

typedef struct node {
    Hero h;
    struct node *proximo;
} Node;

Node *corrente;

int inicializa(void){
    corrente = NULL;
    return TRUE;
}

int finaliza(void){
    // favor liberar a memoria alocada
    corrente = NULL;
    return TRUE;
}

int entrar(Hero h){
    Node *nd = (Node *) malloc(sizeof(Node));
    nd.h = h;
    // favor alterar para inserir ordenadamente
    // por enquanto nao

    //if (vazia()){ // fazer o vazia
    if (corrente == NULL){
        nd->proximo = nd;
        corrente = nd;
        return TRUE;
    }
    // funciona para 1,2 ou N elementos (ja fiz o desenho)
    Node *aux = corrente->proximo ;
    corrente->proximo = nd;
    nd->proximo = aux;
    corrente = nd;

    return TRUE;
}

int retirar(Hero *h){
    return FALSE;
}

int proximo(void){
    // testar vazia
    return FALSE;
}
