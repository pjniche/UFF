#ifndef POKEMON_H
#define POKEMON_H

typedef struct move{
    char* nome;
    int dano;
}Move;

typedef struct pokemon{
    char* nome;
    int numero, nivel, ataque, defesa, hp, hp_max, m;
    Move* golpe;
}Pokemon;

//Faz a leitura dos dados do Pokemon.
Pokemon leituraPokemon(FILE *f);

//Retorna 1 se o hp atual do Pokemon é maior ou igual a 0.
int estaVivo(Pokemon p);

//Retorna o nome do Pokemon.
char* nomePokemon(Pokemon p);

//Retorna o número de um Pokemon.
int numeroPokemon(Pokemon p);

//Retorna o número de golpes de um Pokemon.
int numeroGolpes(Pokemon p);

//Simula um ataque do Pokemon p1 ao Pokemon p2 utilizando o golpe m, retornando o dano causado.
int ataque(Pokemon p1, int m, Pokemon *p2);

//Restora o hp do Pokemon ao máximo.
void curaPokemon(Pokemon *p);

//Desaloca todos os ponteiros do Pokemon.
void desalocaPokemon(Pokemon *p);

#endif