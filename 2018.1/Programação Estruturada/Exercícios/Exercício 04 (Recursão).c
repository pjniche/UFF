#include<stdio.h>

int intervalo (int inf, int sup, int sum) {
    if (inf == sup) {
        return sum;
    }
    //Calcula o resto da divisão por 2 para verificar se o número é par.
    //Caso par, soma-se ao total de pares e executa recursivamente com o Limite Inferior incrementado.
    if (inf % 2 == 0) {
        sum = sum + inf;
        printf("%d ", inf);
        sum = intervalo(inf + 1, sup, sum);
    //Caso contrário, somente executa recursivamente com o Limite Inferior incrementado.
    } else {
        sum = intervalo(inf + 1, sup, sum);
    }
return sum;
}

int main() {

int lim_inf, lim_sup, soma = 0;

//Entrada dos valores do intervalo
printf("Digite o Limite Inferior: ");
scanf("%d", &lim_inf);
printf("Digite o Limite Superior: ");
scanf("%d", &lim_sup);

//Removendo os valores iniciais e finais do intervalo.
lim_inf++;
lim_sup--;

soma = intervalo(lim_inf, lim_sup, soma);

printf("\nSoma = %d", soma);

return 0;
}
