void main() {
  //Adicionar Comentários
  /*
  Comentários em várias linhas
   */
  print("Hello World ");

  //Criação de variáveis
  var nome = "Fernando Dias";
  var idade = 36;
  var altura = 1.74;
  var listaNomes = ["Fernando", "Lucas", "Ana", "Rosa"];
  var listaDynamic = ["Lucas", 1.45, 23, [1,2,3,4]];
  var objMap = {'id' : 1, 'valor': 'Olá'};

  print(nome.runtimeType);
  print(idade.runtimeType);
  print(altura.runtimeType);
  print(listaNomes.runtimeType);
  print(listaDynamic.runtimeType);
  print(objMap.runtimeType);

  //CONDIÇÕES

  if(idade >= 18){
    print("É maior de idade");
  } else if(idade >= 65) {
    print("É idoso");
  }else{
    print("É criança ou menor");
  }

  //LOOP
  for(final nome in listaNomes) {
    print('Meu nome: ${nome}');
  }

  for(int mes = 1; mes <= 12; mes++){
    print('Mês: ${mes}');
  }

  while(idade < 40){
    idade++;
    print('Idade aumentando: ${idade}');
  }

  //Funções

  //Retorno - Nome da função - (parâmetros)
  String concatenarStringComVirgula(String valor1, String valor2) {
    return '${valor1},$valor2';
  }

  var minhaFuncao = concatenarStringComVirgula("Fernando", "20");
  print(minhaFuncao);

  bool filtrarString(Object item){
    return item.runtimeType == String;
  }
  
  var filtroComFuncaoNormal = listaDynamic.where(filtrarString).toList();

  //(obj){
    //return
  // }
  var filtroComFuncao = listaDynamic.where((item) {
    return item.runtimeType == String;
  }).toList();
  
  var listaFitro = listaDynamic.where(
          (item) => item.runtimeType == String).toList();

  print(listaFitro);
  print(filtroComFuncaoNormal);
  print(filtroComFuncao);

  //CHAMADA DAS CLASSES

  Eletronico eletronico = Eletronico(220, false);
  eletronico.ligar();
  print('Eletro esta ligado: ${eletronico.estaLigado()}');

  eletronico = Geladeira(110, false);
  print('Geladeira esta ligado? -> ${eletronico.estaLigado()}');

  if(eletronico is Geladeira){
    // (eletronico as Geladeira).refrigerar();
    (eletronico as Geladeira).ligar();
  }

  print('Geladeira esta ligado? -> ${eletronico.estaLigado()}');


  Televisao tv = Televisao(220, true);
  tv.conectar5G();
  
}

//CLASSE - !!! CRIE FORA DO MÉTODO MAIN  !!!

class Eletronico {
  //Propriedades
  int voltagem;
  bool ligado;

  //Construtor da classe
  Eletronico(this.voltagem, this.ligado);

  //Métodos
  bool estaLigado(){
    return ligado;
  }
  void ligar(){
    ligado = true;
  }
  void desligar(){
    ligado = false;
  }
}

class Geladeira extends Eletronico implements DispositivoInterface {

  Geladeira(super.voltagem, super.ligado);

  void refrigerar(){
    print("Refrigerando...");
  }

  void congelar() {
    print("Congelando...");
  }

  @override
  void ligar(){
    super.ligar();
    refrigerar();
  }

  @override
  int getAnosGarantia() {
    return 2;
  }

  @override
  String getMarca() {
    return "BRASTEMP";
  }


}

class Televisao extends Eletronico with Conexao {

  Televisao(super.voltagem, super.ligado);

  void assistir(){
    print("Vendo Tv...");
  }

  void conectarWifi(){
    print("Conectando ...");
  }

  void desconectarWifi() {
    print("Desconectando ...");
  }

}

mixin Conexao {

  void conectar5G(){
    print("Conectando ao 5G....");
  }
}

abstract class DispositivoInterface {

  int getAnosGarantia(){
    return 3;
  }

  String getMarca();

}


//ATIVIDADE

// Escreva uma função que retorne a soma de 2 números.
// Escreva uma função que receba um ano (int) e retorne o século daquele ano.


  double somaNumeros(double n1, double n2) {
    return n1 + n2;
  }
  
  print(somaNumeros(10,1));
  
  int getSeculoAno(int ano){
    return (ano%100) == 0 ? (ano/100).toInt() : (ano/100).toInt() +1;
  }
  
  
  int getSeculoAnoCeil(int ano) {
    return (ano/100).ceil();
  }
  
  print(getSeculoAnoCeil(2000));




