import 'package:app_carros/view.dart';
import 'package:flutter/material.dart';
import 'package:app_carros/model.dart';
import 'package:app_carros/controller.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  final CarrosController controllerCarros = CarrosController();
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Gerenciador de Carros',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: TelaListaCarros(controllerCarros),
    );
  }
}
