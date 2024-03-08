import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: AnimatedContainerExample(),
    );
  }
}

class AnimatedContainerExample extends StatefulWidget {
  @override
  _AnimatedContainerExampleState createState() => _AnimatedContainerExampleState();
}

class _AnimatedContainerExampleState extends State<AnimatedContainerExample> {
  Color _containerColor = Colors.blue;

  void _changeColor() {
    setState(() {
      // Altera a cor para uma cor aleatória
      _containerColor = Colors.primaries[Random().nextInt(Colors.primaries.length)];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Animação de Cor'),
      ),
      body: Center(
        child: GestureDetector(
          onTap: _changeColor,
          child: AnimatedContainer(
            duration: Duration(seconds: 1),
            width: 200,
            height: 200,
            color: _containerColor,
            child: Center(
              child: Text(
                'Clique para Mudar de Cor',
                style: TextStyle(color: Colors.white),
              ),
            ),
          ),
        ),
      ),
    );
  }
}
