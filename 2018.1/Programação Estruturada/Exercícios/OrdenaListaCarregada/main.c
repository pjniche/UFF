#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

#define TRUE 0
#define FALSE 1

typedef struct aluno {
    char nome[50];
    int idade;
} Aluno;

typedef struct node {
    Aluno a;
    struct node *proximo;
    struct node *anterior;
} Node;

Node *corrente;

int cria(){
    corrente = NULL;
    return TRUE;
}

int maria(){
    Node *p = corrente;
    while (p->anterior != NULL){
        p = p->anterior;
    }
    while (p != NULL){
        if (strcmp(p->a.nome, "maria") == 0){
            corrente = p;
            return TRUE;
        }
        p = p->proximo;
    }
    return FALSE;
}

int insere(Aluno a){
    Node *novo = (Node *) malloc(sizeof(Node));
    novo->a = a;
    if (corrente == NULL){
        corrente = novo;
        novo->proximo = NULL;
        novo->anterior = NULL;
        return TRUE;
    }
    corrente->proximo = novo;
    novo->anterior = corrente;
    novo->proximo = NULL;
    corrente = novo;
    return TRUE;
}

int ordena(){
    if (corrente == NULL){
        return FALSE;
    }
    Node *inicio, *p1, *aux1, *p2, *aux2;
    int teste1, teste2;
    //Busca o inicio da lista.
    inicio = corrente;
    while (inicio->anterior != NULL){
        inicio = inicio->anterior;
    }
    //Caso de lista com 1 elemento.
    if (inicio->proximo == NULL){
        return FALSE;
    }
    //Posiciona os ponteiros.
    p1 = inicio;
    aux1 = p1->anterior;
    p2 = p1->proximo;
    if (p2 != NULL){
        aux2 = p2->proximo;
    } else {
        aux2 = NULL;
    }
    //TESTE1 e TESTE2 sinalizam se houve troca.
    while (p1 != NULL){
        printf("Debug: p1 != NULL +++++\n");
        teste1 = FALSE;
        while (p2 != NULL){
            printf("Debug: p2 != NULL -----\n");
            teste2 = FALSE;
            if (strcmp(p1->a.nome, p2->a.nome) > 0){
                //trocar.
                printf("Debug: %s > %s\n", p1->a.nome, p2->a.nome);
                printf("Debug: Invertendo %s e %s\n", p1->a.nome, p2->a.nome);
                p2->proximo = p1;
                p2->anterior = aux1;
                if (aux1 != NULL){
                    aux1->proximo = p2;
                }
                if (aux2 != NULL){
                    aux2->anterior = p1;
                }
                p1->proximo = aux2;
                p1->anterior = p2;
                teste1 = teste2 = TRUE;
            } else if (strcmp(p1->a.nome, p2->a.nome) == 0){
                if (p1->a.idade > p2->a.idade){
                    //trocar.
                    printf("Debug: %s == %s, %i > %i\n", p1->a.nome, p2->a.nome, p1->a.idade, p2->a.idade);
                    printf("Debug: Invertendo %s e %s\n", p1->a.nome, p2->a.nome);
                    p2->proximo = p1;
                    p2->anterior = aux1;
                    if (aux1 != NULL){
                        aux1->proximo = p2;
                    }
                    if (aux2 != NULL){
                        aux2->anterior = p1;
                    }
                    p1->proximo = aux2;
                    p1->anterior = p2;
                    teste1 = teste2 = TRUE;
                }
            }
            if (teste2 == TRUE){
                printf("Debug: teste2 TRUE\n\n");
                aux1 = p1->anterior;
                p2 = p1->proximo;
                if (p2 != NULL){
                    aux2 = p2->proximo;
                } else {
                    aux2 = NULL;
                }
            } else {
                printf("Debug: teste2 FALSE\n\n");
                p1 = p1->proximo;
                aux1 = p1->anterior;
                p2 = p1->proximo;
                if (p2 != NULL){
                    aux2 = p2->proximo;
                } else {
                    aux2 = NULL;
                }
            }
            getch();
        }
        //Se houver troca, percorre a lista novamente.
        if (teste1 == TRUE){
            printf("Debug: teste1 TRUE\n\n");
            p1 = inicio;
            aux1 = p1->anterior;
            p2 = p1->proximo;
            if (p2 != NULL){
                aux2 = p2->proximo;
            } else {
                aux2 = NULL;
            }
        } else {
            printf("Debug: teste1 FALSE\n\n");
            p1 = NULL;
        }
    }
    printf("Debug: return TRUE\n");
    getch();
    return TRUE;
}

