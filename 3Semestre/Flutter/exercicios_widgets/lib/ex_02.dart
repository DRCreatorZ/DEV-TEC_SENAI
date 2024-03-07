// ignore_for_file: prefer_const_constructors, prefer_const_literals_to_create_immutables

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Exercicio 02',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Exercicio 02'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              Container(
                height: 50,
                margin: EdgeInsets.all(5),
                padding: EdgeInsets.all(10),
                color: Colors.green,
                child: Center(
                  child: Text(
                    'Organização com Row e Column:',
                    style: TextStyle(
                      color: Color.fromARGB(255, 201, 255, 205),
                      fontSize: 16,
                    ),
                  ),
                ),
              ),
              Container(
                // height: 100,
                margin: EdgeInsets.all(5),
                padding: EdgeInsets.all(10),
                color: Colors.blue,
                child: Center(
                  child: Text(
                    'Desenvolva uma interface que faça uso dos widgets Row e Column para organizar elementos de forma horizontal e vertical.Adicione diversos widgets (como Text, Icon e Image) para demonstrar a organização.',
                    style: TextStyle(
                      color: Color.fromARGB(255, 217, 227, 255),
                      fontSize: 16,
                    ),
                  ),
                ),
              ),
              SizedBox(height: 20),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: <Widget>[
                  Icon(Icons.more_vert, size: 50, color: Colors.yellow),
                  Icon(Icons.drag_indicator, size: 50, color: Colors.yellow),
                  Icon(Icons.apps, size: 50, color: Colors.yellow),
                ],
              ),
              SizedBox(height: 20),
              Column(
                children: <Widget>[
                  Image.asset('../lib/assets/senai.png', width: 150),
                  Text(
                    'SENAI',
                    style: TextStyle(fontSize: 30, color: Colors.red),
                  ),
                  Image.asset(
                    '../lib/assets/senai.png',
                    width: 150,
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    );
  }
}
