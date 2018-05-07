#include "ListaCircular.h"

int main(){
    // exercicio para os alunos
    // fazer um programa com menu
    // para caminhar na lista
    // mostrar o corrente
    // fazer persistencia
    // posicionar no primeiro etc
    // adicionar e retirar heroes

    Hero h;
    Hero vetor[]={
        {"SpiderMan", 3},
        {"SuperMan", 5},
        {"Hulk", 5},
        {"WonderWoman", 4}
    };

    inicializa();
    h = vetor[0];
    entrar(h);
    retirar(&h);
    printf("nome:%s poder:%i\n", h.nome, h.poder);

    h = vetor[1];
    entrar(h);
    h = vetor[2];
    entrar(h);
    proximo();
    proximo();
    retirar(&h);
    printf("nome:%s poder:%i\n", h.nome, h.poder);

    finaliza();
    return 0;
}
