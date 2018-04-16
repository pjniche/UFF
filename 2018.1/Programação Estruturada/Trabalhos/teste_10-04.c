#include <stdio.h>

#define ELEMENTOS {1,2,3}

void imprime(int vetor[], int fim, int inicio, int minimo, int maximo, int soma, int tamanho, int x, int y, int z){

    //Debug!
    //printf(">>> fim=%d / inicio=%d / minimo=%d / maximo=%d / soma=%d / tamanho=%d / X=%d Y=%d Z=%d <<<\n", fim, inicio, minimo, maximo, soma, tamanho, x, y, z);

    if (z==0){
        if (tamanho==minimo&&maximo){ //minimo e maximo recebem o ultimo elemento do vetor.
            minimo=vetor[tamanho-1];
            maximo=vetor[tamanho-1];
        }

        if (inicio<tamanho){
            imprime(vetor, fim, inicio+1, minimo, maximo, soma, tamanho, x, y, z);
            printf("%d", vetor[inicio]);
            return;
        }

        if (fim>0){
            if (vetor[fim-1]<minimo) minimo=vetor[fim-1];
            if (vetor[fim-1]>maximo) maximo=vetor[fim-1];

            soma+=vetor[fim-1]; //recebe a soma de todos os elementos.

            imprime(vetor, fim-1, inicio, minimo, maximo, soma, tamanho, x, y, z);

            printf("%d", vetor[fim-1]);
        return;
        }
    if (fim==0) imprime(vetor, fim, inicio, minimo, maximo, soma, tamanho, x, y, z+1);
    }

    if (z==1){
        if (y==tamanho){
            imprime(vetor, fim, inicio, minimo, maximo, soma, tamanho, x, y, z+1);
            return;
        }
        imprime(vetor, fim, inicio, minimo, maximo, soma, tamanho, x, y+1, z);
        printf("%d", vetor[y]);
        if (y==0) printf("\n");
        return;
    }

    if (z==2){
        if (x==0){
            imprime(vetor, fim, inicio, minimo, maximo, soma, tamanho, x, y, z+1);
            return;
        }
        imprime(vetor, fim, inicio, minimo, maximo, soma, tamanho, x-1, y, z);
        printf("%d", vetor[x-1]);
        if (x==tamanho) printf("\n");
        return;
    }

    if (z==3) printf("Minimo=%d Maximo=%d Media=%.2f\n", minimo, maximo, (float)soma/tamanho);

return;
}

int main(){
    int vetor[]=ELEMENTOS;

    //Envia um vetor de N elementos e seu tamanho N para as variaveis "fim", "minimo", "maximo", "tamanho", X, Y, Z,
    //"inicio" e "media" recebem ZERO. (tamanho-tamanho, basicamente 0).
    imprime(vetor, sizeof(vetor)/4, (sizeof(vetor)/4-sizeof(vetor)/4), sizeof(vetor)/4, sizeof(vetor)/4, (sizeof(vetor)/4-sizeof(vetor)/4), sizeof(vetor)/4, sizeof(vetor)/4, (sizeof(vetor)/4-sizeof(vetor)/4), 0);

return 0;
}
