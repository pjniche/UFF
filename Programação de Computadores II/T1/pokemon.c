#include<stdio.h>
#include<string.h>

typedef struct move {
    char nome[100];
    int dano;
} Move;

typedef struct pokemon {
    char nome[100];
    int numero, nivel, ataque, defesa, hp;
    Move golpe1, golpe2;
} Pokemon;

//Funcao que calcula o ataque
int ataque (Pokemon pokemon, int golpe) {
    int dano;
    if (golpe == 1) {
        printf("%s (#%d) usou %s.\n", pokemon.nome, pokemon.numero, pokemon.golpe1.nome);
        dano=(int)(((2*(float)pokemon.nivel+10)/250)*((float)pokemon.ataque/(float)pokemon.defesa)*(float)pokemon.golpe1.dano+2)*4;
    } else {
        printf("%s (#%d) usou %s.\n", pokemon.nome, pokemon.numero, pokemon.golpe2.nome);
        dano=(int)(((2*(float)pokemon.nivel+10)/250)*((float)pokemon.ataque/(float)pokemon.defesa)*(float)pokemon.golpe2.dano+2)*4;
    }
    return dano;
}

int main (void){
    Pokemon player1, player2;
    int golpe, movimentos, dano;

    strcpy(player1.nome, "Glaceon");
    player1.numero=471;
    player1.nivel=75;
    player1.ataque=123;
    player1.defesa=181;
    player1.hp=201;
    strcpy(player1.golpe1.nome, "Ice_Fang");
    player1.golpe1.dano=65;
    strcpy(player1.golpe2.nome, "Bite");
    player1.golpe2.dano=60;

    strcpy(player2.nome, "Garchomp");
    player2.numero=445;
    player2.nivel=78;
    player2.ataque=210;
    player2.defesa=163;
    player2.hp=270;
    strcpy(player2.golpe1.nome, "Fire_Fang");
    player2.golpe1.dano=65;
    strcpy(player2.golpe2.nome, "Earthquake");
    player2.golpe2.dano=100;
/*
    //Criando o primeiro Pokemon
    printf("<< PLAYER 1 >>\n");
    printf("Digite o nome do primeiro pokemon a atacar: ");
    scanf("%s", player1.nome);
    printf("Digite o numero do primeiro pokemon a atacar: ");
    scanf("%d", &player1.numero);
    printf("Digite o nivel do primeiro pokemon a atacar: ");
    scanf("%d", &player1.nivel);
    printf("Digite os valores de ataque, defesa e hp do primeiro pokemon a atacar: ");
    scanf("%d %d %d", &player1.ataque, &player1.defesa, &player1.hp);
    printf("Digite o nome do primeiro golpe do primeiro pokemon a atacar: ");
    scanf("%s", &player1.golpe1.nome);
    printf("Digite o valor base do primeiro golpe do primeiro pokemon a atacar: ");
    scanf("%d", &player1.golpe1.dano);
    printf("Digite o nome do segundo golpe do primeiro pokemon a atacar: ");
    scanf("%s", &player1.golpe2.nome);
    printf("Digite o valor base do segundo golpe do primeiro pokemon a atacar: ");
    scanf("%d", &player1.golpe2.dano);
    printf("\n");

    //Criando o segundo Pokemon
    printf("<< PLAYER 2 >>\n");
    printf("Digite o nome do segundo pokemon a atacar: ");
    scanf("%s", player2.nome);
    printf("Digite o numero do segundo pokemon a atacar: ");
    scanf("%d", &player2.numero);
    printf("Digite o nivel do segundo pokemon a atacar: ");
    scanf("%d", &player2.nivel);
    printf("Digite os valores de ataque, defesa e hp do segundo pokemon a atacar: ");
    scanf("%d %d %d", &player2.ataque, &player2.defesa, &player2.hp);
    printf("Digite o nome do primeiro golpe do segundo pokemon a atacar: ");
    scanf("%s", &player2.golpe1.nome);
    printf("Digite o valor base do primeiro golpe do segundo pokemon a atacar: ");
    scanf("%d", &player2.golpe1.dano);
    printf("Digite o nome do segundo golpe do segundo pokemon a atacar: ");
    scanf("%s", &player2.golpe2.nome);
    printf("Digite o valor base do segundo golpe do segundo pokemon a atacar: ");
    scanf("%d", &player2.golpe2.dano);
    printf("\n");
*/
    printf("<< PLAYER 1 >>\n");
    printf("Pokemon: %s (#%d)\n", player1.nome, player1.numero);
    printf("Ataque: %d | Defesa: %d | HP: %d\n", player1.ataque, player1.defesa, player1.hp);
    printf("Golpe 1: %s - Dano = %d\n", player1.golpe1.nome, player1.golpe1.dano);
    printf("Golpe 2: %s - Dano = %d\n", player1.golpe2.nome, player1.golpe2.dano);

    printf("<< PLAYER 2 >>\n");
    printf("Pokemon: %s (#%d)\n", player2.nome, player2.numero);
    printf("Ataque: %d | Defesa: %d | HP: %d\n", player2.ataque, player2.defesa, player2.hp);
    printf("Golpe 1: %s - Dano = %d\n", player2.golpe1.nome, player2.golpe1.dano);
    printf("Golpe 2: %s - Dano = %d\n", player2.golpe2.nome, player2.golpe2.dano);

    //Inicio da batalha
    printf("\nINICIO DA BATALHA!\n\n");
    movimentos = 0;
    do {
        if (player1.hp >0) {
            //Player 1 ataca
            printf("O pokemon %s (#%d) esta atacando.\n", player1.nome, player1.numero);
            printf("Digite o movimento que ele deve usar (1 ou 2): ");
            scanf("%d", &golpe);
            dano = ataque(player1, golpe);
            player2.hp = player2.hp - dano;
            movimentos++;
            printf("Dano causado em %s = %d\n\n", player2.nome, dano);
        }

        if (player2.hp > 0) {
            //Player 2 ataca
            printf("O pokemon %s (#%d) esta atacando.\n", player2.nome, player2.numero);
            printf("Digite o movimento que ele deve usar (1 ou 2): ");
            scanf("%d", &golpe);
            dano = ataque(player2, golpe);
            player1.hp = player1.hp - dano;
            movimentos++;
            printf("Dano causado em %s = %d\n\n", player1.nome, dano);
        }
    } while (player1.hp > 0 && player2.hp > 0);

    printf("FIM DE BATALHA!\n");
    if (player1.hp >0) {
        printf("\nO pokemon %s (#%d) venceu apos %d movimentos!\n", player1.nome, player1.numero, movimentos);
    } else {
        printf("\nO pokemon %s (#%d) venceu apos %d movimentos!\n", player2.nome, player2.numero, movimentos);
    }

    return 0;
}
