#include "TADListaCircularPersistente.h"

//ATENCAO: A estrutura Node que permite a lista encadeada
//nao esta disponivel para o programador que vai usar a TAD.
typedef struct node {
    Mercadoria m;
    struct node *proximo;
    struct node *anterior;
} Node;

//ATENCAO: As funcoes para persistencia usando arquivos e liberacao da
//memoria nao estao disponiveis para o programador que vai usar a TAD.
void recupera(char *filename);
void grava(char *filename);
void liberaMemoriaRecursivamente(Node *current, Node *prox);
//void liberaMemoria(Node *cur);

Node *corrente, *maior, *menor;

int lcp_cria(){
    corrente = NULL;
    recupera("arquivo.bin");
    return TRUE;
}

int lcp_insere(Mercadoria m){
    Node *novo = (Node *) malloc(sizeof(Node));
    novo->m = m;

    //Caso seja primeiro elemento.
    if (corrente == NULL){
        novo->proximo = novo;
        novo->anterior = novo;
        corrente = novo;
        maior = novo;
        menor = novo;
        return TRUE;
    }

    //Entrada em Ordem Alfabetica.
    Node *aux = menor;
    Node *p1 = aux;

    while (aux != maior){
        //AUX percorre toda a lista.
        if (strcmp(novo->m.nome, aux->m.nome) == 0){
            //Caso elemento ja exista na lista.
            printf("Elemento ja existe na Lista!\n");
            getch();
            return FALSE;
        }
        //P1 acompanha AUX ate achar algum
        //elemento maior que NOVO.
        if (strcmp(novo->m.nome, aux->m.nome) > 0){
            p1 = p1->proximo;
        }
        aux = aux->proximo;
    }
    if (aux == maior){
        //Caso NOVO seja igual a MAIOR.
        if (strcmp(novo->m.nome, aux->m.nome) == 0){
            printf("Elemento ja existe na Lista!\n");
            getch();
            return FALSE;
        }
        //Caso seja maior adiciona depois de MAIOR.
        if (strcmp(novo->m.nome, aux->m.nome) > 0){
            p1 = p1->proximo;
        }
    }
    //Adiciona sempre antes de p1.
    novo->proximo = p1;
    novo->anterior = p1->anterior;
    p1->anterior->proximo = novo;
    p1->anterior = novo;
    corrente = novo;
    //Atualiza o menor.
    if (strcmp(novo->m.nome, menor->m.nome) < 0){
        menor = novo;
    }
    //Atualiza o maior.
    if (strcmp(novo->m.nome, maior->m.nome) > 0){
        maior = novo;
    }
    return TRUE;
}

int lcp_remove(){
    if (corrente == NULL){
        printf("Vazia!");
        getch();
        return FALSE;
    }
    //Caso ultimo elemento
    if (corrente->proximo == corrente && corrente->anterior == corrente){
        free(corrente);
        corrente = maior = menor = NULL;
        return TRUE;
    }
    //Caso contrario
    if (corrente == menor){
        menor = menor->proximo;
    } else if (corrente == maior){
        maior = maior->anterior;
    }
    Node *p1 = corrente->anterior;
    Node *p2 = corrente->proximo;
    p1->proximo = p2;
    p2->anterior = p1;
    free(corrente);
    corrente = NULL;
    corrente = p2;
    return TRUE;
}

int lcp_corrente(Mercadoria *m){
    if (corrente == NULL){
        printf("Vazia!");
        getch();
        return FALSE;
    }
    *m = corrente->m;
    return TRUE;
}

int lcp_proximo(){
    if (corrente == NULL){
        printf("Vazia!");
        getch();
        return FALSE;
    }
    corrente = corrente->proximo;
    return TRUE;
}

int lcp_anterior(){
    if (corrente == NULL){
        printf("Vazia!");
        getch();
        return FALSE;
    }
    corrente = corrente->anterior;
    return TRUE;
}

int lcp_finaliza(){
    //Grava a lista atual
    grava("arquivo.bin");
    //Libera a memoria
    if (corrente == NULL) return TRUE;
    liberaMemoriaRecursivamente(corrente, corrente->proximo);
    corrente = maior = menor = NULL;
    return TRUE;
}

void liberaMemoriaRecursivamente(Node *current, Node *prox){
    if (prox == current){
        printf("Liberando... %s (Elemento Corrente)\n", current->m.nome);
        free(current);
    } else {
        liberaMemoriaRecursivamente(current, prox->proximo);
        printf("Liberando... %s\n", prox->m.nome);
        free(prox);
    }
}

/*
void liberaMemoria(Node *cur){
    Node * p1 = cur;
    Node * p2 = cur->proximo;
    while (p2 != cur){
        //p1 = p2;
        Node *aux = p2->proximo;
        printf("libera %s\n", p2->m.nome);
        free(p2);
        p1->proximo = aux;
        p2 = p1->proximo;
    }
    printf("libera corrente %s\n", p2->m.nome);
    free(p2);
}
*/

int lcp_exibeListaCircular(){
    if (corrente == NULL){
        printf("Vazia!\n");
        return FALSE;
    }
    Node *p1 = menor;
    Node *p2 = menor->proximo;
    printf("Lista: %s->", menor->m.nome);
    while (p2 != menor){
        p1 = p2;
        printf("%s->", p2->m.nome);
        p2 = p1->proximo;
    }
    printf("\n");
    printf("Corrente -> %s | Qte: %i | Preco: R$%.2lf\n", corrente->m.nome, corrente->m.quantidade, corrente->m.preco);
    //printf("<Debug> Maior: %s\n", maior->m.nome);
    //printf("<Debug> Menor: %s\n", menor->m.nome);
    return TRUE;
}

void grava(char *filename){
    FILE *fp;
    fp = fopen(filename, "w");//Abre o arquivo para escrita (write).
    Node *aux = corrente->proximo;//Percorre a lista ate encontrar o corrente.
    while (aux != corrente){
        fwrite(&aux->m, sizeof(Mercadoria), 1, fp);
        aux = aux->proximo;
    }
    fclose(fp);
}

void recupera(char *filename){
    Mercadoria m;
    FILE *fp;
    fp = fopen(filename, "r");//Abre o arquivo para leitura (read).
    while (!feof(fp)){
        fread(&m, sizeof(Mercadoria), 1, fp);
        lcp_insere(m);
    }
    fclose(fp);
}
