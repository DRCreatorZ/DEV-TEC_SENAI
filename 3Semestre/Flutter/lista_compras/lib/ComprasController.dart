// import 'package:app_todolist_02_22/main.dart';
// import 'package:app_todolist_02_22/tarefas_model.dart';
import 'package:flutter/material.dart';
import 'package:lista_compras/ComprasModel.dart';

class ComprasController extends ChangeNotifier {
  List<Compras> _tarefas = [];
  List<Compras> get compras => _tarefas;

  //metodo para adiconar  uma nova compra
  void adicionarTarefa(String descricao) {
    if (descricao.isNotEmpty) {
      _tarefas.add(Compras(descricao, false));
      notifyListeners();
    }
  }

  void marcarComoConcluida(int indice) {
    if (indice >= 0 && indice < _tarefas.length) {
      _tarefas[indice].concluida = true;
      notifyListeners();
    }
  }

  void desmarcarComoConcluida(int indice) {
    if (indice >= 0 && indice < _tarefas.length) {
      _tarefas[indice].concluida = false;
      notifyListeners();
    }
  }

  void excluirTarefa(int indice) {
    if (indice >= 0 && indice < _tarefas.length) {
      _tarefas.remove(indice);
      // Notifica os ouvintes sobre a mudança no estado
      notifyListeners();
    }
  }
}
