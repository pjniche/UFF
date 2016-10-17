#include <stdio.h>
#include "pokemon.h"

//faz a leitura dos dados do Pokemon.
Pokemon leituraPokemon(){
    Pokemon p;
    printf("Digite o nome do Pokemon: ");
    scanf("%s", p.nome);
    printf("Digite o numero do Pokemon: ");
    scanf("%d", &p.numero);
    printf("Digite o nivel do Pokemon: ");
    scanf("%d", &p.nivel);
    printf("Digite os valores de ataque, defesa e hp do Pokemon: ");
    scanf("%d %d %d", &p.ataque, &p.defesa, &p.hp);
    p.hp_bkp = p.hp;
    printf("Digite o nome do primeiro golpe do Pokemon: ");
    scanf("%s", &p.golpe1.nome);
    printf("Digite o valor base do primeiro golpe do Pokemon: ");
    scanf("%d", &p.golpe1.dano);
    printf("Digite o nome do segundo golpe do Pokemon: ");
    scanf("%s", &p.golpe2.nome);
    printf("Digite o valor base do segundo golpe do Pokemon: ");
    scanf("%d", &p.golpe2.dano);
    return p;
}

//retorna 1 se o hp atual do Pokemon é maior ou igual a 0.
int estaVivo(Pokemon p){
    if (p.hp >= 0){
        return 1;
    } else {
        return 0;
    }
}

//retorna o nome do Pokemon.
char* nomePokemon(Pokemon p){
    return p->nome;
}

//retorna o número de um Pokemon.
int numeroPokemon(Pokemon p){
    return p.numero;
}

//simula um ataque do Pokemon p1 ao Pokemon p2 utilizando o golpe m, retornando o dano causado.
int ataque(Pokemon p1, int m, Pokemon *p2){
    int dano;
    if (m == 1) {
        dano = (int)(((2*(float)p1.nivel+10)/250)*((float)p1.ataque/(float)p2->defesa)*(float)p1.golpe1.dano+2)*4;
    } else {
        dano = (int)(((2*(float)p1.nivel+10)/250)*((float)p1.ataque/(float)p2->defesa)*(float)p1.golpe2.dano+2)*4;
    }
    p2->hp = p2->hp - dano;
    return dano;
}

//restora o hp do pokemon ao máximo.
void curaPokemon(Pokemon *p){
    p->hp = p->hp_bkp;
    return 0;
}