#include "TADComparaLista.h"

typedef struct node {
    Mercadoria m;
    struct node *proximo;
    struct node *anterior;
} Node;

Node *maior[MAX], *menor[MAX];

int init(int n){
    for (int i = 0; i < (n-1); i++){
        maior[i] = menor[i] = NULL;
    }
    return TRUE;
}

int insere(Mercadoria m, int n){
    Node *novo = (Node *) malloc(sizeof(Node));
    novo->m = m;
    //Caso seja primeiro elemento.
    if (menor[n] == NULL){
        novo->proximo = NULL;
        novo->anterior = NULL;
        menor[n] = novo;
        maior[n] = novo;
        return TRUE;
    }
    //Entrada em Ordem Alfabetica.
    Node *aux = menor[n];
    Node *p1 = aux;

    while (aux->proximo != NULL){
        //P1 acompanha AUX ate achar algum
        //elemento maior que NOVO.
        if (strcmp(novo->m.nome, aux->m.nome) >= 0){
            p1 = p1->proximo;
        }
        aux = aux->proximo;
    }
    if (strcmp(novo->m.nome, aux->m.nome) <= 0){
        //Adiciona no inicio e no meio.
        novo->proximo = p1;
        novo->anterior = p1->anterior;
        if (p1->anterior != NULL){
            p1->anterior->proximo = novo;
        }
        p1->anterior = novo;
    } else if (strcmp(novo->m.nome, aux->m.nome) > 0){
        //adiciona depois do ultimo.
        novo->proximo = NULL;
        novo->anterior = p1;
        p1->proximo = novo;
    }
    //Atualiza o menor.
    if (strcmp(novo->m.nome, menor[n]->m.nome) < 0){
        menor[n] = novo;
    }
    //Atualiza o maior.
    if (strcmp(novo->m.nome, maior[n]->m.nome) > 0){
        maior[n] = novo;
    }
    return TRUE;
}

int unirLista(int x, int a, int b){
    if (menor[a] == NULL || menor[b] == NULL){
        printf("As duas listas devem conter elementos!\n\n");
        getch();
        return FALSE;
    }
    Node *aux1 = menor[a];
    Node *aux2 = menor[b];
    while (aux1 != NULL){
        insere(aux1->m, x);
        aux1 = aux1->proximo;
    }
    while (aux2 != NULL){
        insere(aux2->m, x);
        aux2 = aux2->proximo;
    }
    return TRUE;
}

int exibe(int n){
    if (menor[n] == NULL){
        printf("Lista %i: Vazia!\n\n", n);
        return FALSE;
    }
    Node *p1 = menor[n]->proximo;
    printf("Lista %i: %s->", n, menor[n]->m.nome);
    while (p1 != NULL){
        printf("%s->", p1->m.nome);
        p1 = p1->proximo;
    }
    printf("\n");
    printf("<Debug> Menor: %s\n", menor[n]->m.nome);
    printf("<Debug> Maior: %s\n", maior[n]->m.nome);
    printf("\n");
    return TRUE;
}
