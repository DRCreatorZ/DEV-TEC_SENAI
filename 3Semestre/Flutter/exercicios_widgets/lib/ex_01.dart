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
          color: const Color.fromARGB(255, 39, 54, 67),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Container(
                height: 100,
                margin: EdgeInsets.all(5),
                padding: EdgeInsets.all(10),
                color: Color.fromARGB(255, 22, 168, 115),
                child: Center(
                  child: Text(
                    'CONTAINER 1',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 26,
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
                color: Color.fromARGB(255, 209, 81, 22),
                child: Center(
                  child: Text(
                    'CONTAINER 2',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 26,
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
                color: Color.fromARGB(255, 7, 106, 188),
                child: Center(
                  child: Text(
                    'CONTAINER 3',
                    style: TextStyle(
                      color: Colors.white,
                      fontSize: 26,
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
