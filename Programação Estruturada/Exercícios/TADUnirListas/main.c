#include "TADUnirListas.h"

void tela(){
    system("cls");//comando para ambiente Windows.
    printf("========================\n");
    printf(" => TAD Lista Encadeada\n");
    printf("========================\n");
    printf(" => Comandos:\n");
    printf("------------------------\n");
    printf(" * A - Insere na lista A\n");
    printf(" * B - Insere na lista B\n");
    printf(" * U - Unir listas A e B\n");
    printf(" * F - Finaliza\n\n");
    exibe(1);
    exibe(2);
    exibe(0);
}

int menu(){
    Mercadoria m;
    tela();
    char opcao = getch();
    if (toupper(opcao) == 'F'){//F ou f, "toupper" converte o caracter em maiusculo.
        return FALSE;
    } else if (toupper(opcao) == 'U') {
        unirLista(0, 1, 2);
    } else if (toupper(opcao) == 'A'){
        printf("Adicionar na Lista %c: ", toupper(opcao));
        scanf("%s", m.nome);
        insere(m, 1);
    } else if (toupper(opcao) == 'B'){
        printf("Adicionar na Lista %c: ", toupper(opcao));
        scanf("%s", m.nome);
        insere(m, 2);
    }
    return TRUE;
}

int main()
{
    init(MAX);
    while (menu() == TRUE);
    printf("Bye!");
    return 0;
}
