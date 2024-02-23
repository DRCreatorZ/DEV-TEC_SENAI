import 'package:flutter/material.dart';
import 'package:lista_compras/ComprasController.dart';
import 'package:lista_compras/ComprasView.dart';
import 'package:provider/provider.dart';

class ComprasApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      //Definindo a tela inicial como a Compras
      home: ChangeNotifierProvider(
        create: (context) => ComprasController(),
        child: ComprasScreen(),
      ),
    );
  }
}
