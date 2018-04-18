#ifndef TADCONJUNTO_H
#define TADCONJUNTO_H

#define FALSE 0
#define TRUE 1

void setInicializaConjuntos(void);
int setCria(char setID);
int setAdiciona(char setID, int element);
int setUniao(char setID1, char setID2,
             char setID3);
void setImprime(char setID);

int setPertence(char setID, int element);


#endif // TADCONJUNTO_H
