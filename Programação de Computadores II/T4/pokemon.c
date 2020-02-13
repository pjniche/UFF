#include <stdio.h>
#include <stdlib.h>
#include "pokemon.h"

//faz a leitura dos dados do Pokemon.
Pokemon leituraPokemon(FILE *f){
    Pokemon* p=(Pokemon*)malloc(sizeof(Pokemon));
    fscanf(f,"%s", p->nome=(char*)malloc(100*sizeof(char)));
    fscanf(f,"%d", &p->numero);
    fscanf(f,"%d", &p->nivel);
    fscanf(f,"%d %d %d", &p->ataque, &p->defesa, &p->hp);
    p->hp_max = p->hp;
    fscanf(f,"%d", &p->m);
    p->golpe=(Move*)malloc(p->m*sizeof(Move));
    for (int i=0;i<p->m;i++){
        fscanf(f,"%s", p->golpe[i].nome=(char*)malloc(100*sizeof(char)));
        fscanf(f,"%d", &p->golpe[i].dano);
    }
    return *p;
    desalocaPokemon(p);
    free(p);
}

//Retorna 1 se o hp atual do Pokemon é maior ou igual a 0.
int estaVivo(Pokemon p){
    if (p.hp >= 0){
        return 1;
    } else {
        return 0;
    }
}

//Retorna o nome do Pokemon.
char* nomePokemon(Pokemon p){
    return p.nome;
}

//Retorna o número de um Pokemon.
int numeroPokemon(Pokemon p){
    return p.numero;
}

//Retorna o número de golpes de um Pokemon.
int numeroGolpes(Pokemon p){
    return p.m;
}

//Simula um ataque do Pokemon p1 ao Pokemon p2 utilizando o golpe m, retornando o dano causado.
int ataque(Pokemon p1, int m, Pokemon *p2){
    int dano = (int)(((2*(float)p1.nivel+10)/250)*((float)p1.ataque/(float)p2->defesa)*(float)p1.golpe[m-1].dano+2)*4;
    p2->hp = p2->hp - dano;
    return dano;
}

//Restora o hp do Pokemon ao máximo.
void curaPokemon(Pokemon *p){
    p->hp = p->hp_max;
}

//Desaloca todos os ponteiros do Pokemon.
void desalocaPokemon(Pokemon *p){
    for (int i=0;i<p->m;i++){
        free(p->golpe[i].nome);
    }
    free(p->golpe);
    free(p->nome);
}
