#include "TADListaCircularPersistente.h"

void tela(){
    system("cls");//comando para ambiente Windows.
    printf("============================================\n");
    printf(" => TAD Lista Encadeada Circular Persistente\n");
    printf("============================================\n");
    printf(" => Comandos:\n");
    printf("--------------------------------------------\n");
    printf(" * A - Anterior\n");
    printf(" * P - Proximo\n");
    printf(" * I - Insere\n");
    printf(" * R - Remove\n");
    printf(" * F - Finaliza\n\n");
    lcp_exibeListaCircular();
}

int menu(){
    Mercadoria m;
    tela();
    char opcao = getch();
    if (toupper(opcao) == 'F'){//F ou f, "toupper" converte o caracter em maiusculo.
        return FALSE;
    } else if (toupper(opcao) == 'A'){
        int ok = lcp_anterior();//torna corrente o item anterior.
        if (ok){
            lcp_corrente(&m);
        }
    } else if (toupper(opcao) == 'P'){
        int ok = lcp_proximo();//Torna corrente o proximo item.
        if (ok){
            lcp_corrente(&m);
        }
    } else if (toupper(opcao) == 'R'){
        int ok = lcp_corrente(&m);
        if (ok){
            printf("Remover %s | Qte: %i | Preco: R$%.2lf? (S/N)\n", m.nome, m.quantidade, m.preco);
            char tecla = getch();
            if (toupper(tecla) == 'S'){
                printf("Removendo...\n");
                lcp_remove();
                printf("Removido!\n");
                getch();
            }
            ok = lcp_corrente(&m);
        }
    } else if (toupper(opcao) == 'I'){
        printf("Digite Nome, Quantidade e Preco: ");
        scanf("%s%i%lf", m.nome, &m.quantidade, &m.preco);
        lcp_insere(m);
        lcp_corrente(&m);
    }
    return TRUE;
}

int main(){
    lcp_cria();
    while (menu());
    lcp_finaliza();
    printf("\nBye!");
    return 0;
}
