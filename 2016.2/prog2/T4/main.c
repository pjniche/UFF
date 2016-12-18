#include <stdio.h>
#include <stdlib.h>
#include "pokemon.h"



int main (int argc, char*argv[]){
    int golpe, movimentos, dano, p1, p2;
    char opcao;

    //verificando argumento
    if (argc==1){
        printf("ERRO! Nao foram passados argumentos.\n");
    }

    //abrindo arquivo
    FILE* arq=fopen(argv[1], "rt");
    if (arq==NULL){
        printf("ERRO! Arquivo inexistente.\n");
    }

    //criando pokemon
    Pokemon* player=(Pokemon*)malloc(atoi(argv[2])*sizeof(Pokemon));
    for (int i=0;i<atoi(argv[2]);i++){
        player[i]=leituraPokemon(arq);
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
    
    //desalocando
    for (int i=0;i<atoi(argv[2]);i++){
        desalocaPokemon(&player[i]);
    }
    free(player);
    //fechando arquivo
    fclose(arq);

    return 0;
}
