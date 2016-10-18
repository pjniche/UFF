#include <stdio.h>
#include "pokemon.h"

int main (void){
    Pokemon player1, player2;
    int golpe, movimentos, dano;
    char opcao;

    //Carregando atributos
    printf("Entre com os atributos do primeiro Pokemon.\n");
    player1=leituraPokemon();
    printf("\n");
    printf("Entre com os atributos do segundo Pokemon.\n");
    player2=leituraPokemon();
    printf("\n\n");

    //Inicio da batalha
    printf("\nINICIO DA BATALHA!\n\n");
    movimentos = 0;
    do {
        do {
            //Player 1 ataca
            printf("O pokemon %s (#%d) esta atacando.\n", nomePokemon(player1), numeroPokemon(player1));
            printf("Digite o movimento que ele deve usar (1 ou 2): ");
            scanf("%d", &golpe);
            dano = ataque(player1, golpe, &player2);
            printf("Dano causado em %s = %d\n\n", nomePokemon(player2), dano);
            movimentos++;
            //Player 2 ataca
            printf("O pokemon %s (#%d) esta atacando.\n", nomePokemon(player2), numeroPokemon(player2));
            printf("Digite o movimento que ele deve usar (1 ou 2): ");
            scanf("%d", &golpe);
            dano = ataque(player2, golpe, &player1);
            printf("Dano causado em %s = %d\n\n", nomePokemon(player1), dano);
            movimentos++;
            //Fim da batalha
            printf("FIM DE BATALHA!\n");
            if (estaVivo(player1) == 1){
                printf("\nO pokemon %s (#%d) venceu apos %d movimentos!\n", nomePokemon(player1), numeroPokemon(player1), movimentos);
            }
            if (estaVivo(player2) == 1){
                printf("\nO pokemon %s (#%d) venceu apos %d movimentos!\n", nomePokemon(player2), numeroPokemon(player2), movimentos);
            }
        } while (estaVivo(player1) == 1 && estaVivo(player2) == 1);
        printf("Deseja simular outra batalha?: ");
        scanf("%c", &opcao);
        curaPokemon(&player1);
        curaPokemon(&player2);
        printf("\n\n");
    } while (opcao != 'N');

    return 0;
}