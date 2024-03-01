// ignore_for_file: prefer_final_fields

import 'package:app_carros/model.dart';

class CarrosController {
  //atributos
  List<Carro> _carrosLista = [];

  //métodos
  List<Carro> get listarCarros => _carrosLista;

  //metodos void
  void adicionarCarro(String modelo, int ano, String imagemUrl) {
    Carro carro = Carro(modelo, ano, imagemUrl);
    _carrosLista.add(carro);
  }
}
