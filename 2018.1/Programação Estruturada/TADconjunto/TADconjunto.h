#ifndef TADCONJUNTO_H
#define TADCONJUNTO_H

#define FALSE 0
#define TRUE 1

void setInicializaConjuntos(void);
void setImprime(char setID);

int setCria(char setID);
int setAdiciona(char setID, int element);
int setPertence(char setID, int element);
int setUniao(char setID1, char setID2, char setID3);

int setIntersecao(char setID1, char setID2, char setID3);
int setTeste(char setID);


#endif // TADCONJUNTO_H
