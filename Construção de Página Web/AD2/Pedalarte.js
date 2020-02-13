
//AD2 Exercício 01
//Peças.html
function janelaGuidons() {
    var janela = window.open("Pecas_Guidons.html", "Guidons", "width=500,height=500");
}

function janelaSelins() {
    var janela = window.open("Pecas_Selins.html", "Selins", "width=500,height=500");
}

function janelaPedal() {
    var janela = window.open("Pecas_Pedal.html", "Pedal", "width=500,height=500");
}

function imgPecas(img, nova_img) {
    document.getElementById(img).src = nova_img;
}

function janelaFechar() {
    close();
}

//AD2 Exercício 02
//Bicicletas.html
vet_nomeBike = new Array(4);
vet_nomeBike[0] = "MTB VOLT 1.6 PT/AM";
vet_nomeBike[1] = "CALOI CECI BRANCA";
vet_nomeBike[2] = "POTY Branca/Vermelho";
vet_nomeBike[3] = "CALOI Sport T19 V21";
vet_imgBike = new Array(4);
vet_imgBike[0] = "Imagens/Bike_MTB_ARO16.jpg";
vet_imgBike[1] = "Imagens/Bike_Caloi_ARO16.jpg";
vet_imgBike[2] = "Imagens/Bike_Poty_ARO26.jpg";
vet_imgBike[3] = "Imagens/Bike_Caloi_ARO26.jpg";
vet_precoBike = new Array(4);
vet_precoBike[0] = "R$ 490,00";
vet_precoBike[1] = "R$ 469,00";
vet_precoBike[2] = "R$ 489,00";
vet_precoBike[3] = "R$ 880,00";

function modeloBike(bike, nome, img, preco) {
    if (document.getElementById(bike).innerHTML == "MTB VOLT 1.6 PT/AM") {
        document.getElementById(nome).innerHTML = vet_nomeBike[0];
        document.getElementById(img).src = vet_imgBike[0];
        document.getElementById(preco).innerHTML = vet_precoBike[0];
    }
    if (document.getElementById(bike).innerHTML == "CALOI CECI BRANCA") {
        document.getElementById(nome).innerHTML = vet_nomeBike[1];
        document.getElementById(img).src = vet_imgBike[1];
        document.getElementById(preco).innerHTML = vet_precoBike[1];
    }
    if (document.getElementById(bike).innerHTML == "POTY Branca/Vermelho") {
        document.getElementById(nome).innerHTML = vet_nomeBike[2];
        document.getElementById(img).src = vet_imgBike[2];
        document.getElementById(preco).innerHTML = vet_precoBike[2];
    }
    if (document.getElementById(bike).innerHTML == "CALOI Sport T19 V21") {
        document.getElementById(nome).innerHTML = vet_nomeBike[3];
        document.getElementById(img).src = vet_imgBike[3];
        document.getElementById(preco).innerHTML = vet_precoBike[3];
    }
}

//AD2 Exercício 03
//Cadastro.html
function validaTelefone() {
    var telefone = document.getElementById(tel).innerHTML;
    var celular = document.getElementById(cel).value;
    if (telefone.length != 8) {
        alert("Telefone Fixo tem de ter 8 digitos!" + telefone.length);
    } else {
        validaDigito(telefone);
    }

    if (celular.length != 9) {
        alert("Telefone Celular tem de ter 9 digitos!" + celular.length);
    } else {
        validaDigito(celular);
    }
}

function validaDigito(numero) {
    for (i = 0; i < numero.length; i++) {
        if ((numero.charCodeAt(i) < 48) || (numero.charCodeAt(i) > 57)) {
            alert("Telefone só pode ter digitos, caracter " + numero.charAt(i) + " inválido!");
            return;
        }
    }
}

//AD2 Exercício 04
//Compras.html
class infoProduto {
    constructor(info, preco) {
        this.info = info;
        this.preco = preco;
    }
}

vet_Tipo = new Array(5);
vet_Tipo[0] = "Guidom";
vet_Tipo[1] = "Selim";
vet_Tipo[2] = "Pedal";
vet_Tipo[3] = "Bike16";
vet_Tipo[4] = "Bike26";
vet_Info = new Array(9);
vet_Info[0] = new infoProduto("Alumínio CB", "35,00");
vet_Info[1] = new infoProduto("Alumínio Speed", "130,00");
vet_Info[2] = new infoProduto("RAD 7 Comfort", "49,00");
vet_Info[3] = new infoProduto("SERFAS DDMD-200", "199,00");
vet_Info[4] = new infoProduto("Inglês Alumínio", "27,00");
vet_Info[5] = new infoProduto("MTB VOLT 1.6 PT/AM", "490,00");
vet_Info[6] = new infoProduto("CALOI CECI BRANCA", "469,00");
vet_Info[7] = new infoProduto("POTY Br/Vm", "489,00");
vet_Info[8] = new infoProduto("CALOI Sport T19 V21", "880,00");

function criaLista() {
    var lista = document.getElementById("selProduto");

    var optGroup0 = document.createElement("optgroup");
    optGroup0.value = "0";
    optGroup0.text = " ----- ";
    lista.add(optGroup0, lista.options[0]);

    var optGroup1 = document.createElement("option");
    optGroup1.value = "1";
    optGroup1.text = vet_Tipo[0];
    lista.add(optGroup1, lista.options[1]);

    var optGroup2 = document.createElement("option");
    optGroup2.value = "2";
    optGroup2.text = "Selim";
    lista.add(optGroup2, lista.options[2]);

    var optGroup3 = document.createElement("option");
    optGroup3.value = "3";
    optGroup3.text = "Pedal";
    lista.add(optGroup3, lista.options[3]);
}
