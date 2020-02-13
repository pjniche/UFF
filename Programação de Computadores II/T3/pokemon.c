#include <stdio.h>
#include <stdlib.h>
#include "pokemon.h"

//faz a leitura dos dados do Pokemon.
Pokemon leituraPokemon(){
    Pokemon p;
    printf("Digite o nome do Pokemon: ");
    p.nome=(char*)malloc(100*sizeof(char));
    scanf("%s", p.nome);
    printf("Digite o numero do Pokemon: ");
    scanf("%d", &p.numero);
    printf("Digite o nivel do Pokemon: ");
    scanf("%d", &p.nivel);
    printf("Digite os valores de ataque, defesa e hp do Pokemon: ");
    scanf("%d %d %d", &p.ataque, &p.defesa, &p.hp);
    p.hp_max = p.hp;
    printf("Digite o numero de golpes do Pokemon: ");
    scanf("%d", &p.m);
    p.golpe=(Move*)malloc(p.m*sizeof(Move));
    for (int i=0;i<p.m;i++){
        printf("Digite o nome do golpe %d do Pokemon: ", i+1);
        scanf("%s", p.golpe[i].nome=(char*)malloc(100*sizeof(char)));
        printf("Digite o valor base do golpe %d do Pokemon: ", i+1);
        scanf("%d", &p.golpe[i].dano);
    }
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
    return p.nome;
}

//retorna o número de um Pokemon.
int numeroPokemon(Pokemon p){
    return p.numero;
}

//retorna o número de golpes de um Pokemon.
int numeroGolpes(Pokemon p){
    return p.m;
}

//simula um ataque do Pokemon p1 ao Pokemon p2 utilizando o golpe m, retornando o dano causado.
int ataque(Pokemon p1, int m, Pokemon *p2){
    int dano = (int)(((2*(float)p1.nivel+10)/250)*((float)p1.ataque/(float)p2->defesa)*(float)p1.golpe[m-1].dano+2)*4;
    p2->hp = p2->hp - dano;
    return dano;
}

//restora o hp do pokemon ao máximo.
void curaPokemon(Pokemon *p){
    p->hp = p->hp_max;
}
