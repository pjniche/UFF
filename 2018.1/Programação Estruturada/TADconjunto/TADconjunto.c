#include <stdio.h>
#include <stdlib.h>
#include "TADconjunto.h"

// sao 27 letras, portanto 27 conjuntos eh o maximo
#define MAX_CONJUNTOS 27
#define MAX_NUM_ELEMENTOS 100

int vetConjuntos[MAX_CONJUNTOS][MAX_NUM_ELEMENTOS];
int vetValidos[MAX_CONJUNTOS] ;
int vetTotais[MAX_CONJUNTOS] ;

// prepara o ambiente
void setInicializaConjuntos(){
    int i;
    for (i=0;i<MAX_CONJUNTOS;i++){
        vetValidos[i] = FALSE;// nenhum conjunto valido no inicio
        vetTotais[i] = 0; // nenhum elemento no inicio
    }
}

int setCria(char setID){
    int ix = setID - 'A';
    if (vetValidos[ix] == TRUE)
        return FALSE; // conjunto ja existe

    vetValidos[ix] = TRUE;
    return TRUE;
}

int setPertence(char setID, int element){
    int ix = setID - 'A', c;

    if (vetValidos[ix] == FALSE){
        printf("\nconjunto %c nao existente\n", setID);
        return FALSE;
    }
    int total = vetTotais[ix];
    for(c=0;c<total;c++)
        if (vetConjuntos[ix][c] == element){
            return TRUE;
        }
    return FALSE;
}

int setAdiciona(char setID, int element){
    /*
    vetConjuntos[setID - 'A'][total daquele conjunto] = element;
    total daquele conjunto ++
    */
    int ix = setID - 'A', c;


    if (vetValidos[ix] == TRUE){
        int total = vetTotais[ix];
        // ver se o elemento ja existe no conjunto
        if (setPertence(setID, element) == TRUE)
            return FALSE;

        if (total >= MAX_NUM_ELEMENTOS)
            return FALSE; // ta cheio pra caramba nao da mais para adicionar
        vetConjuntos[ix][total] = element;
        total++; // agora tenho um elemento a mais no conjunto
        vetTotais[ix] = total;
        // OU
        // vetConjuntos[ix][vetTotais[ix]++] = element;
    } else {
        return FALSE;
    }
    return TRUE;
}

int setUniao(char setID1, char setID2,
             char setID3){
    int ix1 = setID1-'A', ix2 = setID2-'A';

    // alo alunos , favor refatorar, dar uma melhorada colocando uma funcao de teste
    if (vetValidos[ix1] == FALSE){
        printf("\nconjunto %c nao existente\n", setID1);
        return FALSE;
    }
    if (vetValidos[ix2] == FALSE){
        printf("\nconjunto %c nao existente\n", setID2);
        return FALSE;
    }
    // testar se o 3o conjunto existe ou nao

    setCria(setID3); // crio o conjunto 3
    int total, c;

    // adiciono elementos do primeiro conjunto
    total = vetTotais[ix1];
    for(c=0;c<total;c++)
        setAdiciona(setID3, vetConjuntos[ix1][c]);

    // adiciono elementos do segundo conjunto tambem
    total = vetTotais[ix2];
    for(c=0;c<total;c++)
        setAdiciona(setID3, vetConjuntos[ix2][c]);

    return TRUE;
}

void setImprime(char setID){
    int ix = setID - 'A', c;

    if (vetValidos[ix] == FALSE){
        printf("\nconjunto %c nao existente\n", setID);
        return FALSE;
    }
    int total = vetTotais[ix];
    printf("\n");
    for(c=0;c<total;c++)
        printf("%i ", vetConjuntos[ix][c]);
}
