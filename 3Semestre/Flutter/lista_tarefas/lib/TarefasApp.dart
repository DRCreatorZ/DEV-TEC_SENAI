import 'package:flutter/material.dart';
import 'package:lista_tarefas/TarefasController.dart';
import 'package:lista_tarefas/TarefasView.dart';
import 'package:provider/provider.dart';

class TarefasApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      //Definindo a tela inicial como a Tarefas
      home: ChangeNotifierProvider(
        create: (context) => TarefasController(),
        child: TarefasScreen(),
      ),
    );
  }
}
