//UFF - Universidade Federal Fluminense

//Fundamentos de Arquitetura de Computadores
//Prof.(a): Fernanda Passos

//Trabalho 1
//Paulo Roberto Niche Ramos Junior

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>

#define max 100

int verifica_base(char valor[], int base){
	int i=0;
	switch(base){

		case 16:
		while(i<strlen(valor)){
			if ((valor[i]>=48 && valor[i]<=57) || (valor[i]>=65 && valor[i]<=70)) /*O argumento verifica se o caracter na posicao "i"
			do vetor eh referente a um numero (0,1,2,3,4,5,6,7,8,9) ou uma letra (A,B,C,D,E,F), com base na tabela ASCII*/
			{
				i++;
			} else {
				return 1;
			}
		}
		break;

		case 10:
		while(i<strlen(valor)){
			if (valor[i]>=48 && valor[i]<=57) /*O argumento verifica se o caracter na posicao "i"
			do vetor eh referente a um numero (0,1,2,3,4,5,6,7,8,9) com base na tabela ASCII*/
			{
				i++;
			} else {
				return 1;
			}
		}
		break;

		case 7:
		while(i<strlen(valor)){
			if (valor[i]>=48 && valor[i]<=54) /*O argumento verifica se o caracter na posicao "i"
			do vetor eh referente a um numero (0,1,2,3,4,5,6) com base na tabela ASCII*/
			{
				i++;
			} else {
				return 1;
			}
		}
		break;

		case 2:
		while(i<strlen(valor)){
			if (valor[i]>=48 && valor[i]<=49) /*O argumento verifica se o caracter na posicao "i"
			do vetor eh referente a um numero (0,1) com base na tabela ASCII*/
			{
				i++;
			} else {
				return 1;
			}
		}
		break;

		default: return 1;
		break;
	}
	return 0;
}

int base10(char num[], int base){
	int i=0, resultado=0;
	strrev(num);
	while(i<strlen(num)){
		if (num[i]>=65 && num[i]<=70){
			resultado+=((num[i]-55)*(pow(base,i)));
		} else {
			resultado+=((num[i]-48)*(pow(base,i)));
		}
		i++;
	}
return resultado;
}

void base2(int num){
	char bin[3]="01";
	char temp[2], resultado[max];
	int resto=0;
	while(num>1){
		resto=num%2;
		num/=2;
		sprintf(temp, "%c", bin[resto]);
		strcat(resultado, temp);
	}
	sprintf(temp, "%c", bin[num]);
	strcat(resultado, temp);
	printf("Resultado = %s", strrev(resultado));
}

void base7(int num){
	char hep[8]="0123456";
	char temp[2], resultado[max];
	int resto=0;
	while(num>6){
		resto=num%7;
		num/=7;
		sprintf(temp, "%c", hep[resto]);
		strcat(resultado, temp);
	}
	sprintf(temp, "%c", hep[num]);
	strcat(resultado, temp);
	printf("Resultado = %s", strrev(resultado));
}

void base16(int num){
	char hex[17]="0123456789ABCDEF";
	char temp[2], resultado[max];
	int resto=0;
	while(num>15){
		resto=num%16;
		num/=16;
		sprintf(temp, "%c", hex[resto]);
		strcat(resultado, temp);
	}
	sprintf(temp, "%c", hex[num]);
	strcat(resultado, temp);
	printf("Resultado = %s", strrev(resultado));
}

int main (){
	char valor[max];
	int base_entrada=0, base_saida=0, resultado=0, valida=0;

	printf("Esse programa converte valores de uma base numerica X para uma outra Y.\n");
	printf("As bases compativeis sao: 2, 7, 10 e 16.\n\n");
	printf("Utilize o seguinte formato: VALOR A SER CONVERTIDO, BASE DE ENTRADA, BASE DE SAIDA\n");
	printf("Digite os valores a serem convertidos (Separados por espaco): ");
	scanf("%s %d %d", valor, &base_entrada, &base_saida);

	valida=verifica_base(valor, base_entrada);
	if (valida!=0){
		printf("Resultado = Invalido!");
		return 0;
	}

	switch(base_saida){

		case 10:{
			resultado=base10(valor, base_entrada);
			printf("Resultado = %d", resultado);
		}
		break;

		case 2:{
			if (base_entrada==base_saida){
				printf("Resultado = %s", valor);
			} else if (base_entrada==10){
				base2(atoi(valor));
			} else {
				base2(base10(valor, base_entrada));
			}
		}
		break;

		case 7:{
			if (base_entrada==base_saida){
				printf("Resultado = %s", valor);
			} else if (base_entrada==10){
				base7(atoi(valor));
			} else {
				base7(base10(valor, base_entrada));
			}
		}
		break;

		case 16:{
			if (base_entrada==base_saida){
				printf("Resultado = %s", valor);
			} else if (base_entrada==10){
				base16(atoi(valor));
			} else {
				base16(base10(valor, base_entrada));
			}
		}
		break;

		default:{
			printf("Resultado = Invalido!");
		}
	}
return 0;	
}
