// ignore_for_file: prefer_final_fields

import 'package:app_carros/model.dart';

class CarrosController {
  //atributos
  List<Carro> _carrosLista = [
    Carro("Fiat Uno", 1991, "lib/img/uno_1991.jpg"),
    Carro("Fiat Duo", 1999, "img2"),
  ];

  //métodos
  List<Carro> get listarCarros => _carrosLista;

  //metodos void
  void adicionarCarro(String modelo, int ano, String imagemUrl) {
    Carro carro = Carro(modelo, ano, imagemUrl);
    _carrosLista.add(carro);
  }
}
