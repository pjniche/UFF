#include <stdio.h>
#include <stdlib.h>
#include "pokemon.h"

int main (void){
    int golpe, movimentos, dano, n;
    char opcao;

    //main.c pokemon.c funcionais
    //escolha do numero de pokemon e golpes funcionais.

    //Carregando atributos
    printf("Digite o numero total de pokemon: ");
    scanf("%d", &n);
    printf("\n");

    Pokemon* player=(Pokemon*)malloc(n*sizeof(Pokemon));
    for (int i;i<n;i++){
        printf("Digite os atributos do pokemon %d: ", i+1);
        printf("\n");        
        player[i]=leituraPokemon();
    }
    printf("\n");
/*
    do {
        //Inicio da batalha
        printf("INICIO DA BATALHA!\n");
        movimentos = 0;

        do {
            //Player 1 ataca
            if (estaVivo(player1) == 1){
                printf("O pokemon %s (#%d) esta atacando.\n", nomePokemon(player1), numeroPokemon(player1));
                printf("Digite o movimento que ele deve usar: ");
                scanf("%d", &golpe);
                dano = ataque(player1, golpe, &player2);
                printf("Dano causado em %s = %d\n\n", nomePokemon(player2), dano);
                movimentos++;
            }
            //Player 2 ataca
            if (estaVivo(player2) == 1){
                printf("O pokemon %s (#%d) esta atacando.\n", nomePokemon(player2), numeroPokemon(player2));
                printf("Digite o movimento que ele deve usar: ");
                scanf("%d", &golpe);
                dano = ataque(player2, golpe, &player1);
                printf("Dano causado em %s = %d\n\n", nomePokemon(player1), dano);
                movimentos++;
            }
        } while (estaVivo(player1) == 1 && estaVivo(player2) == 1);

        //Fim da batalha
        printf("FIM DE BATALHA!\n");
        if (estaVivo(player1) == 1){
            printf("O pokemon %s (#%d) venceu apos %d movimentos!\n", nomePokemon(player1), numeroPokemon(player1), movimentos);
        }
        if (estaVivo(player2) == 1){
            printf("O pokemon %s (#%d) venceu apos %d movimentos!\n", nomePokemon(player2), numeroPokemon(player2), movimentos);
        }

        printf("Deseja simular outra batalha?: ");
        scanf(" %c", &opcao);
        curaPokemon(&player1);
        curaPokemon(&player2);
        printf("\n");

    } while (opcao != 78);
    free(player); //desalocar a memoria
*/
    return 0;
}