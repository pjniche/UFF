#include <stdio.h>
#include <stdlib.h>
#include "pokemon.h"

int main (void){
    int golpe, movimentos, dano, p, p1, p2;
    char opcao;

    //Carregando atributos
    printf("Digite o numero total de pokemons: ");
    scanf("%d", &p);
    printf("\n");
    Pokemon* player=(Pokemon*)malloc(p*sizeof(Pokemon)); //<--- alocando memoria
    for (int i=0;i<p;i++){
        printf("Digite os atributos do pokemon %d.\n", i+1);
        player[i]=leituraPokemon();
        printf("\n");
    }

    do {
        //Inicio da batalha
        printf("INICIO DA BATALHA!\n");
        movimentos = 0;
        printf("Digite o numero do primeiro pokemon a atacar: ");
        scanf("%d", &p1);
        printf("Digite o numero do segundo pokemon a atacar: ");
        scanf("%d", &p2);
        printf("\n");
        do {
            //Player 1 ataca
            if (estaVivo(player[p1-1]) == 1){
                printf("O pokemon %s (#%d) esta atacando.\n", nomePokemon(player[p1-1]), numeroPokemon(player[p1-1]));
                printf("Digite o movimento que ele deve usar (1 a %d): ", numeroGolpes(player[p1-1]));
                scanf("%d", &golpe);
                dano = ataque(player[p1-1], golpe, &player[p2-1]);
                printf("Dano causado em %s = %d\n\n", nomePokemon(player[p2-1]), dano);
                movimentos++;
            }
            //Player 2 ataca
            if (estaVivo(player[p2-1]) == 1){
                printf("O pokemon %s (#%d) esta atacando.\n", nomePokemon(player[p2-1]), numeroPokemon(player[p2-1]));
                printf("Digite o movimento que ele deve usar (1 a %d): ", numeroGolpes(player[p2-1]));
                scanf("%d", &golpe);
                dano = ataque(player[p2-1], golpe, &player[p1-1]);
                printf("Dano causado em %s = %d\n\n", nomePokemon(player[p1-1]), dano);
                movimentos++;
            }
        } while (estaVivo(player[p1-1]) == 1 && estaVivo(player[p2-1]) == 1);

        //Fim da batalha
        printf("FIM DE BATALHA!\n");
        if (estaVivo(player[p1-1]) == 1){
            printf("O pokemon %s (#%d) venceu apos %d movimentos!", nomePokemon(player[p1-1]), numeroPokemon(player[p1-1]), movimentos);
        }
        if (estaVivo(player[p2-1]) == 1){
            printf("O pokemon %s (#%d) venceu apos %d movimentos!", nomePokemon(player[p2-1]), numeroPokemon(player[p2-1]), movimentos);
        }
        printf("\n");

        printf("Deseja simular outra batalha?: ");
        scanf(" %c", &opcao);
        curaPokemon(&player[p1-1]);
        curaPokemon(&player[p2-1]);
        printf("\n");

    } while (opcao != 78);

    return 0;
}
