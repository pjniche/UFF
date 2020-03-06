import java.util.Scanner;

public class DecimalExtenso {
  public static int leitura() {
    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite um número (Até 9 dígitos): ");
    int valorLido = teclado.nextInt();
    return valorLido;
  }

  public static void escrita(String valorEscrito) {
    System.out.println("Número por extenso: " + valorEscrito);
  }

  //verifica a casa dos milhões
  public static String milhao(int valor) {
    int milhaoInteiro = valor / 1000000;
    String resultado = new String();

    if (milhaoInteiro != 0) {
      if (milhaoInteiro == 1) {
        resultado = resultado.concat("um milhão");
      } else {
        resultado = resultado.concat(dezenaCentena(milhaoInteiro) + " milhões");
      }
    }
    return resultado;
  }

  //verifica a casa dos milhares
  public static String milhar(int valor) {
    int milharInteiro = valor / 1000;
    String resultado = new String();

    if (milharInteiro != 0) {
      if (milharInteiro == 1) {
        resultado = resultado.concat("mil");
      } else {
        resultado = resultado.concat(dezenaCentena(milharInteiro) + " mil");
      }
    }
    return resultado;
  }

  //verifica a casa das centenas e dezenas
  public static String dezenaCentena(int valor) {
    String resultado = new String();

    final int decimal[] = {
      900,800,700,600,500,400,300,200,100,
      90,80,70,60,50,40,30,20,
      19,18,17,16,15,14,13,12,11,
      10,9,8,7,6,5,4,3,2,1
    };
    final String extenso[] = {
      "novecentos","oitocentos","setecentos","seiscentos",
      "quinhentos","quatrocentos","trezentos","duzentos","cento",
      "noventa","oitenta","setenta","sessenta","cinquenta","quarenta","trinta","vinte",
      "dezenove","dezoito","dezessete","dezesseis","quinze","quatorze","treze","doze","onze",
      "dez","nove","oito","sete","seis","cinco","quatro","três","dois","um"
    };

    //concatena a string de saída
    for (int i = 0; i < decimal.length; i++) {
      int parteInteira = valor / decimal[i];
      for (int j = 0; j < parteInteira; j++) {
        if (valor % decimal[i] != 0) {
          resultado = resultado.concat(extenso[i] + " e ");
        } else {
          if (decimal[i] == 100) {
            resultado = resultado.concat("cem");
          } else {
            resultado = resultado.concat(extenso[i]);
          }
        }
      }
      valor = valor % decimal[i];
    }
    return resultado;
  }

  //monta o número extenso completo
  public static String numeroExtenso(int valor) {
    String resultado = new String();

    if (valor != 0) {
      if (valor >= 1000000) {
        resultado = resultado.concat(milhao(valor));
        valor = valor % 1000000;
        if (valor % 100000 == 0 | valor < 100000) {
          if (valor != 0) {
            resultado = resultado.concat(" e ");
          }
        } else {
          resultado = resultado.concat(", ");
        }
      }
      if (valor >= 1000) {
        resultado = resultado.concat(milhar(valor));
        valor = valor % 1000;
        if (valor % 100 == 0 | valor < 100) {
          if (valor != 0) {
            resultado = resultado.concat(" e ");
          }
        } else {
          resultado = resultado.concat(", ");
        }
      }
      if (valor > 0) {
      resultado = resultado.concat(dezenaCentena(valor));
      }
    } else {
      resultado = resultado.concat("zero");
    }
    return resultado;
  }

  public static void main(String[] args) {
    escrita(numeroExtenso(leitura()));
  }
}