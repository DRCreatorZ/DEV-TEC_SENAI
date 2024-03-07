// ignore_for_file: prefer_const_constructors, use_key_in_widget_constructors

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Exercicio 01'),
        ),
        body: Container(
          color: Colors.blue,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                height: 100,
                margin: EdgeInsets.all(5),
                padding: EdgeInsets.all(10),
                color: Colors.green,
                child: Center(
                  child: Text(
                    'Layout Básico com Container:',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                    ),
                  ),
                ),
              ),
              SizedBox(height: 10),
              Container(
                height: 100,
                margin: EdgeInsets.all(5),
                padding: EdgeInsets.all(10),
                color: Colors.orange,
                child: Center(
                  child: Text(
                    'Crie um aplicativo Flutter que utilize o widget Container para criar um layout básico.',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                      fontStyle: FontStyle.italic,
                    ),
                  ),
                ),
              ),
              SizedBox(height: 10),
              Container(
                height: 100,
                margin: EdgeInsets.all(5),
                padding: EdgeInsets.all(10),
                color: const Color.fromARGB(255, 255, 0, 89),
                child: Center(
                  child: Text(
                    'Adicione pelo menos três widgets filhos dentro do Container com diferentes estilos e cores.',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 16,
                      fontStyle: FontStyle.italic,
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