int anterior(){
    if (corrente == NULL){
        return FALSE;
    }
    if (corrente->anterior != NULL){
        corrente = corrente->anterior;
    }
    return TRUE;
}

int proximo(){
    if (corrente == NULL){
        return FALSE;
    }
    if (corrente->proximo != NULL){
        corrente = corrente->proximo;
    }
    return TRUE;
}

int exibe(){
    if (corrente == NULL){
        printf(" => Vazia!\n");
        return FALSE;
    }
    Node *p1 = corrente;
    while (p1->anterior != NULL){
        p1 = p1->anterior;
    }
    printf(" => ");
    while (p1 != NULL){
        printf("[ %s ]->", p1->a.nome);
        p1 = p1->proximo;
    }
    printf("\n-------------------------------------------------\n");
    printf(" => Corrente: [ Nome: %s | Idade: %i ]\n\n", corrente->a.nome, corrente->a.idade);
    return TRUE;
}

void grava(){
    if (corrente == NULL){
        return;
    }
    FILE *fp;
    fp = fopen("lista.txt", "w");
    Node *aux = corrente;
    while (aux->anterior != NULL){
        aux = aux->anterior;
    }
    while (aux != NULL){
        fprintf(fp, "%s %i\n", aux->a.nome, aux->a.idade);
        aux = aux->proximo;
    }
    printf(" => Arquivo salvo!");
    getch();
    fclose(fp);
}

void recupera(){
    Aluno a;
    FILE *fp;
    fp = fopen("lista.txt", "r");
    while (EOF != fscanf(fp, "%s %i\n", a.nome, &a.idade)){
        insere(a);
    }
    fclose(fp);
}

void liberaMemoria(Node *p1, Node *prox){
    if (prox == NULL){
        printf(" - Liberando [ %s ]\n", p1->a.nome);
        free(p1);
        p1 = NULL;
    } else {
        liberaMemoria(p1, prox->proximo);
        printf(" - Liberando [ %s ]\n", prox->a.nome);
        free(prox);
        prox = NULL;
    }
}

int finaliza(){
    if(corrente == NULL){
        return TRUE;
    }
    Node *p1 = corrente;
    while (p1->anterior != NULL){
        p1 = p1->anterior;
    }
    liberaMemoria(p1, p1->proximo);
    corrente = NULL;
    return TRUE;
}

void tela(){
    system("cls");//comando para ambiente Windows.
    printf("===========================\n");
    printf(" => Ordenar Lista Carregada\n");
    printf("===========================\n");
    printf(" => Comandos:\n");
    printf("---------------------------\n");
    printf(" * 1 - Carregar lista\n");
    printf(" * 2 - Ordenar lista\n");
    printf(" * 3 - Gravar lista\n");
    printf(" * 4 - Anterior\n");
    printf(" * 6 - Proximo\n");
    printf(" * 0 - Finalizar\n\n");
    exibe();
}

int menu(){
    tela();
    char opcao = getch();
    if ((opcao) == '0'){
        return FALSE;
    } else if ((opcao) == '1') {
        recupera();
        maria();
    } else if ((opcao) == '2') {
        ordena();
    } else if ((opcao) == '3') {
        grava();
    } else if ((opcao) == '4') {
        anterior();
    } else if ((opcao) == '6') {
        proximo();
    }
    return TRUE;
}

int main(){
    cria();
    while (menu() == TRUE);
    finaliza();
    printf("\nBye!\n");
    return 0;
}
