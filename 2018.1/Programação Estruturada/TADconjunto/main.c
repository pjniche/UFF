#include <stdio.h>
#include <stdlib.h>
#include "TADconjunto.h"

int main(){
    setInicializaConjuntos();//prepara para usar a biblioteca de conjuntos

    setCria('A');
    setCria('B');
    setAdiciona('A', 1);
    setAdiciona('A', 2);
    setAdiciona('A', 4);
    printf("\n --- conjunto A\n");
    setImprime('A');

    setAdiciona('B', 5);
    setAdiciona('B', 3);
    setAdiciona('B', 6);
    printf("\n --- conjunto B\n");
    setImprime('B');

    setUniao('A', 'B', 'C');
    printf("\n --- conjunto C uniao A e B\n");
    setImprime('C');
    return 0;
}
