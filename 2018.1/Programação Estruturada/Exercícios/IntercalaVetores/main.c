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

int v1[] = {3, 5, 20};
int v2[] = {1, 2, 5, 7, 21, 22};
int v3[] = {-1};
int repetidos = 0;

int exibe(int v[], int n){
    if (v[0] == -1){
        printf(" => Vazio!\n");
        return FALSE;
    }
    printf(" => ");
    for (int i = 0; i < n; i++){
        printf("[ %i ]", v[i]);
    }
    printf("\n");
    return TRUE;
}

int intercala(int tam_v1, int tam_v2){
    int i1 = 0, i2 = 0, i3 = 0;
    while (i1 <= tam_v1 && i2 <= tam_v2){
        if (i1 == tam_v1){
            //Caso chegar ao fim do vetor 1.
            for (int i = i2; i < tam_v2; i++){
                v3[i3] = v2[i2];
                i2++;
                i3++;
            }
            return TRUE;
        } else if (i2 == tam_v2){
            //Caso chegar ao fim do vetor 2.
            for (int i = i1; i < tam_v1; i++){
                v3[i3] = v1[i1];
                i1++;
                i3++;
            }
            return TRUE;
        }
        if (v1[i1] < v2[i2]){
            //Se vetor 1 for menor.
            v3[i3] = v1[i1];
            i1++;
            i3++;
        } else if (v1[i1] > v2[i2]){
            //Se vetor 2 for menor.
            v3[i3] = v2[i2];
            i2++;
            i3++;
        } else if (v1[i1] == v2[i2]){
            //Caso forem iguais
            //Sem repeticao.

            v3[i3] = v1[i1];
            i1++;
            i2++;
            i3++;
            repetidos++;

            //Com repeticao.
            /*
            v3[i3] = v1[i1];
            i3++;
            v3[i3] = v2[i2];
            i1++;
            i2++;
            i3++;
            */
        }
    }
    return TRUE;
}

void tela(){
    system("cls");//comando para ambiente Windows.
    printf("===========================\n");
    printf(" => Intercalar Vetores\n");
    printf("===========================\n");
    printf(" => Comandos:\n");
    printf("---------------------------\n");
    printf(" * 1 - Intercalar Vetores\n");
    printf(" * 0 - Finalizar\n\n");
    exibe(v1, sizeof(v1)/4);
    exibe(v2, sizeof(v2)/4);
    exibe(v3, (sizeof(v1)/4 + sizeof(v2)/4) - repetidos);
}

int menu(){
    tela();
    char opcao = getch();
    if ((opcao) == '0'){
        return FALSE;
    } else if ((opcao) == '1'){
        intercala(sizeof(v1)/4, sizeof(v2)/4);
    }
    return TRUE;
}

int main(){
    while (menu() == TRUE);
    printf("\nBye!\n");
    return 0;
}
