#include<stdio.h>

int main() {

int lim_inf, lim_sup, soma = 0;

//Entrada dos valores do intervalo
printf("Digite o Limite Inferior: ");
scanf("%d", &lim_inf);
printf("Digite o Limite Superior: ");
scanf("%d", &lim_sup);

//Calcula o resto da divis�o por 2 para verificar se o n�mero � par.
//Caso par, imprime e soma-se ao conjunto de n�meros pares.
for (int i = lim_inf; i < lim_sup; i++) {
    if (i % 2 == 0) {
        printf("%d ", i);
        soma = soma + i;
    }
}

printf("\nSoma = %d", soma);

return 0;
}
