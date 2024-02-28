// ignore_for_file: file_names

import 'package:flutter/material.dart';
import 'package:lista_compras/ComprasModel.dart';

class ComprasController extends ChangeNotifier {
  final List<Compras> _tarefas = [];
  List<Compras> get compras => _tarefas;

  //metodo para adiconar  uma nova compra
  void adicionarItem(String descricao) {
    if (descricao.isNotEmpty) {
      _tarefas.add(Compras(descricao, false));
      notifyListeners();
    }
  }

  void marcarComoComprado(int indice) {
    if (indice >= 0 && indice < _tarefas.length) {
      _tarefas[indice].concluida = true;
      notifyListeners();
    }
  }

  void desmarcarComoComprado(int indice) {
    if (indice >= 0 && indice < _tarefas.length) {
      _tarefas[indice].concluida = false;
      notifyListeners();
    }
  }

  void excluirItem(int indice) {
    if (indice >= 0 && indice < _tarefas.length) {
      _tarefas.removeAt(indice);
      // Notifica os ouvintes sobre a mudança no estado
      notifyListeners();
    }
  }

  void excluirTodosItens() {
    _tarefas.clear();
    // Notifica os ouvintes sobre a mudança no estado
    notifyListeners();
  }

// Método para ordenar a lista por ordem alfabética
  void ordemAZ() {
    _tarefas.sort((a, b) => a.descricao.compareTo(b.descricao));
    notifyListeners();
  }
}
