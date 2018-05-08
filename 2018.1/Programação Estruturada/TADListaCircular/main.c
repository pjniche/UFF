#include "ListaCircular.h"

int main(){
    // exercicio para os alunos
    // fazer um programa com menu
    // para caminhar na lista
    // mostrar o corrente
    // fazer persistencia
    // posicionar no primeiro etc
    // adicionar e retirar heroes
    /*
    FILE *heroes = fopen("heroes.txt", "a");
    if (heroes == NULL){
        printf(" => ERRO! O arquivo não foi criado!");
        return 0;
    }
    */
    // falta gravar no arquivo!
    int opcao;
    inicializa();
    while (opcao!=0){
        system("cls");
        menu();
        scanf("%i", &opcao);
        if (opcao < 0 || opcao > 3){// limita as opcoes de entrada
            printf(" => Opcao Invalida!");
            getch();
        }
        switch (opcao) {
            case 1: {// adicionar heroi
                entrar();
                break;
            }
            case 2: {// proximo heroi
                proximo();
                break;
            }
            case 3: {// remover heroi
                retirar();
                break;
            }
        }
    }
    finaliza();
    /*
    fclose(heroes);
    */
    return 0;
}
