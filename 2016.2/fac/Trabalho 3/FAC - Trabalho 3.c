//UFF - Universidade Federal Fluminense
//Fundamentos de Arquitetura de Computadores
//Trabalho 3

#include<stdio.h>
#include<math.h>

int main(void){
    int celula, bloco, linha, mapeamento, conjunto;

    printf("Mapeamento de Memoria Cache.\n");
    printf("Digite o numero de Celulas da MP (Cada Celula possui 1 byte): ");
    scanf("%d", &celula);
    printf("Digite o tamanho dos Blocos da MP (Numero de Celulas por Bloco): ");
    scanf("%d", &bloco);
    if ((float)log2(bloco)!=(int)log2(bloco)){ //se o valor for potencia de 2 entao (float)log2 e (int)log2 serao iguais.
        printf("ERRO! Tamanho dos Blocos nao e potencia de 2!");
        return 1;
    }
    if (celula%bloco!=0){
        printf("ERRO! Numero de Celulas e incompativel!");
        return 1;
    }
    printf("Digite o numero de linhas da Cache: ");
    scanf("%d", &linha);
    if ((float)log2(linha)!=(int)log2(linha)){ //se o valor for potencia de 2 entao (float)log2 e (int)log2 serao iguais.
        printf("ERRO! O numero de Linhas da Cache nao e potencia de 2!");
        return 1;
    }
    printf("\n");

    printf("Escolha o tipo de mapeamento da Cache\n");
    printf(" 1 - Direto\n");
    printf(" 2 - Associativo\n");
    printf(" 3 - Associativo por Conjuntos\n");
    printf(" >: ");
    scanf("%d", &mapeamento);
    printf("\n");

    switch(mapeamento){
        case 1:
        printf("Mapeamento Direto.\n");
        printf("Endereco da MP possui %d bits.\n", (int)log2(celula));
        printf("[ Tag = %d bit(s) | Bloco = %d bit(s) | Celula = %d bit(s) ]\n", (int)log2(celula)-((int)log2(linha)+(int)log2(bloco)), (int)log2(linha), (int)log2(bloco));
        printf("\n");
        printf("Formato da Memoria Cache.\n");
        int i, j;
        for (i=0; i<linha; i++){
        	printf("Linha %d [ Valido | Tag ", i);
        	for (j=0; j<bloco; j++){
        		printf("| Celula %d ", j);
			}
			printf("]\n");
		}
		printf("Tamanho total da memoria cache = %d bytes", linha*bloco);
        break;

        case 2:
        printf("Associativo");
        printf("Endereco da MP possui %d bits.\n", (int)log2(celula));
        printf("[ Tag = %d bit(s) | Celula = %d bit(s) ]\n", (int)log2(celula)-(int)log2(bloco), (int)log2(bloco));
        printf("\n");
        printf("Formato da Memoria Cache.\n");
        int l, m;
        for (l=0; l<linha; l++){
        	printf("Linha %d [ Valido | Tag ", l);
        	for (m=0; m<bloco; m++){
        		printf("| Celula %d ", m);
			}
			printf("]\n");
		}
		printf("Tamanho total da memoria cache = %d bytes", linha*bloco);
        break;

        case 3:
        printf("Associativo por Conjuntos\n");
        printf("Digite o numero de Conjuntos: ");
        scanf("%d", &conjunto);
        if ((float)log2(conjunto)!=(int)log2(conjunto)){ //se o valor for potencia de 2 entao (float)log2 e (int)log2 serao iguais.
            printf("ERRO! O numero de Conjuntos da Cache nao e potencia de 2!");
            return 1;
        }
        printf("Endereco da MP possui %d bits.\n", (int)log2(celula));
        printf("[ Tag = %d bit(s) | Conjunto = %d bit(s) | Celula = %d bit(s) ]\n", (int)log2(celula)-((int)log2(linha/conjunto)+(int)log2(bloco)), (int)log2(linha/conjunto), (int)log2(bloco));
        printf("\n");
        printf("Formato da Memoria Cache.\n");
        int n, o, p=0, q=0;
        for (n=0; n<linha; n++){
        	printf("Linha %d [ Valido | Tag ", n);
        	for (o=0; o<bloco; o++){
        		printf("| Celula %d ", o);
			}
			if (p%2==0){
				printf("] } Conjunto %d\n", q);
				q++;
			} else {
				printf("]\n");
			}
			p++;
		}
		printf("Tamanho total da memoria cache = %d bytes", linha*bloco);
        break;
    }
    return 0;
}
/*
ps: Meus testes foram feitos usando a seguinte configuracao:
MP de 16 bytes, Blocos de 2 bytes e 4 Linhas de Cache (com Conjuntos de 2).
*/