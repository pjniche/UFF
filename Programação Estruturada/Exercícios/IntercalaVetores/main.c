#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <ctype.h>
#include <math.h>

#define TRUE 0
#define FALSE 1

int v1[] = {3, 5, 20};//{1, 2, 5, 7, 21, 22};
int v2[] = {1, 2, 5, 7, 21, 22};
int v3[] = {-1};

int repetidos;

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

int intercala(int tam_v1, int tam_v2, char opcao){
    int i1 = 0, i2 = 0, i3 = 0;
    repetidos = 0;
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
            if (toupper(opcao) == 'S'){
                //Com repeticao.
                v3[i3] = v1[i1];
                i3++;
                v3[i3] = v2[i2];
                i1++;
                i2++;
                i3++;
            } else {
                //Sem repeticao.
                v3[i3] = v1[i1];
                i1++;
                i2++;
                i3++;
                repetidos++;
            }
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
    exibe(v1, sizeof(v1)/sizeof(int));
    exibe(v2, sizeof(v2)/sizeof(int));
    exibe(v3, (sizeof(v1)/sizeof(int) + sizeof(v2)/sizeof(int)) - repetidos);
}

int menu(){
    tela();
    char opcao1 = getch();
    if ((opcao1) == '0'){
        return FALSE;
    } else if ((opcao1) == '1'){
        printf("\nRepetir elementos no Vetor Intercalado (S/N)? ");
        char opcao2 = getch();
        intercala(sizeof(v1)/sizeof(int), sizeof(v2)/sizeof(int), opcao2);
    }
    return TRUE;
}

int main(){
    while (menu() == TRUE);
    printf("\nBye!\n");
    return 0;
}
