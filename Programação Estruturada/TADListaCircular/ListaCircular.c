#include "ListaCircular.h"

typedef struct node {
    Hero h;
    struct node *proximo;
} Node;

Node *corrente;

void menu(void){
    printf("            _,    _   _    ,_\n");
    printf("       .o888P     Y8o8Y     Y888o.\n");
    printf("      d88888      88888      88888b\n");
    printf("     d888888b_  _d88888b_  _d888888b\n");
    printf("     8888888888888888888888888888888\n");
    printf("     8888888888888888888888888888888\n");
    printf("     YJGS8P8Y888P8Y888P8Y888P8Y8888P\n");
    printf("      Y888   '8'   Y8P   '8'   888Y\n");
    printf("       '8o          V          o8'\n");
    printf("         `                     `\n");
    printf(" ======================================= \n");
    printf("| ----=> 1 - Adicionar Heroi            |\n");
    printf("| ----=> 2 - Proximo Heroi              |\n");
    printf("| ----=> 3 - Remover Heroi              |\n");
    printf("| ----=> 0 - Sair                       |\n");
    printf(" ======================================= \n");
    printf(" => Corrente: %s\n", corrente->h.nome);
    printf(" => ");
}

int inicializa(void){
    corrente = NULL;
    return TRUE;
}

int finaliza(void){
    if (vazia() == TRUE) return FALSE;
    // favor liberar a memoria alocada
    Node *aux, *aux2;
    aux = corrente;
    // aux guarda o corrente, enquanto ele
    // percorre a lista ate chegar ao elemento
    // anterior ao aux
    // aux2 segue o corrente liberando a memoria
    while (corrente->proximo != aux){
        aux2 = corrente;
        corrente = corrente->proximo;
        free(aux2);
    }
    free(aux);
    free(corrente);
    return TRUE;
}

int entrar(void){
    Node *nd = (Node *) malloc(sizeof(Node));
    printf(" => Nome: ");
    scanf("%s", nd->h.nome);
    printf(" => Poder: ");
    scanf("%i", &nd->h.poder);

    // caso especifico de primeiro elemento
    if (vazia() == TRUE){
        nd->proximo = nd;
        corrente = nd;
        return TRUE;
    }

    // funciona para 1,2 ou N elementos (ja fiz o desenho)
    Node *aux = corrente->proximo;
    corrente->proximo = nd;
    nd->proximo = aux;
    corrente = nd;

    // falta ordenar alfabeticamente!

    return TRUE;
}

int retirar(void){
    if (vazia() == TRUE){
        printf(" => Lista vazia!");
        getch();
        return FALSE;
    }
    Node *aux = corrente;
    // aux guarda o corrente, enquanto ele
    // percorre a lista ate chegar ao elemento
    // anterior ao aux, caso seja o ultimo
    // corrente recebe NULL
    while (corrente->proximo != aux){
        corrente = corrente->proximo;
    }
    if (corrente->proximo == corrente){
        corrente = NULL;
    } else {
        corrente->proximo = aux->proximo;
    }
    free(aux);
    return TRUE;
}

int proximo(void){
    if (vazia() == TRUE){
        printf(" => Lista vazia!");
        getch();
        return FALSE;
    }
    corrente = corrente->proximo;
    return TRUE;
}

int vazia(void){
    if (corrente == NULL) return TRUE;
    return FALSE;
}
