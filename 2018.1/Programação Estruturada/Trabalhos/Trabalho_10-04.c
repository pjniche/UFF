#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MEDIA 0
#define ELEMENTOS {1,2,3}
#define TEXTO {"Universidade Federal Fluminense"}

void imprime(int v[], int tam){
    //Corre o vetor do final para o inicio de forma recursiva,
    //chegando ao inicio (tam==0), retorna imprimindo os caracteres.
    if (tam==0) return;
    imprime(v, tam-1);
    printf("%d", v[tam-1]);
return;
}

void imprime_reverso(int v[], int tam){
    //Corre o vetor do final para o inicio de forma recursiva,
    //imprimindo os caracteres ate chegar ao inicio (tam==0).
    if (tam==0) return;
    printf("%d", v[tam-1]);
    imprime(v, tam-1);
return;
}

void imprime_retorna(int v[], int fim, int ini, int tam){
    //Corre o vetor do inicio para o final de forma recursiva,
    //chegando ao fim (inicio==tamanho), retorna imprimindo.
    if (ini<tam) {
        imprime_retorna(v, fim, ini+1, tam);
        printf("%d", v[ini]);
        return;
    }
    //Corre o vetor do final para o inicio de forma recursiva,
    //chegando ao inicio (fim==0), retorna imprimindo.
    if (fim>0) {
        imprime_retorna(v, fim-1, ini, tam);
        printf("%d", v[fim-1]);
        return;
    }
return;
}

void min_max(int v[], int tam, int min, int max){
    //Inicia com "min" e "max" recebendo o ultimo valor do vetor.
    //ps: "tam", "min" e "max" entram no procedimento valendo o tamanho do vetor.
    if (tam==min&&max){
        min=v[tam-1];
        max=v[tam-1];
    }
    //Enquanto "tam" for maior que 0, chama o procedimento recursivamente.
    if (tam>0) {
        //Caso o elemento do vetor for menor que "min",
        //"min" recebe o elemento do vetor.
        if (v[tam-1]<min) min=v[tam-1];
        //Caso o elemento do vetor for maior que "max",
        //"max" recebe o elemento do vetor.
        if (v[tam-1]>max) max=v[tam-1];
        //Chama o proximo nivel da recursao.
        min_max(v, tam-1, min, max);
    }
    //Chegando ao fim (tam==0), imprime o resultado e finaliza.
    if (tam==0) printf("Min=%d Max=%d", min, max);
return;
}

void media(int v[], int n, int tam, int med){
    //Ao fim da recursao (n==0), imprime a media dos valores do vetor.
    if (n==0) {
        printf("Media=%.2f", (float)med/tam);
        return;
    }
    med+=v[n-1]; //"med" recebe a soma dos elementos do vetor.
    media(v, n-1, tam, med); //Chama o proximo nivel da recursao.
return;
}

//Nao finalizado!
void inverte_txt(char txt[], int n){
    if (n==0) return;
    inverte_txt(txt, n-1);
    printf("%c", txt[n-1]);
return;
}

int main(){
    int vetor[]=ELEMENTOS;
    char texto[]=TEXTO;

    //Envia um vetor de N elementos e o seu tamanho.
    imprime(vetor, sizeof(vetor)/4);
    printf("\n");

    //Envia um vetor de N elementos e o seu tamanho.
    imprime_reverso(vetor, sizeof(vetor)/4);
    printf("\n");

    //Envia um vetor de N elementos e seu tamanho para as variaveis "fim" e "tam",
    //"ini" recebe (tamanho-tamanho, basicamente 0).
    imprime_retorna(vetor, sizeof(vetor)/4, sizeof(vetor)/4-sizeof(vetor)/4, sizeof(vetor)/4);
    printf("\n");

    //Envia um vetor de N elementos e o seu tamanho para as variaveis "tam", "min" e "max".
    min_max(vetor, sizeof(vetor)/4, sizeof(vetor)/4, sizeof(vetor)/4);
    printf("\n");

    //Envia um vetor de N elementos e o seu tamanho para as variaveis "tam", "min" e "max".
    media(vetor, sizeof(vetor)/4, sizeof(vetor)/4, MEDIA);
    printf("\n");

    //Nao finalizado!
    inverte_txt(texto, strlen(texto));
return 0;
}
